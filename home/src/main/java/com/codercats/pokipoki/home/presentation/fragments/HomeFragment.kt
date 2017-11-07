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
class HomeFragment : ViewPagerFragment() {

    companion object {

        val POSITION = 0

        fun newInstance(): HomeFragment {
            return ViewPagerFragment.newInstance(POSITION, HomeFragment()) as HomeFragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}