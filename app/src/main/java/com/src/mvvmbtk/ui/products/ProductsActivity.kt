package com.src.mvvmbtk.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.src.mvvmbtk.R
import com.src.mvvmbtk.databinding.ActivityProductsBinding
import com.src.mvvmbtk.ui.comment.CommentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {

    val productsActivityViewModel: ProductsViewModel by viewModels()
    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        observeViewModel()
    }

    fun observeViewModel() {
        productsActivityViewModel.apply {
            allProductsLiveData.observe(
                this@ProductsActivity, Observer { productsModel ->
                    productsModel.products.forEach { product ->
                        Log.e("CAGATAY", "\nProduct Name->" + product.title+
                                "\nProduct Category-> "+ product.category +
                                "\nProduct Price->" + product.price
                        )
                    }
                }
            )

            error.observe(this@ProductsActivity, Observer {
                it.run {
                    // Hata işlemleri
                }
            })

            loading.observe(this@ProductsActivity, Observer {
                // Yükleme durumu işlemleri
            })
        }
    }

}