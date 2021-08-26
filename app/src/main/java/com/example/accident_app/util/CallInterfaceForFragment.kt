package com.example.accident_app.util

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.accident_app.Fragment.GeneralConfigurationFragment
import com.example.accident_app.Fragment.SettingFragment
import com.example.accident_app.R
import com.example.accident_app.interfaces.ISetting

class CallInterfaceForFragment : AppCompatActivity(), ISetting
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.call_interface_activity)



    }
        override fun backToHome() {
            TODO("Not yet implemented")
        }


        override fun settingConfiguration(fragment:Fragment) {
            supportFragmentManager.beginTransaction().apply {
                Toast.makeText(baseContext, "Funciona", Toast.LENGTH_LONG).show();
                replace(R.id.id_setting_activity, GeneralConfigurationFragment()).commit()
                addToBackStack("SettingFragment")
            }
        }
}