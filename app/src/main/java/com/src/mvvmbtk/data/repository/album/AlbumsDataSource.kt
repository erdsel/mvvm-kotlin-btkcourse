package com.src.mvvmbtk.data.repository.album

import com.src.mvvmbtk.data.model.AlbumsResponse
import com.src.mvvmbtk.utils.constants.Resource

import kotlinx.coroutines.flow.Flow


interface AlbumsDataSource {
    suspend fun getAllAlbums(): Flow<Resource<AlbumsResponse>>
}

