package com.codercats.pokipoki.home.presentation.contracts

import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.presentation.core.BasePresenter
import com.codercats.pokipoki.base.presentation.core.views.ListContentView

/**
 * Created by Alexis on 15/11/2017.
 *
 */
interface SearchContract {

    interface View : ListContentView<Card, Presenter> {

    }

    interface Presenter : BasePresenter<View> {
        fun searchForCards(query: CharSequence)
        fun handleSearchResult(result: List<Card>)
    }
}