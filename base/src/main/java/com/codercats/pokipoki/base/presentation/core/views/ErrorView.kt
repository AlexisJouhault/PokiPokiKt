package com.codercats.pokipoki.base.presentation.core.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import com.codercats.pokipoki.R
import com.codercats.pokipoki.R.id.error_message

/**
 * Created by Alexis on 14/01/2018.
 *
 */
class ErrorView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int =  0)
    : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private lateinit var listener : OnRetryListener

    init {
        inflate(context, R.layout.error_view, this)
        this.visibility = GONE
    }

    fun setOnRetryListener(listener: OnRetryListener) {
        this.listener = listener
    }

    fun displayErrorMessage(message: String) {
        this.visibility = View.VISIBLE
    }

    interface OnRetryListener {
        fun onRetry()
    }
}