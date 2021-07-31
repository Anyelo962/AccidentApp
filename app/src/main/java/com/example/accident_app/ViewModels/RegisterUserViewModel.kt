package com.example.accident_app.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accident_app.Repository.Repository
import com.example.accident_app.models.RegisterUsers
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterUserViewModel(private val repository: Repository): ViewModel() {

    val Dresponse : MutableLiveData<RegisterUsers> = MutableLiveData();
    val pushUsers : MutableLiveData<Response<RegisterUsers>> = MutableLiveData();
    fun getUsers(){
        viewModelScope.launch {
            val response : RegisterUsers = repository.getUsers()
            Dresponse.value = response
        }
    }

    fun userPush(users: RegisterUsers){
        viewModelScope.launch {
            val response: Response<RegisterUsers> = repository.pushUser(users);
            pushUsers.value = response
        }
    }

}