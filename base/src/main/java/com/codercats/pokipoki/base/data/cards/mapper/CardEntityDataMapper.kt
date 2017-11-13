package com.codercats.pokipoki.base.data.cards.mapper

import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.domain.cards.model.Card

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class CardEntityDataMapper constructor() {

    fun transform(cardEntities: List<CardEntity>): List<Card> {
        val cards = ArrayList<Card>()

        for (cardEntity in cardEntities) {
            cards.add(transform(cardEntity))
        }

        return cards
    }

    private fun transform(cardEntity: CardEntity): Card {
        return Card(name = cardEntity.name,
                url = cardEntity.url)
    }


}