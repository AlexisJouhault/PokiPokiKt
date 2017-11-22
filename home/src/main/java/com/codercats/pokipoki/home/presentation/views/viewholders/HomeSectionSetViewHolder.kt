package com.codercats.pokipoki.home.presentation.views.viewholders

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.domain.home.model.HomeSection
import com.codercats.pokipoki.home.presentation.views.GlideApp
import kotlinx.android.synthetic.main.viewtype_homesection_set.view.*

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class HomeSectionSetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(homeSection: HomeSection) {
        GlideApp.with(itemView.context)
                .load(homeSection.cover)
                .placeholder(ContextCompat.getDrawable(itemView.context, R.drawable.set_placeholder))
                .into(itemView.thumbnail)
        itemView.title.text = itemView.resources.getString(R.string.latest_set_title)
    }
}