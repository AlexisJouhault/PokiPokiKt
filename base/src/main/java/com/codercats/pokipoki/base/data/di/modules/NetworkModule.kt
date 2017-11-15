package com.codercats.pokipoki.base.data.di.modules

import com.codercats.pokipoki.base.data.cards.CardsDataRepository
import com.codercats.pokipoki.base.data.cards.mapper.CardEntityDataMapper
import com.codercats.pokipoki.base.data.cards.repositories.CardsCloudDataStore
import com.codercats.pokipoki.base.data.core.RetrofitHelper
import com.codercats.pokipoki.base.domain.cards.CardsRepository
import org.koin.android.module.AndroidModule
import retrofit2.Retrofit

/**
 * Created by Alexis on 12/11/2017.
 *
 */
class NetworkModule : AndroidModule() {

    override fun context() = applicationContext {

        provide {
            RetrofitHelper.build()
        } bind (Retrofit::class)

        provide { CardsCloudDataStore(get()) }
        provide { CardEntityDataMapper() }
        provide { CardsDataRepository(get(), get()) } bind (CardsRepository::class)
    }
}