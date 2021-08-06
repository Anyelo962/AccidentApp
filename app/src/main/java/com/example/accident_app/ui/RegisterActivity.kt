package com.example.accident_app.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.accident_app.R
import com.example.accident_app.Repository.Repository
import com.example.accident_app.ViewModels.RegisterUserViewModel
import com.example.accident_app.ViewModels.RegisterViewModelFactory
import com.example.accident_app.models.RegisterUsers
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate
import java.time.LocalDateTime

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: RegisterUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val firstName: TextInputLayout = findViewById(R.id.id_first_name);
        val lastName: TextInputLayout = findViewById(R.id.id_last_name);
        val email : TextInputLayout = findViewById(R.id.id_user_email);
        val password :TextInputLayout = findViewById(R.id.id_user_password);
        val password2 : TextInputLayout= findViewById(R.id.id_user_password2)
        val sex_man : RadioButton = findViewById(R.id.id_sex_man);
        val sex_woman : RadioButton= findViewById(R.id.id_sex_woman);
        val birthDate:Button = findViewById(R.id.id_calendar);
        val DNI : TextInputLayout= findViewById(R.id.id_number_dni);
        val button_register: FloatingActionButton = findViewById(R.id.id_register_user);

        val id_button_calendary:Button = findViewById(R.id.id_calendar);
        id_button_calendary.setOnClickListener(this);

        val repository = Repository()
        val viewModelFactory = RegisterViewModelFactory(repository);
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegisterUserViewModel::class.java);


       // viewModel.getUsers();

        button_register.setOnClickListener {
            val addUser = RegisterUsers(0, firstName.toString(),lastName.toString(),email.toString(), password.toString(),
                "M", null,DNI.toString(),true,null, "Usuario");
            viewModel.userPush(addUser)
            viewModel.Dresponse.observe(this, Observer{ response->

                Toast.makeText(this,"Entro aqui", Toast.LENGTH_LONG).show();
            })
            Toast.makeText(this,"Usuario agregado", Toast.LENGTH_LONG).show();
        }


//        viewModel.Dresponse.observe(this, Observer { response ->
//            Log.d("Response", response.id.toString())
//            Log.d("Response", response.lastName.toString())
//            Log.d("Response", response.email.toString())
//            Log.d("Response", response.password.toString())
//            Log.d("Response", response.sex.toString())
//            Log.d("Response", response.birthDate.toString())
//            Log.d("Response", response.DNI.toString())
//        })

        viewModel.Dresponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body().toString())
                Log.d("Response", response.body().toString())
                Log.d("Response", response.body().toString())
                Log.d("Response", response.body().toString())
                Log.d("Response", response.body().toString())
                Log.d("Response", response.body().toString())
                Log.d("Response", response.body().toString())
            }
            else{
                Toast.makeText(this, response.code(), Toast.LENGTH_LONG).show();
            }
        })

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

