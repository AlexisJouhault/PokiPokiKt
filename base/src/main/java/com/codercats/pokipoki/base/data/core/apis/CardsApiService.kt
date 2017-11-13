package com.codercats.pokipoki.base.data.core.apis

import com.codercats.pokipoki.base.data.cards.entity.CardEntity
import com.codercats.pokipoki.base.data.core.RetrofitHelper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Alexis on 09/11/2017.
 *
 */
interface CardsApiService {

    @GET(RetrofitHelper.END_POINT + "/cards")
    fun searchCards(@Query(RetrofitHelper.QUERY_NAME) name : String) : Observable<List<CardEntity>>

}