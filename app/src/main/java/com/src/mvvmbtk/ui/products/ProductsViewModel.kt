package com.src.mvvmbtk.ui.products


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.src.mvvmbtk.data.model.ProductsModel
import com.src.mvvmbtk.data.repository.products.ProductsRepository
import com.src.mvvmbtk.ui.base.BaseViewModel
import com.src.mvvmbtk.utils.constants.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsRepository: ProductsRepository) : BaseViewModel() {


    var allProductsLiveData = MutableLiveData<ProductsModel>()

    init {
        getAllProducts()
    }

    fun getAllProducts() = viewModelScope.launch {
        productsRepository.getAllProducts()
            .asLiveData(viewModelScope.coroutineContext).observeForever {
                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allProductsLiveData.postValue(it.data!!)
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