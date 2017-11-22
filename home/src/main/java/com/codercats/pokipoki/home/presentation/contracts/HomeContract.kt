package com.codercats.pokipoki.home.presentation.contracts

import com.codercats.pokipoki.base.presentation.core.BasePresenter
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.domain.home.model.HomeSection

/**
 * Created by Alexis on 12/11/2017.
 *
 */
interface HomeContract {

    interface View : ListContentView<HomeSection, Presenter> {
    }

    interface Presenter : BasePresenter<View> {
        fun handleSectionsResult(homeSections: List<HomeSection>)
    }
}