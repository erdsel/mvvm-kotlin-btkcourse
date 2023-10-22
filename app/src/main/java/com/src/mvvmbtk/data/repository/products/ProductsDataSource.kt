package com.src.mvvmbtk.data.repository.products

import com.src.mvvmbtk.data.model.AlbumsResponse
import com.src.mvvmbtk.data.model.Product
import com.src.mvvmbtk.data.model.ProductsModel
import com.src.mvvmbtk.utils.constants.Resource

import kotlinx.coroutines.flow.Flow


interface ProductsDataSource{
    suspend fun getAllProducts(): Flow<Resource<ProductsModel>>
}
