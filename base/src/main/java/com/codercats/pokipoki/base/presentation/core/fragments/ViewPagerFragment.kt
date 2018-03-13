package com.codercats.pokipoki.base.presentation.core.fragments

import android.os.Bundle

/**
 * Created by Alexis on 07/11/2017.
 *
 */
abstract class ViewPagerFragment : BaseFragment() {

    val position: Int
        get() = arguments?.get(KEY_POSITION) as Int

    companion object {

        const val KEY_POSITION = "viewPagerFragment.position"

        fun newInstance(position: Int, fragment: ViewPagerFragment): ViewPagerFragment {
            val args = Bundle()
            args.putInt(KEY_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }
}