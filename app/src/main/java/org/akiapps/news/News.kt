package org.akiapps.news

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import org.akiapps.news.di.DaggerApplicationComponent

class News : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return  DaggerApplicationComponent.factory().create(applicationContext)
    }
}