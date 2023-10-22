package com.src.mvvmbtk.ui.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.src.mvvmbtk.R

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.src.mvvmbtk.ui.comment.CommentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsActivity : AppCompatActivity() {

    val albumsActivityViewModel: CommentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        observeViewModel()
    }

    fun observeViewModel()
    {

        albumsActivityViewModel.apply {
            allCommentsLiveData.observe(this@AlbumsActivity, Observer {

                it.forEach {
                    Log.e("CAGATAY","album " +it.name)
                }

            })

            error.observe(this@AlbumsActivity, Observer {
                it.run {

                }
            })
            loading.observe(this@AlbumsActivity, Observer {

            })

        }
    }
}