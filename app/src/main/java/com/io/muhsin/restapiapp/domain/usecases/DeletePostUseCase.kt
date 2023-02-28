package com.io.muhsin.restapiapp.domain.usecases

import com.io.muhsin.restapiapp.data.repository.PostRepository
import javax.inject.Inject

class DeletePostUseCase@Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(id:String) = postRepository.deletePost(id = id)
}