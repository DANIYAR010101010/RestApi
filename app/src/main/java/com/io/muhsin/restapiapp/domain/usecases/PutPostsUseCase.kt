package com.io.muhsin.restapiapp.domain.usecases

import com.io.muhsin.restapiapp.data.api.model.PostResponse
import com.io.muhsin.restapiapp.data.repository.PostRepository
import javax.inject.Inject

class PutPostsUseCase@Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(id: String,body : PostResponse) = postRepository.putPost(id = id,body =body)
}