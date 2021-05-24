package org.akiapps.news.base

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val message: String?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()

    fun checkResponse(onSuccess: (Success<T>) -> Unit, onError: (Failure) -> Unit) {
        when (this) {
            is Success -> onSuccess(this)
            is Failure -> onError(this)
        }
    }
}

abstract class BaseRemoteStorageManager {
    private val TAG = "BaseRepository"
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                throwable.printStackTrace()

                when (throwable) {
                    is HttpException -> {
                        Log.e(TAG, "Code : ${throwable.code()}, Msg : ${throwable.message()}")
                        Resource.Failure(
                            false,
                            throwable.code(),
                            null,
                            throwable.response()?.errorBody()
                        )
                    }
                    else -> Resource.Failure(true, null, null, null)
                }
            }
        }
    }
}