package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.core.DefaultObserver
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils
import com.codercats.pokipoki.home.domain.home.interactor.GetHomeContent
import com.codercats.pokipoki.home.domain.home.model.HomeSection
import com.codercats.pokipoki.home.presentation.contracts.HomeContract

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class HomePresenter(private val getHomeContent: GetHomeContent): HomeContract.Presenter {

    override lateinit var view: HomeContract.View

    override fun initialize() {
        view.showLoading()
        getHomeContent.execute(DefaultObserver<List<HomeSection>>(this, this::handleSectionsResult))
    }

    override fun destroy() {
        getHomeContent.dispose()
    }

    override fun handleSectionsResult(homeSections: List<HomeSection>) {
        if (!homeSections.isEmpty()) {
            view.showContent(homeSections)
        } else {
            view.showError(ErrorUtils.NO_CONTENT)
        }
    }

    override fun error(code: Int) {
        view.hideLoading()
        view.showError(code)
    }

    override fun taskComplete() {
        view.hideLoading()
    }
}