package com.example.deptienda.repository

import com.example.deptienda.data.models.Post
import com.example.deptienda.data.remote.ApiService
import com.example.deptienda.data.repository.PostRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*

class PostRepositoryTest {

    @Test
    fun `getPosts returns expected posts`() = runTest {
        // Arrange
        val expectedPosts = listOf(
            Post(1, 1, "Titulillo 1", "Cuerpo 1"),
            Post(2, 2, "Titulillo 2", "Cuerpo 2")
        )

        val mockApi = mockk<ApiService>()
        coEvery { mockApi.getPosts() } returns expectedPosts

        val repository = PostRepository(mockApi)

        // Act
        val result = repository.getPosts()

        // Assert
        assertEquals(expectedPosts, result)
    }
}