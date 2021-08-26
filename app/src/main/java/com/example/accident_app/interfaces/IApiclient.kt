package com.example.accident_app.interfaces

import com.example.accident_app.models.LoginUser
import com.example.accident_app.models.RegisterUsers
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface IApiclient {
    @GET("User")
    suspend fun getUsers():RegisterUsers

    @FormUrlEncoded
    @POST("User")
    suspend fun pushUser(
        @Field("firstName") firstName:String,
        @Field("lastName") lastName:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("sex") sex:String,
        @Field("birthDate") birthDate:Date,
        @Field("idCard") idCard:String,
        @Field("status") status:Boolean,
        @Field("creationDate") creationDate:Date,
        @Field("name") name:String,

    ): Response<RegisterUsers>

    @POST("User")
    suspend fun pushUser2(@Body registerUsers: RegisterUsers): Response<RegisterUsers>

    @POST("User/Login")
    suspend fun pushLogin(loginUser: LoginUser) : Response<LoginUser>
}