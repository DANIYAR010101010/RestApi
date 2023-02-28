package com.io.muhsin.restapiapp.data.api

import com.io.muhsin.restapiapp.data.api.model.PostResponse
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val postService: PostService) {
    suspend fun getAllPosts()= postService.getAllPosts()
    suspend fun postPosts(body:PostResponse)= postService.postPosts(body= body)
    suspend fun putPosts(id:String,body: PostResponse)= postService.putPosts(id= id,body = body)
    suspend fun patchPosts(id:String,body: PostResponse)= postService.patchPosts(id= id,body = body)
    suspend fun deletePosts(id:String)= postService.deletePosts(id= id)
}