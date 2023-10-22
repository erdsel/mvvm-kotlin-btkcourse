package com.src.mvvmbtk.data.model
import com.google.gson.annotations.SerializedName


class AlbumsResponse : ArrayList<AlbumsModelItem>()

data class AlbumsModelItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)