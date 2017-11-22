package com.codercats.pokipoki.home.presentation.adapters

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.codercats.pokipoki.base.presentation.core.adapters.BaseAdapter
import com.codercats.pokipoki.base.presentation.core.adapters.DelegateAdapter
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType.Companion.CARD
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType.Companion.SET
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.domain.home.model.HomeSection

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class HomeSectionsAdapter(private val onItemClickListener: ListContentView.OnItemClickListener<HomeSection>) : BaseAdapter() {

    init {
        adapters.put(ViewType.SET, HomeSectionSetDelegateAdapter(onItemClickListener) as DelegateAdapter<RecyclerView.ViewHolder, ViewType>)
    }

    inner class HomeSpanSizeLookup : GridLayoutManager.SpanSizeLookup() {

        override fun getSpanSize(position: Int): Int {
            when (items[position].viewType) {
                SET -> return 3
                CARD -> return 1
                else -> return 1
            }
        }

    }

}