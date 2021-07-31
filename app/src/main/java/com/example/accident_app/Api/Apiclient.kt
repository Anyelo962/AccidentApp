package com.example.accident_app.Api

import com.example.accident_app.interfaces.IApiclient
import com.example.accident_app.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object Apiclient {

     private val retrofit by lazy{
         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }

    val api: IApiclient by lazy {
        retrofit.create(IApiclient::class.java)
    }
}