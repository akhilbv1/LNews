package org.akiapps.news.repository

import org.akiapps.news.network.Article

interface LocalStorageHelper {
    suspend fun getSampleString():String
}