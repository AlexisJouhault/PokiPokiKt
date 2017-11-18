package com.codercats.pokipoki.base.data.cards.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class CardEntity(@SerializedName("name") val name: String,
                 @SerializedName("imageUrl") val url: String) {
}