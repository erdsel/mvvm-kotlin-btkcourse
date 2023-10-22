package com.src.mvvmbtk.data.repository.album

import com.src.mvvmbtk.PlaceHolderService
import com.src.mvvmbtk.data.model.AlbumsResponse
import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.data.repository.comment.CommentDataSource
import com.src.mvvmbtk.utils.constants.Resource
import com.src.mvvmbtk.utils.network.PlaceHolderApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AlbumsRemoteDataSource @Inject constructor(private val api: PlaceHolderApi) : AlbumsDataSource {

    override suspend fun getAllAlbums(): Flow<Resource<AlbumsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val list = api.getAllAlbums()
            emit(Resource.Success(list.body()))
        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }
}
