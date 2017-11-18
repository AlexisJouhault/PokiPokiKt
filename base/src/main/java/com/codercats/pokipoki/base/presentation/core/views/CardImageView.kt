package com.codercats.pokipoki.base.presentation.core.views

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

/**
 * Created by Alexis on 18/11/2017.
 *
 */
class CardImageView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int =  0)
    : AppCompatImageView(context, attributeSet, defStyleAttr) {

    companion object {
        val REAL_HEIGHT = 880
        val REAL_WIDTH = 630
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredWidth * REAL_HEIGHT / REAL_WIDTH)
    }
}