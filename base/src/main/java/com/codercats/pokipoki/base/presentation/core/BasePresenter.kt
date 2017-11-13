package com.codercats.pokipoki.base.presentation.core

/**
 * Created by Alexis on 08/11/2017.
 *
 */
interface BasePresenter<T> {

    fun initialize()
    fun destroy()

    val view: T
}