package org.akiapps.news.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.akiapps.news.repository.DataRepository
import org.akiapps.news.repository.ResourceManager
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T
}