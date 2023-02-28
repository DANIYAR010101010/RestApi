package com.io.muhsin.restapiapp.data.api

import com.io.muhsin.restapiapp.data.api.model.PostResponse
import retrofit2.Response
import retrofit2.http.*

interface PostService {
    @GET("/posts")
    suspend fun getAllPosts(): Response<List<PostResponse>>

    @POST("/posts")
    suspend fun postPosts(@Body body: PostResponse): Response<PostResponse>

    @PUT("/posts/{id}")
    suspend fun putPosts(@Path("id")id:String,@Body body: PostResponse): Response<PostResponse>

    @PATCH("/posts/{id}")
    suspend fun patchPosts(@Path("id")id:String,@Body body: PostResponse): Response<PostResponse>

    @DELETE("/posts/{id}")
    suspend fun deletePosts(@Path("id")id:String): Response<PostResponse>
}