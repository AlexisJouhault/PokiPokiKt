package com.codercats.pokipoki.base.presentation

import android.app.Application
import com.codercats.pokipoki.base.data.di.getBaseModulesList
import org.koin.Koin
import org.koin.KoinContext
import org.koin.android.ext.android.startAndroidContext
import org.koin.android.module.AndroidModule
import org.koin.standalone.releaseContext

/**
 * Created by Alexis on 09/11/2017.
 *
 */
class PokiPokiApp : Application() {


    override fun onCreate() {
        super.onCreate()
        startAndroidContext(this, getBaseModulesList())
    }

    fun resetModules(modules: List<AndroidModule>) {
        startAndroidContext(this, modules)
    }
}