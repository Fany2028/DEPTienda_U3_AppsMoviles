package com.example.deptienda.data.repository

import com.example.deptienda.data.models.Post
import com.example.deptienda.data.remote.RetrofitInstance

open class PostRepository {
    open suspend fun getPosts(): List<Post> {
        return try {
            println("Iniciando el getPosts()...")
            println("RetrofitInstance: $RetrofitInstance")

            val posts = RetrofitInstance.api.getPosts()
            println("Llamada a API exitosa, ${posts.size} posts obtenidos")

            if (posts.isNotEmpty()) {
                println("📝 Primer post: ${posts[0].title}")
            }
            posts
        } catch (e: Exception) {
            println("Error en API: ${e.message}")
            e.printStackTrace()
            getSamplePosts()
        }
    }

    private fun getSamplePosts(): List<Post> {
        println("Usando datos de prueba")
        return listOf(
            Post(userId = 1, id = 1, title = "Tít. Ej. 1", body = "Cuerpo ejemplo 1"),
            Post(userId = 1, id = 2, title = "Tít. Ej. 2", body = "Cuerpo ejemplo 2")
        )
    }
}