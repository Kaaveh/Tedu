package ir.kaaveh.shopcard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.kaaveh.shopcard.datasource.remote.RemoteAPI
import ir.kaaveh.shopcard.repository.ShopCardRepository
import ir.kaaveh.shopcard.repository.ShopCardRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi(): RemoteAPI {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideShopCardRepository(api: RemoteAPI): ShopCardRepository {
        return ShopCardRepositoryImpl(api)
    }
}