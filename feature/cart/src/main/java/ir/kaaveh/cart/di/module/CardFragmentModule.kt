package ir.kaaveh.cart.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.kaaveh.cart.di.scope.CartScope
import ir.kaaveh.cart.view.CardFragment

@Module
interface CardFragmentModule {

    @CartScope
    @ContributesAndroidInjector(modules = [CardViewModelModule::class, CardNetworkModule::class])
    fun bindCardFragment(): CardFragment
}