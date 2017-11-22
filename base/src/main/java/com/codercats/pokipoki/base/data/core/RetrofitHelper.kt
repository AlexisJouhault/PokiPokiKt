package com.codercats.pokipoki.base.data.core

import android.content.Context
import com.codercats.pokipoki.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by Alexis on 09/11/2017.
 *
 */
interface RetrofitHelper {

    companion object {

        const val CACHE_SIZE = 10 * 1024 * 1024L
        const val END_POINT = "/v1"
        const val QUERY_NAME = "name"

        fun build(context: Context) : Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BuildConfig.API_HOST)
                    .addConverterFactory(GsonConverterFactory.create(createGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createClient(context))
                    .build()
        }

        private fun createClient(context: Context): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .cache(Cache(context.cacheDir, CACHE_SIZE))
                    .addInterceptor(logging).build()
        }

        private fun createGson(): Gson {
            return GsonBuilder()
                    .setLenient()
                    .create()
        }

    }
}