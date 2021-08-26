package com.example.accident_app.ui
import android.app.ProgressDialog
import android.content.Intent
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
import java.util.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: RegisterUserViewModel
    private lateinit var firstName: TextInputLayout;
    private lateinit var lastName: TextInputLayout;
    private lateinit var email: TextInputLayout;
    private lateinit var password :TextInputLayout;
    private lateinit var password2 :TextInputLayout;
    private lateinit var sex_man : RadioButton;
    private lateinit var sex_woman : RadioButton;
    private lateinit var birthDate:Button;
    private lateinit var DNI: TextInputLayout;
    private lateinit var button_register: FloatingActionButton;
    private lateinit var sexChecked:String;

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firstName = findViewById(R.id.id_first_name) as TextInputLayout;
        lastName= findViewById(R.id.id_last_name) as TextInputLayout;
        email = findViewById(R.id.id_user_email) as TextInputLayout;
        password = findViewById(R.id.id_user_password) as TextInputLayout;
        password2 = findViewById(R.id.id_user_password2) as TextInputLayout
        sex_man = findViewById(R.id.id_sex_man) as RadioButton;
        sex_woman = findViewById(R.id.id_sex_woman) as RadioButton;
        birthDate = findViewById(R.id.id_calendar) as Button;
        DNI= findViewById(R.id.id_number_dni) as TextInputLayout;
        button_register = findViewById(R.id.id_register_user) as FloatingActionButton;


        val id_button_calendary:Button = findViewById(R.id.id_calendar);
        id_button_calendary.setOnClickListener(this);

       // viewModel.getUsers();

        button_register.setOnClickListener {

         //   Toast.makeText(this, ""+firstName.editText?.text.toString(), Toast.LENGTH_LONG).show();

//            val addUser = RegisterUsers(firstName.editText?.text.toString()
//                ,lastName.editText?.text.toString(),
//                email.toString(), password.toString(),
//                "M", null,DNI.toString(),true,null, "Usuario");

            addNewUser()
//            val addUser = RegisterUsers("Maicol","Lorenzo","LorenzoM@gmail.com",
//                "1234567",
//                "M", getCurrentDateTime(),"402-3905968-4",true,getCurrentDateTime(), "Usuario");
//            viewModel.userPush2(addUser)
////            viewModel.userPush2(firstName.toString(),lastName.toString(),email.toString(), password.toString(),
////                "M", getCurrentDateTime(),DNI.toString(),true,getCurrentDateTime(), "Usuario")


        }
    }
    fun addNewUser(){

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Registrando")
        progressDialog.setMessage("Creando su nueva cuenta")
        progressDialog.show()
        val repository = Repository()
        val viewModelFactory = RegisterViewModelFactory(repository);
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegisterUserViewModel::class.java);

        if(firstName.editText?.text.toString() != null && lastName.editText?.text.toString() != null
            && DNI.editText?.text.toString() != null && email.editText?.text.toString() != null
        ){

            if(password.editText?.text.toString() != password2.editText?.text.toString()){
                Toast.makeText(this,"Las contraseñas deben coincidir!", Toast.LENGTH_SHORT).show()
                progressDialog.hide()
            }
            if(sex_man.isChecked){
                sexChecked = "M"
            }
            else if (sex_woman.isChecked){
                sexChecked = "F"
            }
            else{
                Toast.makeText(this, "Debe seleccionar el sexo", Toast.LENGTH_SHORT).show()
                progressDialog.hide()
            }

                var addUser = RegisterUsers(firstName.editText?.text.toString(),lastName.editText?.text.toString(),
                    email.editText?.text.toString(), password.editText?.text.toString(), sexChecked,
                    getCurrentDateTime(), DNI.editText?.text.toString(), true, getCurrentDateTime(), "Usuario")

                viewModel.userPush2(addUser);

                viewModel.pushUsers2.observe(this, Observer{ response->
                    if(response.isSuccessful){
                       progressDialog.hide()
                        val intent = Intent(this, LoginActivity::class.java);
                        startActivity(intent);
                    }
                    else{
                        progressDialog.hide()
                        Toast.makeText(this,"Problemas para realizar la inserción", Toast.LENGTH_LONG).show();
                    }
                })

        }
        else{
            Toast.makeText(this,"Debe completar todos los campos para realizar el registro.", Toast.LENGTH_LONG).show()
        }
    }




    override fun onClick(v: View){
            val datePiker = MaterialDatePicker.Builder.datePicker().setTitleText("Fecha de nacimiento")
                .setSelection(MaterialDatePicker.thisMonthInUtcMilliseconds())
                .build();
        datePiker.show(supportFragmentManager,"tag");

            // MaterialDatePicker.Builder.datePicker();
            Toast.makeText(this, "Funciona bien", Toast.LENGTH_LONG).show();
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}

