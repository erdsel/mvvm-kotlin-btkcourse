package com.src.mvvmbtk.data.repository.user

import com.src.mvvmbtk.UserResponse
import com.src.mvvmbtk.utils.FakeDataUtils
import com.src.mvvmbtk.utils.constants.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class UserLocaleDataSoruce @Inject constructor(private val fakeDataUtils: FakeDataUtils) :
    UserDataSource {

    override suspend fun getAllUsers(): Flow<Resource<UserResponse>> = flow {
        try {
            emit(Resource.Loading())
            val userList = fakeDataUtils.getFakeUsers()
            emit(Resource.Success(userList))

        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }
}