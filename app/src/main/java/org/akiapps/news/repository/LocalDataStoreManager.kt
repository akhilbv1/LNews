package org.akiapps.news.repository

import javax.inject.Inject

class LocalDataStoreManager @Inject constructor() : LocalStorageHelper {

    override suspend fun getSampleString(): String {
        return "Testing"
    }

}