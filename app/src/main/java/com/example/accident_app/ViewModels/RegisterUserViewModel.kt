package com.example.accident_app.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accident_app.Repository.Repository
import com.example.accident_app.models.RegisterUsers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*

class RegisterUserViewModel(private val repository: Repository): ViewModel() {

    val Dresponse : MutableLiveData<Response<RegisterUsers>> = MutableLiveData();
    var pushUsers : MutableLiveData<Response<RegisterUsers>> = MutableLiveData();
    var pushUsers2: MutableLiveData<Response<RegisterUsers>> = MutableLiveData();

//    fun getUsers(){
//        viewModelScope.launch {
//            val response : Response<RegisterUsers> = repository.pushUser(RegisterUsers())
//            Dresponse.value = response
//        }
//    }

    fun userPush2 (userRegisterUsers: RegisterUsers){
        viewModelScope.launch {
            val response = repository.pushUser2(userRegisterUsers);
            pushUsers2.value = response;
        }
    }

    fun userPush(firstName:String, lastName:String, email:String, password:String, sex:String,
                 birthDate: Date, idCard:String, status:Boolean, creationDate: Date, name:String){
        viewModelScope.launch {
            val response: Response<RegisterUsers> = repository.pushUser(firstName, lastName, email,password,sex,birthDate, idCard, status, creationDate, name);
            pushUsers.value = response
        }
    }

//    fun userPush(users: RegisterUsers){
//        viewModelScope.launch {
//            val response: Response<RegisterUsers> = repository.pushUser(users);
//            pushUsers.value = response
//        }
//    }

}