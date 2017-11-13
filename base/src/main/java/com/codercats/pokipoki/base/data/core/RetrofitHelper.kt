package com.codercats.pokipoki.base.data.core

import com.codercats.pokipoki.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Alexis on 09/11/2017.
 *
 */
interface RetrofitHelper {

    companion object {

        const val END_POINT = "/v1"
        const val QUERY_NAME = "name"

        fun build() : Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BuildConfig.API_HOST)
                    .addConverterFactory(GsonConverterFactory.create(createGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createClient())
                    .build()
        }

        private fun createClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder().addInterceptor(logging).build()
        }

        private fun createGson(): Gson {
            return GsonBuilder()
                    .setLenient()
                    .create()
        }

    }
}