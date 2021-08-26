package com.example.accident_app.ui

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accident_app.R
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.accident_app.Repository.Repository
import com.example.accident_app.ViewModels.LoginUserViewModel
import com.example.accident_app.ViewModels.RegisterUserViewModel
import com.example.accident_app.ViewModels.RegisterViewModelFactory
import com.example.accident_app.models.LoginUser
import com.example.accident_app.models.RegisterUsers

class LoginActivity : AppCompatActivity() {

    private lateinit var email_login:EditText;
    private lateinit var password_login:EditText;
    private lateinit var button_login:Button;
    private lateinit var viewModel: LoginUserViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var button_register = findViewById<TextView>(R.id.id_register_user);
        email_login = findViewById<EditText>(R.id.id_email_login);
        password_login = findViewById<EditText>(R.id.id_password_login);
        button_login = findViewById<Button>(R.id.id_button_login);

        button_login.setOnClickListener{

        //Login();
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        button_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java);
            startActivity(intent)
        }
    }

    fun Login(){

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere por favor")
        progressDialog.setMessage("Iniciando sesion")
        progressDialog.show()

        val repository = Repository()

        val viewModelFactory = LoginUserViewModel(repository);

     //   viewModel = ViewModelProvider(this, viewModelFactory).get(LoginUserViewModel::class.java);

        if(email_login.text.toString() != null && password_login.text.toString() != null) {

            var user = LoginUser(email_login.text.toString(), password_login.text.toString());

            viewModel.Login_User(user);
            viewModel.Dresponse.observe(this, Observer{ response ->
                if(response.isSuccessful){
                    progressDialog.hide()
                    Toast.makeText(this,"Funciona", Toast.LENGTH_LONG).show();
//                    val intent = Intent(this, MainActivity::class.java);
//                    startActivity(intent);
                }
                else{
                    progressDialog.hide()
                    Toast.makeText(this,"", Toast.LENGTH_LONG).show();
                }
            })
        }
        else{
            Toast.makeText(this,"", Toast.LENGTH_LONG).show()
        }
    }
}