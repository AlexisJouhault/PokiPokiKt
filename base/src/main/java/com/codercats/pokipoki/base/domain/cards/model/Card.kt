package com.codercats.pokipoki.base.domain.cards.model

import android.os.Parcel
import android.os.Parcelable
import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType.Companion.CARD

/**
 * Created by Alexis on 08/11/2017.
 *
 */
data class Card(val id: String,
                val name: String,
                val url: String,
                val highResUrl: String,
                val cardNumber: Int,
                val rarity: String,
                val setId: String,
                val setName: String) : ViewType, Parcelable {

    //todo add default values
    constructor(cardEntity: CardEntity) : this(id = cardEntity.id,
            name = cardEntity.name ?: "", url = cardEntity.url ?: "",
            highResUrl = cardEntity.highResUrl ?: "", cardNumber = 0,
            rarity = cardEntity.rarity ?: "", setId = cardEntity.setCode ?: "", setName = cardEntity.setName ?: "")

    override val viewType = CARD

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(highResUrl)
        parcel.writeInt(cardNumber)
        parcel.writeString(rarity)
        parcel.writeString(setId)
        parcel.writeString(setName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        val PACKAGE_NAME = "card"

        @JvmField
        val CREATOR = object : Parcelable.Creator<Card> {

            override fun createFromParcel(parcel: Parcel): Card {
                return Card(parcel)
            }

            override fun newArray(size: Int): Array<Card?> {
                return arrayOfNulls(size)
            }
        }
    }

}