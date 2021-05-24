package org.akiapps.news.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import org.akiapps.news.News
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,ActivitiesModule::class,AppModule::class,HelpersModule::class,ViewModelsModule::class])
interface ApplicationComponent:AndroidInjector<News> {

    @Component.Factory
    interface Builder{
        fun create(@BindsInstance applicationContext:Context):ApplicationComponent
    }
}