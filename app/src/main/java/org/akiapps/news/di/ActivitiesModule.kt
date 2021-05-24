package org.akiapps.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.akiapps.news.mainactivity.MainActivity

@Module
abstract class ActivitiesModule {

    @CoursesActivityScope
    @ContributesAndroidInjector()
    abstract fun bind():MainActivity
}