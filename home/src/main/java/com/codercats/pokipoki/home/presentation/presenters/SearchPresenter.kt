package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.home.presentation.contracts.SearchContract

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class SearchPresenter(private val searchForCards: SearchForCards) : SearchContract.Presenter {

    override lateinit var view: SearchContract.View

    override fun initialize() {
        view.showLoading()
    }

    override fun destroy() {
    }

    override fun handleSearchResult(result: List<Card>) {
    }
}