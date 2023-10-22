package com.src.mvvmbtk.data.model
import com.google.gson.annotations.SerializedName


class CommentResponse : ArrayList<CommentResponseItem>()

data class CommentResponseItem(
    @SerializedName("body")
    val body: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("postId")
    val postId: Int?
)