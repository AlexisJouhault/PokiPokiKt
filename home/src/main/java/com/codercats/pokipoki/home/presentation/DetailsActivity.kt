package com.codercats.pokipoki.home.presentation

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.transition.Transition
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.codercats.pokipoki.base.domain.cards.model.Card
import com.codercats.pokipoki.home.R
import com.codercats.pokipoki.home.presentation.views.GlideApp
import com.codercats.pokipoki.home.presentation.views.GlideRequest
import kotlinx.android.synthetic.main.activity_details.*
import okhttp3.internal.http.RequestLine

class DetailsActivity : AppCompatActivity() {

    lateinit var card : Card

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        handleTransitionAnimation()
    }

    private fun handleTransitionAnimation() {
        supportPostponeEnterTransition(); //Pause transition before loading iamge
        card = intent.getParcelableExtra(Card.PACKAGE_NAME)

        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition?) { loadHighResImage() }
            override fun onTransitionResume(transition: Transition?) {}
            override fun onTransitionPause(transition: Transition?) {}
            override fun onTransitionCancel(transition: Transition?) {}
            override fun onTransitionStart(transition: Transition?) {}
        })

        GlideApp.with(this)
                .load(card.url)
                .centerCrop()
                .listener(object: RequestListener<Drawable> {
                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition() // resume transition when image is loaded
                        return false
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition() // resume transition when image is loaded
                        return false
                    }

                })
                .into(card_preview)
    }

    private fun loadHighResImage() {
        GlideApp.with(this)
                .load(card.highResUrl)
                .centerCrop()
                .dontAnimate()
                .placeholder(card_preview.drawable)
                .into(card_preview)
    }

    override fun onDestroy() {
        supportFinishAfterTransition()
        super.onDestroy()
    }
}
