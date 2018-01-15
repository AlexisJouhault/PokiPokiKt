package com.codercats.pokipoki.base.data.cards.mapper

import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.data.cards.responses.CardListResponse
import com.codercats.pokipoki.base.data.core.exceptions.NetworkException

/**
 * Created by Alexis on 18/11/2017.
 *
 */
class CardListResponseMapper {

    fun transform(response: CardListResponse) : List<CardEntity> {
        response.cards.isEmpty().apply { throw NetworkException(NetworkException.Codes.NO_CONTENT) }
        return response.cards
    }

}