package com.src.mvvmbtk.data.repository.user

import com.src.mvvmbtk.UserResponse
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    suspend fun getAllUsers(): Flow<Resource<UserResponse>>
}
