package com.codercats.pokipoki.base.domain.core

import com.codercats.pokipoki.base.presentation.core.BasePresenter
import com.codercats.pokipoki.base.presentation.core.utils.ErrorUtils
import io.reactivex.observers.DisposableObserver
import kotlin.reflect.KFunction1

/**
 * Default [DisposableObserver] base class to be used whenever you want default error handling.
 */
open class DefaultObserver<T>(private val presenter: BasePresenter<*>,
                              private val kFunction1: KFunction1<T, Unit>) : DisposableObserver<T>() {

    override fun onNext(t: T) {
        kFunction1(t)
    }

    override fun onComplete() {
        presenter.taskComplete()
    }

    override fun onError(exception: Throwable) {
        presenter.error(ErrorUtils.getErrorCode(exception))
    }
}