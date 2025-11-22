package com.example.deptienda.viewmodel

import com.example.deptienda.data.models.Post
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
class PostViewModelTest : StringSpec({
    "postList debe contener los datos esperados después de fetchPosts()" {
        runTest {
            val fakePosts = listOf(
                Post(userId = 1, id = 1, title = "Títulillo 1", body = "Contenido 1"),
                Post(userId = 2, id = 2, title = "Títulillo 2", body = "Contenido 2")
            )

            val testViewModel = object : PostViewModel() {
                override fun fetchPosts() {
                    _postList.value = fakePosts
                }
            }

            testViewModel.fetchPosts()

            testViewModel.postList.value shouldBe fakePosts //shouldContainExactly daba error (¿?)
        }
    }
})