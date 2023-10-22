package com.src.mvvmbtk.utils.network

import com.src.mvvmbtk.UserResponse
import com.src.mvvmbtk.data.model.AlbumsResponse
import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.data.model.ProductsModel
import retrofit2.Response
import retrofit2.http.GET

interface PlaceHolderApi{
    @GET("users")
    suspend fun getAllUsers() : Response<UserResponse>

    @GET("comments")
    suspend fun getAllComments() : Response<CommentResponse>

    @GET("albums")
    suspend fun getAllAlbums() : Response<AlbumsResponse>



    @GET("products")
    suspend fun getAllProducts() : Response<ProductsModel>

}