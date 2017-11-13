package com.codercats.pokipoki.base.domain.cards

import com.codercats.pokipoki.base.domain.cards.model.Card
import io.reactivex.Observable

/**
 * Created by Alexis on 08/11/2017.
 *
 */
interface CardsRepository {

    fun search(query: String) : Observable<List<Card>>

}