package com.src.mvvmbtk.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.src.mvvmbtk.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainActivityViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewModel()
    }



    fun observeViewModel()
    {

        mainActivityViewModel.apply {
            allUsersLiveData.observe(this@MainActivity, Observer {
                it.forEach{
                    Log.e("CAGATAY","it " +it)
                }

            })

            error.observe(this@MainActivity, Observer {
                it.run {

                }
            })
            loading.observe(this@MainActivity, Observer {

            })

        }
    }



}