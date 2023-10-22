package com.src.mvvmbtk.data.repository.comment

import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepository @Inject constructor(private val commentDataSource: CommentDataSource ) {


    suspend fun getAllComments(): Flow<Resource<CommentResponse>> {
        return commentDataSource.getAllComments()
    }
}