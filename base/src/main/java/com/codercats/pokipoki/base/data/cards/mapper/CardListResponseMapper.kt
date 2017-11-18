package com.codercats.pokipoki.base.data.cards.mapper

import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.data.cards.responses.CardListResponse

/**
 * Created by Alexis on 18/11/2017.
 *
 */
class CardListResponseMapper {

    fun transform(response: CardListResponse) : List<CardEntity> {
        //todo process response here (if no content throw error)
        return response.cards
    }

}