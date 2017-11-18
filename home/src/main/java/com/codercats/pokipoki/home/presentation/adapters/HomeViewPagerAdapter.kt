package com.codercats.pokipoki.home.presentation.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.codercats.pokipoki.base.presentation.core.fragments.ViewPagerFragment
import com.codercats.pokipoki.home.presentation.fragments.HomeFragment
import com.codercats.pokipoki.home.presentation.fragments.SearchFragment

/**
* Created by Alexis on 07/11/2017.
*
*/
class HomeViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val items = ArrayList<ViewPagerFragment>()

    init {
        items.add(HomeFragment.newInstance())
        items.add(SearchFragment.newInstance())
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }
}