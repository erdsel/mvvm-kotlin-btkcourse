package com.src.mvvmbtk.ui.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.src.mvvmbtk.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentActivity : AppCompatActivity() {

    val commentActivityViewModel: CommentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        observeViewModel()
    }

    fun observeViewModel()
    {

        commentActivityViewModel.apply {
            allCommentsLiveData.observe(this@CommentActivity, Observer {

                it.forEach {
                    Log.e("CAGATAY","it " +it.name)
                }

            })

            error.observe(this@CommentActivity, Observer {
                it.run {

                }
            })
            loading.observe(this@CommentActivity, Observer {

            })

        }
    }
}