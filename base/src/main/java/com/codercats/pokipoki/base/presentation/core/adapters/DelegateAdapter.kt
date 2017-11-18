package com.codercats.pokipoki.base.presentation.core.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Alexis on 16/11/2017.
 *
 */
interface DelegateAdapter<in T : RecyclerView.ViewHolder, in C : ViewType> {
    fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(viewHolder: T, item: C)
}