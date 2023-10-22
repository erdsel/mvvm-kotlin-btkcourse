package com.src.mvvmbtk.data.repository.user


import com.src.mvvmbtk.UserResponse
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDataSource: UserDataSource) {
    suspend fun getAllUsers(): Flow<Resource<UserResponse>> {
        return userDataSource.getAllUsers()
    }
}