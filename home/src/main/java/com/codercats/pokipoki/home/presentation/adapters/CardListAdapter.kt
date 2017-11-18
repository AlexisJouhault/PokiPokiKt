package com.codercats.pokipoki.home.presentation.adapters

import android.support.v7.widget.RecyclerView
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.presentation.core.adapters.BaseAdapter
import com.codercats.pokipoki.base.presentation.core.adapters.DelegateAdapter
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType
import com.codercats.pokipoki.base.presentation.core.views.ListContentView

/**
 * Created by Alexis on 16/11/2017.
 *
 */
class CardListAdapter(private val onItemClickListener: ListContentView.OnItemClickListener<Card>) : BaseAdapter() {

    private val cards = ArrayList<Card>()

    init {
        adapters.put(ViewType.CARD, CardDelegateAdapter(onItemClickListener) as DelegateAdapter<RecyclerView.ViewHolder, ViewType>)
    }
}
