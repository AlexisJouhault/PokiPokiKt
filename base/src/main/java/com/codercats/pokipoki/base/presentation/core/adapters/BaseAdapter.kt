package com.codercats.pokipoki.base.presentation.core.adapters

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.ViewGroup

/**
 * Created by Alexis on 16/11/2017.
 *
 */
open class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val items = ArrayList<ViewType>()
    protected val adapters = SparseArray<DelegateAdapter<RecyclerView.ViewHolder, ViewType>>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapters[items[position].viewType].onBindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapters[viewType].createViewHolder(parent)
    }

    fun setItems(new: List<ViewType>) {
        if (!items.isEmpty()) {
            items.clear()
        }
        items.addAll(new)
        notifyDataSetChanged()
    }

}