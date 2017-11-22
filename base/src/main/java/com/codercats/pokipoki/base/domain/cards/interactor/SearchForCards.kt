package com.codercats.pokipoki.base.domain.cards.interactor

import com.codercats.pokipoki.base.domain.cards.CardsRepository
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.base.domain.core.PostExecutionThread
import com.codercats.pokipoki.base.domain.core.ThreadExecutor
import com.codercats.pokipoki.base.domain.core.UseCase
import io.reactivex.Observable

/**
 * Created by Alexis on 09/11/2017.
 *
 */
class SearchForCards(threadExecutor: ThreadExecutor,
                     postExecutionThread: PostExecutionThread,
                     private val cardsRepository: CardsRepository) : UseCase<List<Card>, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: String?): Observable<List<Card>> {
        return cardsRepository.search(params?: "")
    }

}