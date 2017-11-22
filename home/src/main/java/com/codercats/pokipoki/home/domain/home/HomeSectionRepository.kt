package com.codercats.pokipoki.home.domain.home

import com.codercats.pokipoki.home.domain.home.model.HomeSection
import io.reactivex.Observable

/**
 * Created by Alexis on 22/11/2017.
 *
 */
interface HomeSectionRepository {

    fun getHomeContent() : Observable<List<HomeSection>>
}