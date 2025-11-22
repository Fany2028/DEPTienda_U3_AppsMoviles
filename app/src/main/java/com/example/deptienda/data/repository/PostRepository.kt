package com.example.deptienda.data.repository

import com.example.deptienda.data.models.Post
import com.example.deptienda.data.remote.RetrofitInstance

//Accede a datos usando Retrofit
class PostRepository{
    //Obtiene posts desde API
    suspend fun getPosts(): List<Post>{
        return RetrofitInstance.api.getPosts()
    }
}