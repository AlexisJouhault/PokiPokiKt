package com.codercats.pokipoki.base.presentation.core.utils

/**
 * Created by Alexis on 16/11/2017.
 *
 */
object ErrorUtils {

    val UNKNOWN = 0
    val NO_CONTENT = 1001
    val NETWORK = 1002


    fun getErrorCode(exception: Throwable): Int {
        return UNKNOWN
    }

}