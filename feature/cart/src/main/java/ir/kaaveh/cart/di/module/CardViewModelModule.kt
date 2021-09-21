package ir.kaaveh.cart.di.module

import androidx.lifecycle.ViewModel
import com.phelat.tedu.lifecycle.ViewModelFactory
import com.phelat.tedu.lifecycle.ViewModelKey
import com.phelat.tedu.lifecycle.ViewModelProviders
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ir.kaaveh.cart.di.scope.CartScope
import ir.kaaveh.cart.viewmodel.CardViewModel

@Module
interface CardViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CardViewModel::class)
    @CartScope
    fun bindCardViewModel(input: CardViewModel): ViewModel

    companion object {
        @Provides
        @CartScope
        fun provideViewModelFactory(viewModelProviders: ViewModelProviders): ViewModelFactory {
            return ViewModelFactory(viewModelProviders)
        }
    }
}