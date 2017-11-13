package com.codercats.pokipoki.home.data.di

import com.codercats.pokipoki.home.presentation.presenters.SearchPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by Alexis on 12/11/2017.
 *
 */
class SearchModule : AndroidModule() {

    override fun context() = applicationContext {

        context(name = CTX_SEARCH_MODULE) {
            provide { SearchPresenter() }
        }
    }

    companion object {

        val CTX_SEARCH_MODULE = "searchModule"

    }
}