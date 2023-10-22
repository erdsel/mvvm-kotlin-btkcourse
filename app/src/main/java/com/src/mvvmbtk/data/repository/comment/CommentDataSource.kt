package com.src.mvvmbtk.data.repository.comment

import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow


interface CommentDataSource {
    suspend fun getAllComments(): Flow<Resource<CommentResponse>>
}



