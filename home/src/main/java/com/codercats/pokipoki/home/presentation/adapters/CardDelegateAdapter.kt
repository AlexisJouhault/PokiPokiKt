package com.codercats.pokipoki.home.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.presentation.core.adapters.DelegateAdapter
import com.codercats.pokipoki.base.presentation.core.views.ListContentView
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.presentation.views.viewholders.CardViewHolder

/**
 * Created by Alexis on 16/11/2017.
 *
 */
class CardDelegateAdapter(val onItemClickListener: ListContentView.OnItemClickListener<Card>) : DelegateAdapter<CardViewHolder, Card> {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewtype_card, parent, false))
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, item: Card) {
        viewHolder.bind(item, onItemClickListener)
    }
}