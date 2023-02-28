package com.io.muhsin.restapiapp.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.muhsin.restapiapp.data.api.model.PostResponse
import com.io.muhsin.restapiapp.domain.usecases.*
import com.io.muhsin.restapiapp.domain.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val postPostsUseCase: PostPostUseCase,
    private val putPostsUseCase: PutPostsUseCase,
    private val patchPostsUseCase: PatchPostUseCase,
    private val deletePostsUseCase: DeletePostUseCase,
) : ViewModel() {
    private val _allPostsResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse: LiveData<NetworkResult<List<PostResponse>>>
        get() = _allPostsResponse

    init {
      getAllPosts()
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }
    fun postPosts(){
        viewModelScope.launch {
            postPostsUseCase.invoke(body = PostResponse(title= "Test title", body ="Test body" ))
        }
    }
    fun putPost() {
        viewModelScope.launch {
            putPostsUseCase.invoke(id = "1", body = PostResponse(title = "Test title", body = "Test body")).let {
                Log.d("checkData", "data: ${it.data}")
            }
        }
    }

    fun patchPost() {
        viewModelScope.launch {
            patchPostsUseCase.invoke(id = "1", body = PostResponse(title = "Test title", body = "Test body")).let {
                Log.d("checkData", "data: ${it.data}")
            }
        }
    }

    fun deletePost() {
        viewModelScope.launch {
            deletePostsUseCase.invoke(id = "1").let {
                Log.d("checkData", "data: ${it.data}")
            }
        }
    }

}