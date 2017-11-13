package com.codercats.pokipoki.home.presentation.contracts

import com.codercats.pokipoki.base.presentation.core.BasePresenter
import com.codercats.pokipoki.base.presentation.core.LoadDataView

/**
 * Created by Alexis on 12/11/2017.
 *
 */
interface HomeContract {

    interface View : LoadDataView<Presenter> {
    }

    interface Presenter : BasePresenter<View> {

    }
}