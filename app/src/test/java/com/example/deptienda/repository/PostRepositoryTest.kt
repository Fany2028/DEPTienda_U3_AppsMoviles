package com.example.deptienda.repository

import com.example.deptienda.data.models.Post
import com.example.deptienda.data.remote.ApiService
import com.example.deptienda.data.repository.PostRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest

class TesteablePostRepository(private val testApi: ApiService): PostRepository(){
    override suspend fun getPosts():List<Post>{
        return testApi.getPosts()
    }
}

class PostRepositoryTest: StringSpec(body = {
    "getPosts() debe retornar una lista simulada de Posts"{
        //1. Simular resultado de API
        val fakePosts = listOf(
            Post(1, 1, "Titulillo 1", "Cuerpo 1"),
            Post(2, 2, "Titulillo 2", "Cuerpo 2")
        )

        //2. Mock de ApiService
        val mockApi = mockk<ApiService>()
        coEvery { mockApi.getPosts() } returns fakePosts

        //3. Usar clase test inyectando el mock
        val repo = TesteablePostRepository(mockApi)

        //4.Ejecutar test
        runTest {
            val result = repo.getPosts()
            result shouldContainExactly fakePosts
        }
    }
})