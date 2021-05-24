package org.akiapps.news.mainactivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.akiapps.news.base.BaseViewModel
import org.akiapps.news.base.Resource
import org.akiapps.news.network.ResponseObject
import org.akiapps.news.repository.DataRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel(dataRepository) {

    private val TAG: String = MainViewModel::class.java.simpleName

    private val _articlesLiveData: MutableLiveData<Resource<ResponseObject>> = MutableLiveData()
    val articlesLiveData: MutableLiveData<Resource<ResponseObject>>
        get() = _articlesLiveData

    private val _sampleStringLiveData: MutableLiveData<String> = MutableLiveData()
    val sampleStringLiveData:MutableLiveData<String>
    get() = _sampleStringLiveData

    fun fetchArticles() {
        viewModelScope.launch {
            _articlesLiveData.value = dataRepository.getIndiaArticles()
        }
    }

    fun fetchSampleString() {
        viewModelScope.launch {
            _sampleStringLiveData.value = dataRepository.getSampleString()
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.i(MainActivity::class.java.simpleName, "Viewmodel is cleared")
    }

}
