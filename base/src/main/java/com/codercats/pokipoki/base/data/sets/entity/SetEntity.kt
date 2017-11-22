package com.codercats.pokipoki.base.data.sets.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexis on 22/11/2017.
 *
 */
data class SetEntity(@SerializedName("logoUrl") val logo: String,
                     @SerializedName("name") val name: String,
                     @SerializedName("totalCards") val totalCards: Int) {
}