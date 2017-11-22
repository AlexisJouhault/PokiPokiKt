package com.codercats.pokipoki.base.presentation.core.adapters

/**
 * Created by Alexis on 16/11/2017.
 *
 */
interface ViewType {

    val viewType : Int

    companion object {
        val CARD = 0
        val SET = 1
    }
}