package com.codercats.pokipoki.home.data.di

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.home.data.home.HomeDataRepository
import com.codercats.pokipoki.home.data.home.mapper.HomeEntityDataMapper
import com.codercats.pokipoki.home.domain.home.HomeSectionRepository
import com.codercats.pokipoki.home.domain.home.interactor.GetHomeContent
import com.codercats.pokipoki.home.presentation.contracts.HomeContract
import com.codercats.pokipoki.home.presentation.presenters.HomePresenter
import org.koin.android.module.AndroidModule

/**
 * Created by Alexis on 12/11/2017.
 *
 */
class HomeModule : AndroidModule() {

    override fun context() = applicationContext {

        provide { HomeEntityDataMapper() }
        provide { HomeDataRepository(get(), get()) } bind (HomeSectionRepository::class)

        provide { GetHomeContent(get(), get(), get()) }

        context(name = CTX_HOME_MODULE) {
            provide { HomePresenter(get()) } bind (HomeContract.Presenter::class)
        }

    }

    companion object {

        val CTX_HOME_MODULE = "homeModule"

    }
}