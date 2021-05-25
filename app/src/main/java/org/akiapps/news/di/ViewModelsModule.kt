package org.akiapps.news.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.akiapps.news.base.ViewModelFactory
import org.akiapps.news.country.CountriesNewsViewModel
import org.akiapps.news.mainactivity.MainViewModel

@Module
abstract class ViewModelsModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun sampleViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountriesNewsViewModel::class)
    abstract fun bindCountriesViewModel(viewModel: CountriesNewsViewModel):ViewModel

}