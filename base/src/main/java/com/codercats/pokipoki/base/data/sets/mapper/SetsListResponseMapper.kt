package com.codercats.pokipoki.base.data.sets.mapper

import com.codercats.pokipoki.base.data.sets.entity.SetEntity
import com.codercats.pokipoki.base.data.sets.responses.SetListResponse

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class SetsListResponseMapper {

    fun transform(setListResponse: SetListResponse) : List<SetEntity> {
        return setListResponse.sets
    }

    fun transformToLatest(setListResponse: SetListResponse) : SetEntity {
        return setListResponse.sets.last()
    }}