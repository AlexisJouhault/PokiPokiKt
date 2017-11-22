package com.codercats.pokipoki.base.domain.sets.model

import com.codercats.pokipoki.base.presentation.core.adapters.ViewType
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType.Companion.SET

/**
 * Created by Alexis on 22/11/2017.
 *
 */
data class Set(val logo: String) : ViewType {
    override val viewType = SET
}