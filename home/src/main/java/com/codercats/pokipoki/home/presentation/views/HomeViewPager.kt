package com.codercats.pokipoki.home.presentation.views

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent



/**
 * Created by Alexis on 07/11/2017.
 *
 */
class HomeViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    private var swipeEnabled: Boolean = false

    constructor(context: Context) : this(context, null)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.swipeEnabled) {
            super.onTouchEvent(event)
        } else false

    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (this.swipeEnabled) {
            super.onInterceptTouchEvent(event)
        } else false

    }

    override fun performClick(): Boolean {
        return super.performClick()
    }
}