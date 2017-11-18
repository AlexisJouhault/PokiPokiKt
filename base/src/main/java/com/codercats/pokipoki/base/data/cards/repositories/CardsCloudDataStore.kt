package com.codercats.pokipoki.base.data.cards.repositories

import com.codercats.pokipoki.base.data.cards.CardsDataStore
import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.data.cards.mapper.CardListResponseMapper
import com.codercats.pokipoki.base.data.cards.responses.CardListResponse
import com.codercats.pokipoki.base.data.core.apis.CardsApiService
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class CardsCloudDataStore constructor(retrofit: Retrofit,
                                      private val responseMapper: CardListResponseMapper) : CardsDataStore {

    private val cardsApiService : CardsApiService = retrofit.create(CardsApiService::class.java)

    override fun searchForCard(query: String): Observable<List<CardEntity>> {
        return cardsApiService.searchCards(query).map(responseMapper::transform)
    }

}