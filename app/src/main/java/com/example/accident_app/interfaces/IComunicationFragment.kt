package com.example.accident_app.interfaces

import androidx.fragment.app.Fragment

interface IComunicationFragment {

    fun publishAccident(fragment: Fragment);
    fun getMap(fragment: Fragment);
    fun numberEmergency(fragment: Fragment);
    fun reportsAccident(fragment: Fragment);
    fun helpUser(fragment: Fragment);
    fun configurationUser(fragment: Fragment);
}