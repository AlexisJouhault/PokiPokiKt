package com.codercats.pokipoki.base.presentation.core.views

/**
 * Created by Alexis on 16/11/2017.
 *
 */
interface ListContentView<in C, T> : LoadDataView<T> {
    fun showContent(content: List<C>)

    interface OnItemClickListener<C> {
        fun onItemClick(item: C)
    }
}