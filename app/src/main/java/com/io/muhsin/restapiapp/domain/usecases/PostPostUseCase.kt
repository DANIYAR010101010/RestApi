package com.io.muhsin.restapiapp.domain.usecases

import com.io.muhsin.restapiapp.data.api.model.PostResponse
import com.io.muhsin.restapiapp.data.repository.PostRepository
import retrofit2.Response
import javax.inject.Inject

class PostPostUseCase@Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(body:PostResponse) = postRepository.postPost(body=body)
}