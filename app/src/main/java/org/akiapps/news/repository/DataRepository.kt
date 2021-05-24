package org.akiapps.news.repository

import org.akiapps.news.base.Resource
import org.akiapps.news.network.ResponseObject
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val localStorageHelper: LocalStorageHelper,
    private val remoteStorageHelper: RemoteStorageHelper
) :  LocalStorageHelper, RemoteStorageHelper {

    override suspend fun getSampleString(): String  = localStorageHelper.getSampleString()

    override suspend fun getIndiaArticles(): Resource<ResponseObject>  = remoteStorageHelper.getIndiaArticles()

}