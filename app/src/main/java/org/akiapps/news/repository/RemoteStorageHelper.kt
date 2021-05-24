package org.akiapps.news.repository

import org.akiapps.news.base.Resource
import org.akiapps.news.network.ResponseObject

interface RemoteStorageHelper {
    suspend fun getIndiaArticles():Resource<ResponseObject>
}