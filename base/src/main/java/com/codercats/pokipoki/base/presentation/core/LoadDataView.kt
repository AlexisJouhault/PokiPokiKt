package com.codercats.pokipoki.base.presentation.core

/**
 * Created by Alexis on 08/11/2017.
 *
 */
interface LoadDataView<T> {
    fun showLoading()
    fun hideLoading()

    val presenter : T

}