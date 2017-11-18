package com.codercats.pokipoki.home.presentation

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.presentation.views.GlideApp
import kotlinx.android.synthetic.main.viewtype_card.view.*

/**
 * Created by Alexis on 16/11/2017.
 *
 */
class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(card: Card) {
        GlideApp.with(itemView.context)
                .load(card.url)
                .placeholder(ContextCompat.getDrawable(itemView.context, R.drawable.placeholder))
                .into(itemView.thumbnail)
    }

}