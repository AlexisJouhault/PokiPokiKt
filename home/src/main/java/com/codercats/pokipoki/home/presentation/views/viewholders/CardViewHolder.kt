package com.codercats.pokipoki.home.presentation.views.viewholders

import android.support.v4.content.ContextCompat
import android.view.View
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.presentation.core.views.BaseViewHolder
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.presentation.views.GlideApp
import kotlinx.android.synthetic.main.viewtype_card.view.*

/**
 * Created by Alexis on 16/11/2017.
 *
 */
class CardViewHolder(itemView: View) : BaseViewHolder<Card>(itemView) {

    override public fun bind(item: Card, onItemClickListener: ListContentView.OnItemClickListener<Card>) {
        itemView.setOnClickListener { v -> onItemClickListener.onItemClickWithTransition(item, itemView.thumbnail) }
        bind(item)
    }

    override fun bind(item: Card) {
        GlideApp.with(itemView.context)
                .load(item.url)
                .placeholder(ContextCompat.getDrawable(itemView.context, R.drawable.placeholder))
                .into(itemView.thumbnail)
    }

}