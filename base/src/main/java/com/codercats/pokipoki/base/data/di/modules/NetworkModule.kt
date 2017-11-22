package com.codercats.pokipoki.base.data.di.modules

import com.codercats.pokipoki.base.data.cards.CardsDataRepository
import com.codercats.pokipoki.base.data.cards.mapper.CardEntityDataMapper
import com.codercats.pokipoki.base.data.cards.mapper.CardListResponseMapper
import com.codercats.pokipoki.base.data.cards.repositories.CardsCloudDataStore
import com.codercats.pokipoki.base.data.core.RetrofitHelper
import com.codercats.pokipoki.base.data.sets.SetsDataRepository
import com.codercats.pokipoki.base.data.sets.mapper.SetsEntityDataMapper
import com.codercats.pokipoki.base.data.sets.mapper.SetsListResponseMapper
import com.codercats.pokipoki.base.data.sets.repositories.SetsCloudDataStore
import com.codercats.pokipoki.base.domain.cards.CardsRepository
import com.codercats.pokipoki.base.domain.sets.SetsRepository
import org.koin.android.module.AndroidModule
import retrofit2.Retrofit

/**
 * Created by Alexis on 12/11/2017.
 *
 */
class NetworkModule : AndroidModule() {

    override fun context() = applicationContext {

        provide {
            RetrofitHelper.build(get())
        } bind (Retrofit::class)

        provide { CardEntityDataMapper() }
        provide { CardListResponseMapper() }
        provide { CardsCloudDataStore(get(), get()) }
        provide { CardsDataRepository(get(), get()) } bind (CardsRepository::class)

        provide { SetsEntityDataMapper() }
        provide { SetsListResponseMapper() }
        provide { SetsCloudDataStore(get(), get()) }
        provide { SetsDataRepository() } bind (SetsRepository::class)
    }
}