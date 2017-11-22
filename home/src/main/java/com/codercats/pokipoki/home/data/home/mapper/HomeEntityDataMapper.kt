package com.codercats.pokipoki.home.data.home.mapper

import com.codercats.pokipoki.base.data.sets.entity.SetEntity
import com.codercats.pokipoki.base.presentation.core.adapters.ViewType
import com.codercats.pokipoki.home.domain.home.model.HomeSection

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class HomeEntityDataMapper {

    fun transform(setEntities: List<SetEntity>) : List<HomeSection> {
        val homeSections = ArrayList<HomeSection>()

        homeSections.add(transform(setEntities.first()))

        return homeSections
    }

    fun transform(setEntity: SetEntity) : HomeSection {
        return HomeSection(setEntity.logo, ViewType.SET)
    }
}