package com.codercats.pokipoki.base.presentation.core

import com.codercats.pokipoki.base.domain.core.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Alexis on 15/11/2017.
 *
 */
class UIThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}
