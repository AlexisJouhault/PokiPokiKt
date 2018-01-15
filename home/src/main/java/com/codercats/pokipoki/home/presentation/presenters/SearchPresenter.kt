package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.domain.core.DefaultUseCaseObserver
import com.codercats.pokipoki.home.presentation.contracts.SearchContract

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class SearchPresenter(private val searchForCards: SearchForCards) : SearchContract.Presenter {

    override lateinit var view: SearchContract.View

    override fun initialize() {
        view.hideLoading()
    }

    override fun destroy() {
        searchForCards.dispose()
    }

    override fun searchForCards(query: CharSequence) {
        if (!query.isEmpty()) {
            view.showLoading()
            searchForCards.execute(DefaultUseCaseObserver<List<Card>>(this, this::handleSearchResult), query.toString())
        }
    }

    override fun handleSearchResult(result: List<Card>) {
        if (!result.isEmpty()) {
            view.showContent(result)
        }
    }

    override fun error(message: String) {
        view.showError(message)
    }

    override fun taskComplete() {
        view.hideLoading()
    }
}