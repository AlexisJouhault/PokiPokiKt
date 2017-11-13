package com.codercats.pokipoki.base.data.cards.repositories

import com.codercats.pokipoki.base.data.cards.CardsDataStore
import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.data.core.apis.CardsApiService
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class CardsCloudDataStore constructor(private val retrofit: Retrofit) : CardsDataStore {

    val cardsApiService : CardsApiService = retrofit.create(CardsApiService::class.java)

    override fun searchForCard(query: String): Observable<List<CardEntity>> {
        return cardsApiService.searchCards(query)
    }

}