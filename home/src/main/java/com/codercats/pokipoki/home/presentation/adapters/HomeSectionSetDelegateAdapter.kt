package com.codercats.pokipoki.home.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.codercats.pokipoki.base.presentation.core.adapters.DelegateAdapter
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.domain.home.model.HomeSection
import com.codercats.pokipoki.home.presentation.views.viewholders.HomeSectionSetViewHolder

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class HomeSectionSetDelegateAdapter(onItemClickListener: ListContentView.OnItemClickListener<HomeSection>) : DelegateAdapter<HomeSectionSetViewHolder, HomeSection> {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return HomeSectionSetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewtype_homesection_set, parent, false))
    }

    override fun onBindViewHolder(viewHolder: HomeSectionSetViewHolder, item: HomeSection) {
        viewHolder.bind(item)
    }
}