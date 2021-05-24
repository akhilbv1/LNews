package org.akiapps.news.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.akiapps.news.constants.MConstants.BASE_API
import org.akiapps.news.network.NetworkManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    fun provideRetrofit(): NetworkManager {
        val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return Retrofit.Builder().baseUrl(BASE_API)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build()).build().create(NetworkManager::class.java)
    }
}