package com.codercats.pokipoki.base.presentation.core.utils

import android.support.v7.widget.SearchView
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView
import com.jakewharton.rxbinding2.support.v7.widget.SearchViewQueryTextEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import kotlin.reflect.KFunction1

/**
 * Created by Alexis on 18/11/2017.
 *
 */
object RxUtils {

    private val DEBOUNCE = 500L

    fun subscribeToSearchView(searchview: SearchView, action: KFunction1<@ParameterName(name = "query") CharSequence, Unit>) {
        RxSearchView.queryTextChangeEvents(searchview).skipInitialValue()
                .debounce(DEBOUNCE, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map { t: SearchViewQueryTextEvent -> action(t.queryText()) }
                .subscribe()
    }
}