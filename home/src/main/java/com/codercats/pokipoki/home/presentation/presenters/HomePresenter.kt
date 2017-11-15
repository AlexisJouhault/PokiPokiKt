package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.domain.core.DefaultObserver
import com.codercats.pokipoki.home.presentation.contracts.HomeContract

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class HomePresenter() : HomeContract.Presenter {

    override lateinit var view: HomeContract.View

    override fun initialize() {
        view.showLoading()
    }

    override fun destroy() {
    }

    class SearchForCardsObserver : DefaultObserver<List<Card>>() {

        override fun onNext(result: List<Card>) {

        }
    }
}