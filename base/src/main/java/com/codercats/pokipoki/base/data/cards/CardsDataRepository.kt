package com.codercats.pokipoki.base.data.cards

import com.codercats.pokipoki.base.data.cards.mapper.CardEntityDataMapper
import com.codercats.pokipoki.base.data.cards.repositories.CardsCloudDataStore
import com.codercats.pokipoki.base.domain.cards.CardsRepository
import com.codercats.pokipoki.base.domain.cards.model.Card
import io.reactivex.Observable

/**
 * Created by Alexis on 08/11/2017.
 *
 */
class CardsDataRepository constructor(private val cardsCloudDataStore: CardsCloudDataStore,
                                      private val cardEntityDataMapper: CardEntityDataMapper) : CardsRepository {

    override fun search(query: String): Observable<List<Card>> {
        return cardsCloudDataStore.searchForCard(query).map { cardEntities -> cardEntityDataMapper.transform(cardEntities) }
    }

}