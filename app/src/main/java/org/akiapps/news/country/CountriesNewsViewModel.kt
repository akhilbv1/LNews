package org.akiapps.news.country

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.akiapps.news.base.BaseViewModel
import org.akiapps.news.base.Resource
import org.akiapps.news.network.ResponseObject
import org.akiapps.news.repository.DataRepository
import javax.inject.Inject

class CountriesNewsViewModel @Inject constructor(dataRepository: DataRepository) :
    BaseViewModel(dataRepository) {
    private val _articlesLiveData: MutableLiveData<Resource<ResponseObject>> = MutableLiveData()
    val articlesLiveData: MutableLiveData<Resource<ResponseObject>>
        get() = _articlesLiveData

    fun fetchArticles() {
        viewModelScope.launch {
            _articlesLiveData.value = getDatRepo().getIndiaArticles()
        }
    }
}