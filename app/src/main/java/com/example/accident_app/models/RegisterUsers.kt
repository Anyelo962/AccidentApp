package com.example.accident_app.models

import java.util.*

data class RegisterUsers(
   val firstName:String = "",
   val lastName:String = "",
   val email:String = "",
   val password:String = "",
   val sex: String = "",
   val birthDate:Date? = null,
   //@serializeName("idCard")
   val idCard: String = "",
   val status:Boolean = true,
   val creationDate: Date? = null,
   val name: String = "",
)