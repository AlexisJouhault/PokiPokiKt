package com.codercats.pokipoki.base.domain.core

import io.reactivex.Scheduler

/**
 * Created by Alexis on 15/11/2017.
 *
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}