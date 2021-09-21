package ir.kaaveh.cart.di.module

import dagger.Module
import dagger.Provides
import ir.kaaveh.cart.api.RemoteAPI
import ir.kaaveh.cart.di.scope.CartScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class CardNetworkModule {

    @Provides
    @CartScope
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @CartScope
    fun provideRemoteAPI(retrofit: Retrofit): RemoteAPI {
        return retrofit.create(RemoteAPI::class.java)
    }
}