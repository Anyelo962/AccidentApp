package com.example.accident_app.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class RegisterUsers(
   val id:Int = 0,
   val firstName:String = "",
   val lastName:String = "",
   val email:String = "",
   val password:String = "",
   val sex: String = "",
   val birthDate:Date? = null,
   @SerializedName("idCard")
   val DNI: String = "",
   val status:Boolean = true,
   val creationDate: Date? = null,
   val name: String = "",
)