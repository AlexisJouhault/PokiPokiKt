package com.codercats.pokipoki.home.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codercats.pokipoki.base.presentation.core.ViewPagerFragment
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.data.di.HomeModule
import com.codercats.pokipoki.home.presentation.contracts.HomeContract
import com.codercats.pokipoki.home.presentation.presenters.HomePresenter
import org.koin.android.ext.android.inject

/**
 * Created by Alexis on 07/11/2017.
 *
 */
class HomeFragment : ViewPagerFragment(), HomeContract.View {

    override val contextName: String
        get() = HomeModule.CTX_HOME_MODULE

    override val presenter by inject<HomePresenter>()

    companion object {

        val POSITION = 0

        fun newInstance(): HomeFragment {
            return ViewPagerFragment.newInstance(POSITION, HomeFragment()) as HomeFragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        presenter.view = this

        return view
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