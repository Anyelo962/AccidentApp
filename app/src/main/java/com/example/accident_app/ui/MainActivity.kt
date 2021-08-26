package com.example.accident_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.accident_app.R
import androidx.fragment.app.Fragment
import com.example.accident_app.Fragment.*
import com.example.accident_app.interfaces.IComunicationFragment
import com.example.accident_app.interfaces.ISetting
import com.example.accident_app.util.CallInterfaceForFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), IComunicationFragment, ISetting {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom_navigation:BottomNavigationView = findViewById(R.id.id_bottom_navigation);

        val homeFragment = HomeFragment();
        val noticeFragment = NoticeFragment();
        val notificationFragment = NotificationFragment();


        makeCurrentFragment(noticeFragment)

        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.ic_home ->{
                    makeCurrentFragment(noticeFragment)
                    true
                }
                R.id.ic_favorite->{
                    makeCurrentFragment(homeFragment)
                    true
                }
                R.id.id_notification -> {
                    makeCurrentFragment(notificationFragment)

                    true;
                }
                else -> false
            }
        }
    }


    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.id_fl_wrapper, fragment)
                .commit()
        }

    override fun publishAccident(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.id_fl_wrapper, PublishFragment()).commit();
            addToBackStack("MainActivity");
        }
    }

    override fun getMap(fragment: MapActivity) {
        val intent = Intent(this, MapActivity::class.java );
        startActivity(intent);
    }

//    override fun getMap(fragment: Activity) {
//
//        val intent = Intent(this, MapActivity::class.java );
//        startActivity(intent);
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.id_fl_wrapper, MapFragment()).commit();
//            addToBackStack("MainActivity");
//            Toast.makeText(baseContext, "Paso por aqui", Toast.LENGTH_LONG).show();
//        }
//    }

    override fun numberEmergency(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                //Toast.makeText(baseContext, "Llego aqui", Toast.LENGTH_LONG).show();
                replace(R.id.id_fl_wrapper, EmergenciesFragment()).commit();
                addToBackStack("MainActivity");
            }
    }

    override fun reportsAccident(fragment: Fragment) {
        TODO("Not yet implemented")
    }

    override fun helpUser(fragment: Fragment) {
        TODO("Not yet implemented")
    }

    override fun configurationUser(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.id_fl_wrapper, SettingFragment()).commit();
            addToBackStack("MainActivity")
        }
    }

    override fun backToHome() {
        TODO("Not yet implemented")
    }

    override fun settingConfiguration(fragment: Fragment) {

    }

}