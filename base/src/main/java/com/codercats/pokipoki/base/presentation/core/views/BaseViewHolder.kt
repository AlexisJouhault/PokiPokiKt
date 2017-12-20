package com.codercats.pokipoki.base.presentation.core.views

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Alexis on 20/12/2017.
 *
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){

    protected abstract fun bind(item: T, onItemClickListener: ListContentView.OnItemClickListener<T>)

    protected abstract fun bind(item: T)

}