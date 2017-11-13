package com.codercats.pokipoki.base.data.cards

import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import io.reactivex.Observable

/**
 * Created by Alexis on 08/11/2017.
 *
 */
interface CardsDataStore {

    fun searchForCard(query: String) : Observable<List<CardEntity>>
}