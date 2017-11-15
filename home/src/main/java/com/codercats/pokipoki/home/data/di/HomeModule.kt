package com.codercats.pokipoki.home.data.di

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.home.presentation.contracts.HomeContract
import com.codercats.pokipoki.home.presentation.presenters.HomePresenter
import org.koin.android.module.AndroidModule

/**
 * Created by Alexis on 12/11/2017.
 *
 */
class HomeModule : AndroidModule() {

    override fun context() = applicationContext {

        provide {
            SearchForCards(get(), get(), get())
        }

        context(name = CTX_HOME_MODULE) {
            provide { HomePresenter(get()) } bind (HomeContract.Presenter::class)
        }

    }

    companion object {

        val CTX_HOME_MODULE = "homeModule"

    }
}