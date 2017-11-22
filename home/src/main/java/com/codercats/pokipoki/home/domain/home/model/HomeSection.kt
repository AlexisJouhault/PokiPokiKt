package com.codercats.pokipoki.home.domain.home.model

import com.codercats.pokipoki.base.presentation.core.adapters.ViewType

/**
 * Created by Alexis on 22/11/2017.
 *
 */
data class HomeSection(val cover: String,
                       override val viewType: Int) : ViewType
