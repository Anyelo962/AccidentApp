package com.example.accident_app.Repository

import com.example.accident_app.Api.Apiclient
import com.example.accident_app.models.LoginUser
import com.example.accident_app.models.RegisterUsers
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*

class Repository {

    suspend fun getUsers():RegisterUsers{
       return Apiclient.api.getUsers();
    }

     suspend fun pushUser(firstName:String, lastName:String, email:String, password:String, sex:String,
                          birthDate: Date, idCard:String, status:Boolean, creationDate:Date, name:String
                          ): Response<RegisterUsers>{
        return Apiclient.api.pushUser(firstName, lastName, email,password,sex,birthDate, idCard, status, creationDate, name);
    }

    suspend fun pushUser2(registerUsers: RegisterUsers) : Response<RegisterUsers>{
        return Apiclient.api.pushUser2(registerUsers);
    }

    suspend fun loginUser(loginUser: LoginUser) : Response<LoginUser>{
        return Apiclient.api.pushLogin(loginUser);
    }

}