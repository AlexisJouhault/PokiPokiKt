package com.codercats.pokipoki.base.data.sets.responses

import com.codercats.pokipoki.base.data.sets.entity.SetEntity
import com.google.gson.annotations.SerializedName

/**
 * Created by Alexis on 22/11/2017.
 *
 */
data class SetListResponse(@SerializedName("sets") val sets: List<SetEntity>)