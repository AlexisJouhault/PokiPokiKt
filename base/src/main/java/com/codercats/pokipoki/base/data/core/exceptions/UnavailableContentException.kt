package com.codercats.pokipoki.base.data.core.exceptions

/**
 * Created by Alexis on 14/01/2018.
 *
 */
class UnavailableContentException(message: String) : Exception(message) {

    override val message: String
        get() = "An error occurred while fetching content"

}