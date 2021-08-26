package com.example.accident_app.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accident_app.Repository.Repository
import com.example.accident_app.models.LoginUser
import com.example.accident_app.models.RegisterUsers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginUserViewModel(private var repository: Repository): ViewModel() {

    var Dresponse: MutableLiveData<Response<LoginUser>> = MutableLiveData();

    fun Login_User(loginUser: LoginUser){
        viewModelScope.launch {
           val response = repository.loginUser(loginUser)

            Dresponse.value = response;
        }
    }



}