package com.Tagger.taager.data.network

import com.Tagger.taager.data.core.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {
    private val httpLoggingInterceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }



    private val client = addTimeOut(OkHttpClient.Builder())
        .followRedirects(false)
        .followSslRedirects(false)
        .addInterceptor(httpLoggingInterceptor)
        .build()


    fun getService(): Endpoints {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Endpoints::class.java)
    }

    private fun addTimeOut(httpClient: OkHttpClient.Builder): OkHttpClient.Builder {
        return httpClient.connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(0, TimeUnit.SECONDS)
            .readTimeout(0, TimeUnit.SECONDS)
            .writeTimeout(0, TimeUnit.SECONDS)
    }

}