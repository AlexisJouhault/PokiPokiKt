package com.codercats.pokipoki.home.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codercats.pokipoki.base.presentation.core.ViewPagerFragment
import com.codercats.pokipoki.home.R

/**
 * Created by Alexis on 07/11/2017.
 *
 */
class SearchFragment : ViewPagerFragment() {

    companion object {

        val POSITION = 1

        fun newInstance(): SearchFragment {
            return ViewPagerFragment.newInstance(POSITION, SearchFragment()) as SearchFragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}