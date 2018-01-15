package com.codercats.pokipoki.base.data.core.exceptions

import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils.Messages.Network.DEFAULT_NETWORK_ERROR
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils.Messages.Network.EMPTY_RESULT
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils.Messages.Network.INTERNAL_ERROR
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils.Messages.Network.NOT_FOUND

/**
 * Created by Alexis on 13/01/2018.
 *
 */
class NetworkException(val code: Int = -1) : Exception() {

    override val message: String
        get() = generateMessageFromCode(code)

    private fun generateMessageFromCode(code: Int): String {
        when(code) {
            400 -> return NOT_FOUND
            405 -> return INTERNAL_ERROR
            Codes.NO_CONTENT -> return EMPTY_RESULT
        }
        return DEFAULT_NETWORK_ERROR
    }

    class Codes {

        companion object {
            val NO_CONTENT = 400004
        }
    }
}