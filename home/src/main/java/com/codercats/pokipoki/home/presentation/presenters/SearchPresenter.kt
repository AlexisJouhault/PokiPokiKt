package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.cards.interactor.SearchForCards
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.domain.core.DefaultObserver
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils
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
            searchForCards.execute(DefaultObserver<List<Card>>(this, this::handleSearchResult), query.toString())
        }
    }

    override fun handleSearchResult(result: List<Card>) {
        if (!result.isEmpty()) {
            view.showContent(result)
        } else {
            view.showError(ErrorUtils.NO_CONTENT)
        }
    }

    override fun error(code: Int) {
        view.showError(code)
    }

    override fun taskComplete() {
        view.hideLoading()
    }
}