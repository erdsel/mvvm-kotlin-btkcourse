package com.src.mvvmbtk.data.repository.products

import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.data.model.ProductsModel
import com.src.mvvmbtk.data.repository.comment.CommentDataSource
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepository @Inject constructor(private val productsDataSource: ProductsDataSource) {


    suspend fun getAllProducts(): Flow<Resource<ProductsModel>> {
        return productsDataSource.getAllProducts()
    }
}