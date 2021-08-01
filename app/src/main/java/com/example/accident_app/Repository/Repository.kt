package com.example.accident_app.Repository

import com.example.accident_app.Api.Apiclient
import com.example.accident_app.Models.RegisterUsers
import retrofit2.Response

class Repository {
    suspend fun getUsers():RegisterUsers{
       return Apiclient.api.getUsers()
    }

    suspend fun pushUser(user:RegisterUsers): Response<RegisterUsers>{
        return Apiclient.api.pushUser(user)
    }
}