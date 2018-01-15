package com.codercats.pokipoki.home.domain.home.interactor

import com.codercats.pokipoki.base.data.core.exceptions.UnavailableContentException
import com.codercats.pokipoki.base.domain.core.PostExecutionThread
import com.codercats.pokipoki.base.domain.core.ThreadExecutor
import com.codercats.pokipoki.base.domain.core.UseCase
import com.codercats.pokipoki.home.domain.home.HomeSectionRepository
import com.codercats.pokipoki.home.domain.home.model.HomeSection
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class GetHomeContent(threadExecutor: ThreadExecutor,
                     postExecutionThread: PostExecutionThread,
                     private val homeSectionRepository: HomeSectionRepository): UseCase<List<HomeSection>, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Observable<List<HomeSection>> {
        return homeSectionRepository.getHomeContent().onErrorResumeNext(Function {
            return@Function Observable.error(UnavailableContentException("An error occurred while loading content"))
        })
    }

}