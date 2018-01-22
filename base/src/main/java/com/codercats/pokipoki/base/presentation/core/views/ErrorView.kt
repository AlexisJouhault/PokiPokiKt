package com.codercats.pokipoki.base.presentation.core.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import com.codercats.pokipoki.R
import com.codercats.pokipoki.R.id.error_message
import com.codercats.pokipoki.R.id.error_retry

/**
 * Created by Alexis on 14/01/2018.
 *
 */
class ErrorView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int =  0)
    : ConstraintLayout(context, attributeSet, defStyleAttr) {

    lateinit var onRetryListener: OnRetryListener
    private val errorMessage : AppCompatTextView

    init {
        inflate(context, R.layout.error_view, this)
        this.visibility = GONE

        errorMessage = this.findViewById(error_message)
        this.findViewById<AppCompatButton>(error_retry).setOnClickListener {
            this.visibility = View.GONE
            onRetryListener.onRetry()
        }
    }

    fun displayErrorMessage(message: String) {
        this.visibility = View.VISIBLE
        errorMessage.text = message
    }

    interface OnRetryListener {
        fun onRetry()
    }
}