//No reconoce el PostScreen

package com.example.deptienda.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.deptienda.data.models.Post
import com.example.deptienda.ui.navigation.PostScreen
import com.example.deptienda.viewmodel.PostViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Rule
import org.junit.Test

class PostScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<androidx.activity.ComponentActivity>()

    @Test
    fun titulo_post() {
        // Simular datos que viewmodel entregaría
        val fakePosts = listOf(
            Post(userId = 1, id = 1, title = "Titulillo 1", body = "Contenido 1"),
            Post(userId = 2, id = 2, title = "Titulillo 2", body = "Contenido 2")
        )

        // Falsa subclase de PostViewModel, con StateFlow simulado
        val fakeViewModel = object : PostViewModel() {
            override val postList: StateFlow<List<Post>> = MutableStateFlow(fakePosts)
        }

        // Renderizar el PostScreen con el viewModel falso
        composeRule.setContent {
            PostScreen(viewModel = fakeViewModel)
        }

        // Validar que los títulos se muestren correctamente en UI
        composeRule.onNodeWithText("Titulillo 1").assertIsDisplayed()
        composeRule.onNodeWithText("Titulillo 2").assertIsDisplayed()
    }
}