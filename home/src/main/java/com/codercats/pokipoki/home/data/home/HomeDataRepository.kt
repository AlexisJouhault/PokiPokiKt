package com.codercats.pokipoki.home.data.home

import com.codercats.pokipoki.base.data.sets.entity.SetEntity
import com.codercats.pokipoki.base.data.sets.repositories.SetsCloudDataStore
import com.codercats.pokipoki.home.data.home.mapper.HomeEntityDataMapper
import com.codercats.pokipoki.home.domain.home.HomeSectionRepository
import com.codercats.pokipoki.home.domain.home.model.HomeSection
import io.reactivex.Observable

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class HomeDataRepository(private val setsCloudDataStore: SetsCloudDataStore,
                         private val homeEntityDataMapper: HomeEntityDataMapper) : HomeSectionRepository {

    override fun getHomeContent(): Observable<List<HomeSection>> {
        //todo merge different HomeSections here
        return setsCloudDataStore.getLatest().map { t: SetEntity -> return@map arrayListOf<HomeSection>(homeEntityDataMapper.transform(t)) }
    }
}