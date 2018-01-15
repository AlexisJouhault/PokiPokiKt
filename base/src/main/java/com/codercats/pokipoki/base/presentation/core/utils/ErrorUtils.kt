package com.codercats.pokipoki.base.presentation.core.utils

import com.codercats.pokipoki.base.data.core.exceptions.NetworkException
import com.codercats.pokipoki.base.data.core.exceptions.UnavailableContentException

/**
 * Created by Alexis on 16/11/2017.
 *
 */
object ErrorUtils {

    object Messages {
        val DEFAULT = "An error occurred"

        object Network {
            //todo : make better error messages
            val DEFAULT_NETWORK_ERROR = "An error occurred while fetching data, please check your internet connection"
            val NOT_FOUND = "Not found"
            val INTERNAL_ERROR = "Something went wrong"
            val EMPTY_RESULT = "Could nt find any results matching request"

        }

    }

    object Codes {
        val UNKNOWN = 0
        val NO_CONTENT = 1001
        val NETWORK = 1002
    }
}