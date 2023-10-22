package com.src.mvvmbtk.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.src.mvvmbtk.UserResponse
import com.src.mvvmbtk.data.repository.user.UserRepository
import com.src.mvvmbtk.ui.base.BaseViewModel
import com.src.mvvmbtk.utils.constants.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    var allUsersLiveData = MutableLiveData<UserResponse>()

    fun getAllUsers() = viewModelScope.launch {


        userRepository.getAllUsers()
            .asLiveData(viewModelScope.coroutineContext).observeForever {
                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allUsersLiveData.postValue(it.data!!)
                        loading.postValue(false)
                    }

                    ResourceStatus.ERROR -> {

                        error.postValue(it.throwable!!)
                        loading.postValue(false)
                    }
                }
            }
    }
    init {
        getAllUsers()
    }

}