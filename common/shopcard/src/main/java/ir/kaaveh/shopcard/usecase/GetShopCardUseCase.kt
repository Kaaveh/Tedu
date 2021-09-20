package ir.kaaveh.shopcard.usecase

import ir.kaaveh.shopcard.datasource.remote.Resource
import ir.kaaveh.shopcard.datasource.remote.dto.toShopCard
import ir.kaaveh.shopcard.model.ShopCard
import ir.kaaveh.shopcard.repository.ShopCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetShopCardUseCase @Inject constructor(
    private val repository: ShopCardRepository,
)  {
    operator fun invoke(): Flow<Resource<ShopCard>> = flow {
        try {
            emit(Resource.Loading<ShopCard>())
            val shopCard = repository.getShopCard().toShopCard()
            emit(Resource.Success<ShopCard>(shopCard))
        } catch (e: HttpException) {
            emit(Resource.Error<ShopCard>(e))
        } catch (e: IOException) {
            emit(Resource.Error<ShopCard>(e))
        }
    }
}