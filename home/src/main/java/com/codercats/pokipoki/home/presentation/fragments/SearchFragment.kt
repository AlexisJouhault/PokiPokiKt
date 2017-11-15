package com.codercats.pokipoki.home.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codercats.pokipoki.base.presentation.core.ViewPagerFragment
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.data.di.SearchModule
import com.codercats.pokipoki.home.presentation.contracts.SearchContract
import com.codercats.pokipoki.home.presentation.presenters.SearchPresenter
import org.koin.android.ext.android.inject

/**
 * Created by Alexis on 07/11/2017.
 *
 */
class SearchFragment : ViewPagerFragment(), SearchContract.View {

    override val contextName: String
        get() = SearchModule.CTX_SEARCH_MODULE

    override val presenter by inject<SearchPresenter>()

    companion object {

        val POSITION = 1

        fun newInstance(): SearchFragment {
            return ViewPagerFragment.newInstance(POSITION, SearchFragment()) as SearchFragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        presenter.view = this
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.initialize()
    }

    override fun onPause() {
        super.onPause()
        presenter.destroy()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}