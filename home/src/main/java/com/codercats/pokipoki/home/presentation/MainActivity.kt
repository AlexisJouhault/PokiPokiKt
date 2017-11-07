package com.codercats.pokipoki.home.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codercats.pokipoki.home.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewPager
import com.codercats.pokipoki.home.presentation.adapters.HomeViewPagerAdapter
import com.codercats.pokipoki.home.presentation.fragments.HomeFragment
import com.codercats.pokipoki.home.presentation.fragments.SearchFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
        setupViewPager(content)
    }

    private fun setUpNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener { item -> navigateTo(destination = item.itemId) }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = HomeViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }
    private fun navigateTo(destination: Int) : Boolean {
        when (destination) {
            R.id.action_navigation_home -> navigateToHome()
            R.id.action_navigation_search -> navigateToSearch()
            else -> return false
        }
        return true
    }

    private fun navigateToSearch() {
        content.currentItem = SearchFragment.POSITION
    }

    private fun navigateToHome() {
        content.currentItem = HomeFragment.POSITION
    }
}
