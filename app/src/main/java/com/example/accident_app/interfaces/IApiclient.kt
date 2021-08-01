package com.example.accident_app.interfaces

import com.example.accident_app.Models.RegisterUsers
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IApiclient {
    @GET("User/")
    suspend fun getUsers():RegisterUsers

    @POST("User/")
    suspend fun pushUser(
        @Body users: RegisterUsers
    ): Response<RegisterUsers>

}