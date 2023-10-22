package com.src.mvvmbtk.utils

import com.src.mvvmbtk.UserModelItem



import com.src.mvvmbtk.UserResponse

object FakeDataUtils {

    fun getFakeUsers() : UserResponse
    {
        val user1 = UserModelItem(
            name = "LOKAL OSMAN",
            address = null,
            email = null,
            id = null,
            phone = null,
            website = null,
            username = null,
            company = null,
        )
        val user2 = UserModelItem(
            name = "LOKAL AYŞE",
            address = null,
            email = null,
            id = null,
            phone = null,
            website = null,
            username = null,
            company = null,
        )

        val user3 = UserModelItem(
            name = "LOKAL ÇAĞATAY",
            address = null,
            email = null,
            id = null,
            phone = null,
            website = null,
            username = null,
            company = null,
        )

        val userResponse = UserResponse()
        userResponse.add(user1)
        userResponse.add(user2)
        userResponse.add(user3)
        return userResponse
    }
}