package com.codercats.pokipoki.base.data.sets

import com.codercats.pokipoki.base.data.sets.entity.SetEntity
import io.reactivex.Observable

/**
 * Created by Alexis on 22/11/2017.
 *
 */
interface SetsDataStore {

    fun get(page: Int, size: Int) : Observable<List<SetEntity>>

    fun getAll() : Observable<List<SetEntity>>

    fun getLatest() : Observable<SetEntity>
}