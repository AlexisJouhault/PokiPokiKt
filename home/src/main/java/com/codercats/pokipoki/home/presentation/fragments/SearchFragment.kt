package com.codercats.pokipoki.home.presentation.fragments

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.presentation.core.fragments.ViewPagerFragment
import com.codercats.pokipoki.base.presentation.core.utils.GridUtils
import com.codercats.pokipoki.base.presentation.core.utils.RxUtils
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.data.di.SearchModule
import com.codercats.pokipoki.home.presentation.adapters.CardListAdapter
import com.codercats.pokipoki.home.presentation.contracts.SearchContract
import com.codercats.pokipoki.home.presentation.presenters.SearchPresenter
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject

/**
 * Created by Alexis on 07/11/2017.
 *
 */
class SearchFragment : ViewPagerFragment(), SearchContract.View, ListContentView.OnItemClickListener<Card> {

    override val contextName: String
        get() = SearchModule.CTX_SEARCH_MODULE

    override val presenter by inject<SearchPresenter>()
    private val adapter = CardListAdapter(this)

    companion object {

        val POSITION = 1

        fun newInstance(): SearchFragment {
            return ViewPagerFragment.newInstance(POSITION, SearchFragment()) as SearchFragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        presenter.view = this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        results.layoutManager = GridLayoutManager(context, GridUtils.DEFAULT_SPAN)
        results.adapter = adapter
        RxUtils.subscribeToSearchView(searchview, presenter::searchForCards)
        presenter.initialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroy()
    }

    override fun showContent(content: List<Card>) {
        adapter.setItems(content)
    }

    override fun showError(code: Int) {
    }

    override fun onItemClick(item: Card) {

    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

}