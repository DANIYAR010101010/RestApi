package com.io.muhsin.restapiapp.domain.usecases

import com.io.muhsin.restapiapp.data.api.model.PostResponse
import com.io.muhsin.restapiapp.data.repository.PostRepository
import javax.inject.Inject

class PatchPostUseCase@Inject constructor(private val postRepository: PostRepository) {
    suspend fun invoke(id:String,body:PostResponse) = postRepository.patchPost(id = id,body = body)
}