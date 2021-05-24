package org.akiapps.news.base

import androidx.lifecycle.ViewModel
import org.akiapps.news.repository.DataRepository

abstract class BaseViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getDatRepo() = dataRepository

}