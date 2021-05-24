package org.akiapps.news.network

import org.akiapps.news.constants.MConstants.API_KEY
import retrofit2.http.GET

interface NetworkManager {

    @GET("v2/top-headlines?country=in&apiKey=$API_KEY")
    suspend fun getIndiaHeadLines():ResponseObject
}