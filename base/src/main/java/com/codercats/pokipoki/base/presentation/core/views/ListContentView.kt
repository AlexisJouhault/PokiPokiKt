package com.codercats.pokipoki.base.presentation.core.views

import android.view.View

/**
 * Created by Alexis on 16/11/2017.
 *
 */
interface ListContentView<in C, T> : LoadDataView<T> {
    fun showContent(content: List<C>)

    interface OnItemClickListener<in C> {
        fun onItemClick(item: C)
        fun onItemClickWithTransition(item: C, itemView: View)
    }
}