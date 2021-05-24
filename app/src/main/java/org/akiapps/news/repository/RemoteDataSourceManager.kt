package org.akiapps.news.repository

import org.akiapps.news.base.BaseRemoteStorageManager
import org.akiapps.news.base.Resource
import org.akiapps.news.network.NetworkManager
import org.akiapps.news.network.ResponseObject
import retrofit2.HttpException
import javax.inject.Inject

class RemoteDataSourceManager  @Inject constructor() :RemoteStorageHelper, BaseRemoteStorageManager() {

    @Inject lateinit var networkManager: NetworkManager

    suspend fun getIndianBreakingNewsList(onSuccess:(ResponseObject)-> Unit,onNetworkFailure:(Int,String?)-> Unit){
        try {
           onSuccess(networkManager.getIndiaHeadLines())
        }catch (thr:Throwable){
            thr.printStackTrace()
            if(thr is HttpException){
                onNetworkFailure(thr.code(),thr.response()?.message())
            }else {
                onNetworkFailure(101,thr.localizedMessage)
            }
        }
    }

    override suspend fun getIndiaArticles(): Resource<ResponseObject> = safeApiCall { networkManager.getIndiaHeadLines() }
}
