package com.src.mvvmbtk.data.repository.products

import com.src.mvvmbtk.PlaceHolderService
import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.data.model.ProductsModel
import com.src.mvvmbtk.data.repository.comment.CommentDataSource
import com.src.mvvmbtk.utils.constants.Resource
import com.src.mvvmbtk.utils.network.PlaceHolderApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRemoteDataSource @Inject constructor(private val api: PlaceHolderApi) :
    ProductsDataSource {

    override suspend fun getAllProducts(): Flow<Resource<ProductsModel>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getAllProducts()
            emit(Resource.Success(list.body()))
        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }
}
