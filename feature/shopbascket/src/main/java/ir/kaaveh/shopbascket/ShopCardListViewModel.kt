package ir.kaaveh.shopbascket

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ShopCardListViewModel @Inject constructor(
    private val getShopCardUseCase: GetShopCardUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getShopCard()
    }

    private fun getShopCard() = getShopCardUseCase().onEach { result ->
        when (result) {
            is Resource.Success -> {
                _state.value = ShopCardState(shopCard = result.data ?: null)
            }
            is Resource.Error -> {
                _state.value = ShopCardState(
                    error = result.exception?.localizedMessage ?: "An unexpected error occured."
                )
            }
            is Resource.Loading -> {
                _state.value = ShopCardState(isLoading = true)
            }
        }
    }.launchIn(viewModelScope)
}