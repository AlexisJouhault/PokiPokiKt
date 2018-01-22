package com.codercats.pokipoki.home.presentation.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codercats.pokipoki.base.presentation.core.fragments.ViewPagerFragment
import com.codercats.pokipoki.base.presentation.core.utils.GridUtils
import com.codercats.pokipoki.base.presentation.core.views.ErrorView
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.data.di.HomeModule
import com.codercats.pokipoki.home.domain.home.model.HomeSection
import com.codercats.pokipoki.home.presentation.adapters.HomeSectionsAdapter
import com.codercats.pokipoki.home.presentation.contracts.HomeContract
import com.codercats.pokipoki.home.presentation.presenters.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

/**
 * Created by Alexis on 07/11/2017.
 *
 */
class HomeFragment : ViewPagerFragment(), HomeContract.View, ListContentView.OnItemClickListener<HomeSection>, ErrorView.OnRetryListener {

    override val contextName: String
        get() = HomeModule.CTX_HOME_MODULE

    override val presenter by inject<HomePresenter>()
    private val adapter = HomeSectionsAdapter(this)

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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context, GridUtils.DEFAULT_SPAN)
        layoutManager.spanSizeLookup = adapter.HomeSpanSizeLookup()
        sections.layoutManager = layoutManager
        sections.adapter = adapter
        errorview.onRetryListener = this
        presenter.initialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroy()
    }

    override fun showContent(content: List<HomeSection>) {
        adapter.setItems(content)
    }

    override fun onItemClick(item: HomeSection) {

    }

    override fun onItemClickWithTransition(item: HomeSection, itemView: View) {

    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    override fun showError(message: String) {
        errorview.displayErrorMessage(message)
    }

    override fun onRetry() {
        presenter.initialize()
    }

}