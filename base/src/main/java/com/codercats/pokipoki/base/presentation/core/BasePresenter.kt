package com.codercats.pokipoki.base.presentation.core

/**
 * Created by Alexis on 08/11/2017.
 *
 */
interface BasePresenter<T> {

    val view: T

    fun initialize()
    fun destroy()

    fun error(message: String)
    fun taskComplete()
}