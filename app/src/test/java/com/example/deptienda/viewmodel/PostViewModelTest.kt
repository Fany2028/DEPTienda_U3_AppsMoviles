package com.example.deptienda.viewmodel

import com.example.deptienda.data.models.Post
import com.example.deptienda.data.repository.PostRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*

class PostViewModelTest {

    @Test
    fun `fetchPosts should update postList`() = runTest {
        // Arrange
        val expectedPosts = listOf(
            Post(1, 1, "Titulillo 1", "Cuerpo 1"),
            Post(2, 2, "Titulillo 2", "Cuerpo 2")
        )

        val mockRepository = mockk<PostRepository>()
        coEvery { mockRepository.getPosts() } returns expectedPosts

        // Act
        val viewModel = PostViewModel(mockRepository)
        viewModel.fetchPosts(this)

        advanceUntilIdle()

        // Assert
        assertEquals(expectedPosts, viewModel.postList.value)
    }

    @Test
    fun `postList should be empty initially`() = runTest {
        val mockRepository = mockk<PostRepository>()
        val viewModel = PostViewModel(mockRepository)

        assertTrue(viewModel.postList.value.isEmpty())
    }
}