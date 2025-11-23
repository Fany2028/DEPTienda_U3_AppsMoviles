package com.example.deptienda.data.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton: patrón de diseño que garantiza la existencia de una sola instancia de una clase durante la ejecución del programa
//Singleton que contiene la config. de Retrofit
object RetrofitInstance{
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com") //Cambiar por la url de la api
            .addConverterFactory(GsonConverterFactory.create()) //Converter JSON
            .build()
            .create(ApiService::class.java) //Implementa interfaz ApiService
    }
}