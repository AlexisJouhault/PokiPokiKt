package com.codercats.pokipoki.base.data.sets.repositories

import com.codercats.pokipoki.base.data.core.apis.SetsApiService
import com.codercats.pokipoki.base.data.sets.SetsDataStore
import com.codercats.pokipoki.base.data.sets.entity.SetEntity
import com.codercats.pokipoki.base.data.sets.mapper.SetsListResponseMapper
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by Alexis on 22/11/2017.
 *
 */
class SetsCloudDataStore(retrofit: Retrofit,
                         private val responseMapper: SetsListResponseMapper) : SetsDataStore {

    private val setsApiService: SetsApiService = retrofit.create(SetsApiService::class.java)

    override fun getAll(): Observable<List<SetEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLatest(): Observable<SetEntity> {
        return setsApiService.getAll().map(responseMapper::transformToLatest)
    }

    override fun get(page: Int, size: Int): Observable<List<SetEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}