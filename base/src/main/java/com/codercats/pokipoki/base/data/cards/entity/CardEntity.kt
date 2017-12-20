package com.codercats.pokipoki.base.data.cards.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class CardEntity(@SerializedName("id") val id: String,
                 @SerializedName("name") val name: String?,
                 @SerializedName("imageUrl") val url: String? = "",
                 @SerializedName("imageUrlHiRes") val highResUrl: String? = "",
                 @SerializedName("number") val cardNumber: String? = "",
                 @SerializedName("rarity") val rarity: String? = "",
                 @SerializedName("setCode") val setCode: String? = "",
                 @SerializedName("set") val setName: String? = "") {
}