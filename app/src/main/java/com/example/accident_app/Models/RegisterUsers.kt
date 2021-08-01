package com.example.accident_app.Models

import com.google.gson.annotations.SerializedName
import java.util.*

data class RegisterUsers(
   val id:Int,
   val firstName:String,
   val lastName:String,
   val email:String,
   val password:String,
   val sex: String,
   val birthDate:Date?,
   @SerializedName("idCard")
   val DNI: String,
   val status:Boolean,
   val creationDate: Date?,
   val name: String,
)