package com.src.mvvmbtk.data.repository.album

import com.src.mvvmbtk.data.model.AlbumsResponse
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumsRepository @Inject constructor(private val albumsDataSource: AlbumsDataSource) {


    suspend fun getAllAlbums(): Flow<Resource<AlbumsResponse>> {
        return albumsDataSource.getAllAlbums()
    }
}