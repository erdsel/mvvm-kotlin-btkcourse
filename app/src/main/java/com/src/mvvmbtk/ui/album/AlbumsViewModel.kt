package com.src.mvvmbtk.ui.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.src.mvvmbtk.data.model.AlbumsResponse
import com.src.mvvmbtk.data.model.CommentResponse
import com.src.mvvmbtk.data.repository.album.AlbumsRepository
import com.src.mvvmbtk.ui.base.BaseViewModel
import com.src.mvvmbtk.utils.constants.Resource
import com.src.mvvmbtk.utils.constants.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val albumsRepository: AlbumsRepository) : BaseViewModel() {

    var allAlbumsLiveData = MutableLiveData<Resource<AlbumsResponse>>()

    init {
        getAllAlbums()
    }

    fun getAllAlbums() = viewModelScope.launch {
        albumsRepository.getAllAlbums()
            .asLiveData(viewModelScope.coroutineContext).observeForever {
                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allAlbumsLiveData.postValue(Resource.Success(it.data!!))
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
