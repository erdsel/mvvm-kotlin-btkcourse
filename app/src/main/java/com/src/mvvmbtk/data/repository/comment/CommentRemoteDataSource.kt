package com.src.mvvmbtk.data.repository.comment

import com.src.mvvmbtk.PlaceHolderService
import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.utils.constants.Resource
import com.src.mvvmbtk.utils.network.PlaceHolderApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CommentRemoteDataSource @Inject constructor(private val api: PlaceHolderApi) : CommentDataSource {

    override suspend fun getAllComments(): Flow<Resource<CommentResponse>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getAllComments()
            emit(Resource.Success(list.body()))
        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }
}
