package com.codercats.pokipoki.base.data.core.apis

import com.codercats.pokipoki.base.data.core.RetrofitHelper
import com.codercats.pokipoki.base.data.sets.responses.SetListResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Alexis on 22/11/2017.
 *
 */
interface SetsApiService {

    @GET(RetrofitHelper.END_POINT + "/sets")
    fun getAll() : Observable<SetListResponse>
}