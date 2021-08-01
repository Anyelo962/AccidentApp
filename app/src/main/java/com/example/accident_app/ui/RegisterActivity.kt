package com.example.accident_app.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.accident_app.R
import com.example.accident_app.Repository.Repository
import com.example.accident_app.ViewModels.RegisterUserViewModel
import com.example.accident_app.ViewModels.RegisterViewModelFactory
import com.example.accident_app.Models.RegisterUsers
import com.google.android.material.datepicker.MaterialDatePicker

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: RegisterUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        val firstName: TextInputEditText = findViewById(R.id.id_first_name);
//        val lastName: TextInputEditText = findViewById(R.id.id_last_name);
//        val email : TextInputEditText = findViewById(R.id.id_user_email);
//        val password :TextInputEditText = findViewById(R.id.id_user_password);
//        val password2 : TextInputEditText= findViewById(R.id.id_user_password2)
//        val sex_man : RadioButton = findViewById(R.id.id_sex_man);
//        val sex_woman : RadioButton= findViewById(R.id.id_sex_woman);
//        //val birthDate: RadioButton = findViewById(R.id.id_calendar);
//        val DNI : TextInputEditText= findViewById(R.id.id_number_dni);


        val id_button_calendary:Button = findViewById(R.id.id_calendar);
        id_button_calendary.setOnClickListener(this);

        val repository = Repository()
        val viewModelFactory = RegisterViewModelFactory(repository);
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegisterUserViewModel::class.java);

        val addUser = RegisterUsers(0, "Maicol","Martinez","Maicol02@gmail.com", "123456",
            "M", null,"402-3949588-4",true,null, "Usuario");
        viewModel.userPush(addUser)
        viewModel.Dresponse.observe(this, Observer{ response->
                Log.d("Main", response.firstName);
                Toast.makeText(this,"Entro aqui", Toast.LENGTH_LONG).show();
        })
       // viewModel.getUsers();



//        viewModel.Dresponse.observe(this, Observer { response ->
//            Log.d("Response", response.id.toString())
//            Log.d("Response", response.lastName.toString())
//            Log.d("Response", response.email.toString())
//            Log.d("Response", response.password.toString())
//            Log.d("Response", response.sex.toString())
//            Log.d("Response", response.birthDate.toString())
//            Log.d("Response", response.DNI.toString())
//        })

    }

    override fun onClick(v: View){
            val datePiker = MaterialDatePicker.Builder.datePicker().setTitleText("Fecha de nacimiento")
                .setSelection(MaterialDatePicker.thisMonthInUtcMilliseconds())
                .build();
        datePiker.show(supportFragmentManager,"tag");

            // MaterialDatePicker.Builder.datePicker();
            Toast.makeText(this, "Funciona bien", Toast.LENGTH_LONG).show();
    }
}


