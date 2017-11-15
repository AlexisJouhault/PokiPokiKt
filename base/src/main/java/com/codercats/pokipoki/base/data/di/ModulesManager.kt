package com.codercats.pokipoki.base.data.di

import com.codercats.pokipoki.base.data.di.modules.NetworkModule
import com.codercats.pokipoki.base.data.di.modules.UseCasesModule
import com.codercats.pokipoki.base.presentation.PokiPokiApp

/**
 * Created by Alexis on 12/11/2017.
 *
 */

fun getBaseModulesList() = listOf(NetworkModule(), UseCasesModule())

public fun android.support.v7.app.AppCompatActivity.addModules(modules: kotlin.collections.List<org.koin.android.module.AndroidModule>) : kotlin.Unit {
    val application = applicationContext as PokiPokiApp

    application.resetModules(getBaseModulesList() + modules)
}

