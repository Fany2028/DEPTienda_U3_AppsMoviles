package com.example.deptienda.data.repository

import com.example.deptienda.data.models.Post
import com.example.deptienda.data.remote.RetrofitInstance

class PostRepository {
    suspend fun getPosts(): List<Post> {
        return try {
            println("Obteniendo posts de la API...")
            val posts = RetrofitInstance.api.getPosts()
            println("Se obtuvieron ${posts.size} posts")
            if (posts.isNotEmpty()) {
                println("📝 Primer post: ${posts[0].title}")
            }
            posts
        } catch (e: Exception) {
            println("Error en API: ${e.message}")
            getSamplePosts()
        }
    }

    private fun getSamplePosts(): List<Post> {
        println("Datos de prueba")
        return listOf(
            Post(
                userId = 1,
                id = 1,
                title = "Tít. Ej. 1",
                body = "Este es el cuerpo del primer post de ejemplo."
            ),
            Post(
                userId = 1,
                id = 2,
                title = "Tít. Ej. 2",
                body = "Este es el cuerpo del segundo post."
            )
        )
    }
}