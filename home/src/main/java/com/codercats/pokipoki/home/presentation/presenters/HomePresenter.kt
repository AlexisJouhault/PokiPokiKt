package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.domain.core.DefaultObserver
import com.codercats.pokipoki.home.presentation.contracts.HomeContract

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class HomePresenter(private val searchForCards: SearchForCards) : HomeContract.Presenter {

    override lateinit var view: HomeContract.View

    override fun initialize() {
        view.showLoading()
        searchForCards.execute(SearchForCardsObserver(), "test")
    }

    override fun destroy() {
        searchForCards.dispose()
    }

    fun handleResult(result: List<Card>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class SearchForCardsObserver : DefaultObserver<List<Card>>() {

        override fun onNext(result: List<Card>) {

        }
    }
}