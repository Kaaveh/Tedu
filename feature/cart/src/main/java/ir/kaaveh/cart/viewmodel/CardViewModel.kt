package ir.kaaveh.cart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.kaaveh.cart.di.scope.CartScope
import ir.kaaveh.cart.entity.ShopCard
import ir.kaaveh.cart.repository.ShopCardRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

@CartScope
class CardViewModel @Inject constructor(
    private val cardRepository: ShopCardRepositoryImpl
) : ViewModel() {

    private val _shopCard = MutableLiveData<ShopCard>()
    val shopCard: LiveData<ShopCard> = _shopCard

    init {
        viewModelScope.launch {
            fetchTodos()
        }
    }

    private suspend fun fetchTodos() {
        _shopCard.value = cardRepository.getShopCard()
    }
}