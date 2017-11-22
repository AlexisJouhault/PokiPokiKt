package com.codercats.pokipoki.base.data.cards.responses

import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.google.gson.annotations.SerializedName

/**
 * Created by Alexis on 18/11/2017.
 *
 */
class CardListResponse(@SerializedName("cards") var cards: List<CardEntity>)