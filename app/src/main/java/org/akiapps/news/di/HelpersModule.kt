package org.akiapps.news.di

import dagger.Binds
import dagger.Module
import org.akiapps.news.repository.LocalDataStoreManager
import org.akiapps.news.repository.LocalStorageHelper
import org.akiapps.news.repository.RemoteDataSourceManager
import org.akiapps.news.repository.RemoteStorageHelper

@Module
abstract class HelpersModule{
    @Binds
    abstract fun bindRemoteDataSourceHelper(remoteDataSourceManager: RemoteDataSourceManager):RemoteStorageHelper
    @Binds
    abstract fun bindLocalDataSourceHelper(localDataStoreManager: LocalDataStoreManager):LocalStorageHelper
}