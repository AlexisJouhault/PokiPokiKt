package com.codercats.pokipoki.home.presentation.presenters

import com.codercats.pokipoki.base.domain.core.DefaultUseCaseObserver
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
        getHomeContent.execute(DefaultUseCaseObserver<List<HomeSection>>(this, this::handleSectionsResult))
    }

    override fun destroy() {
        getHomeContent.dispose()
    }

    override fun handleSectionsResult(homeSections: List<HomeSection>) {
        if (!homeSections.isEmpty()) {
            view.showContent(homeSections)
        }
    }

    override fun error(message: String) {
        view.hideLoading()
        view.showError(message)
    }

    override fun taskComplete() {
        view.hideLoading()
    }
}