package com.codercats.pokipoki.base.domain.cards.model

import com.codercats.pokipoki.base.presentation.core.adapters.ViewType
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType.Companion.CARD

/**
 * Created by Alexis on 08/11/2017.
 *
 */
data class Card(val name: String,
                val url: String) : ViewType {

    override val viewType: Int
        get() = CARD
}