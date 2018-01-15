package com.codercats.pokipoki.base.domain.core

import com.codercats.pokipoki.base.data.core.exceptions.NetworkException
import com.codercats.pokipoki.base.data.core.exceptions.UnavailableContentException
import com.codercats.pokipoki.base.presentation.core.BasePresenter
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils
import io.reactivex.observers.DisposableObserver
import kotlin.reflect.KFunction1

/**
 * Default [DisposableObserver] base class to be used whenever you want default error handling.
 */
open class DefaultUseCaseObserver<T>(private val presenter: BasePresenter<*>,
                                     private val kFunction1: KFunction1<T, Unit>) : DisposableObserver<T>() {

    override fun onNext(t: T) {
        kFunction1(t)
    }

    override fun onComplete() {
        presenter.taskComplete()
    }

    /* Handle error useCases here */
    override fun onError(exception: Throwable) {
        when (exception) {
            is NetworkException -> presenter.error(exception.message)
            is UnavailableContentException -> presenter.error(exception.message)
            else -> presenter.error(ErrorUtils.Messages.DEFAULT)
        }
    }
}