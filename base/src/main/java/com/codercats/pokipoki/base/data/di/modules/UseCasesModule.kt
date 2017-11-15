package com.codercats.pokipoki.base.data.di.modules

import com.codercats.pokipoki.base.domain.core.JobExecutor
import com.codercats.pokipoki.base.domain.core.PostExecutionThread
import com.codercats.pokipoki.base.domain.core.ThreadExecutor
import com.codercats.pokipoki.base.presentation.core.UIThread
import org.koin.android.module.AndroidModule
import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by Alexis on 15/11/2017.
 *
 */
class UseCasesModule : AndroidModule() {

    override fun context() = applicationContext {

        provide {
            JobExecutor()
        } bind (ThreadExecutor::class)

        provide {
            UIThread()
        } bind (PostExecutionThread::class)
    }
}