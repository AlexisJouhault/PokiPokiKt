package com.codercats.pokipoki.home.presentation.contracts

import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.presentation.core.BasePresenter
import com.codercats.pokipoki.base.presentation.core.LoadDataView

/**
 * Created by Alexis on 15/11/2017.
 *
 */
interface SearchContract {

    interface View : LoadDataView<Presenter> {

    }

    interface Presenter : BasePresenter<View> {

        fun handleSearchResult(result: List<Card>)
    }
}