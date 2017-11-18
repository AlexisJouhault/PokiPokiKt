package com.codercats.pokipoki.base.presentation.core.views

/**
 * Created by Alexis on 08/11/2017.
 *
 */
interface LoadDataView<T> {

    val presenter : T

    fun showLoading()
    fun hideLoading()
    fun showError(code: Int)
}