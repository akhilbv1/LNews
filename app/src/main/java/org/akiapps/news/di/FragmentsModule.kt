package org.akiapps.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.akiapps.news.country.CountryArticlesListFragment

@Module
abstract class FragmentsModule {

    @CoursesActivityScope
    @ContributesAndroidInjector
    abstract fun bindCountriesFragment():CountryArticlesListFragment
}