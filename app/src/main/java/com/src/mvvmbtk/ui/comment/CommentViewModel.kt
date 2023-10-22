package com.src.mvvmbtk.ui.comment


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.src.mvvmbtk.UserResponse
import com.src.mvvmbtk.data.model.CommentResponse

import com.src.mvvmbtk.data.repository.comment.CommentRepository
import com.src.mvvmbtk.data.repository.user.UserRepository
import com.src.mvvmbtk.ui.base.BaseViewModel
import com.src.mvvmbtk.utils.constants.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(private val commentRepository: CommentRepository) : BaseViewModel() {


    var allCommentsLiveData = MutableLiveData<CommentResponse>()

    init {
        getAllComments()
    }

    fun getAllComments() = viewModelScope.launch {
        commentRepository.getAllComments()
            .asLiveData(viewModelScope.coroutineContext).observeForever {
                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allCommentsLiveData.postValue(it.data!!)
                        loading.postValue(false)
                    }

                    ResourceStatus.ERROR -> {

                        error.postValue(it.throwable!!)
                        loading.postValue(false)
                    }
                }
            }
    }

}