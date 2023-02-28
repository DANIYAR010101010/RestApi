package com.io.muhsin.restapiapp.domain.usecases

import com.io.muhsin.restapiapp.data.repository.PostRepository
import javax.inject.Inject

class GetAllPostsUseCase@Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke() = postRepository.getAllPosts()
}