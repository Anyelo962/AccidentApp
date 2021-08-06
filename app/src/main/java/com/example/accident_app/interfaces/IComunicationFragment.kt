package com.example.accident_app.interfaces

import androidx.fragment.app.Fragment
import com.example.accident_app.ui.MapActivity
import com.mapbox.mapboxsdk.maps.MapFragment

interface IComunicationFragment {

    fun publishAccident(fragment: Fragment);
    fun getMap(fragment: MapActivity);
    fun numberEmergency(fragment: Fragment);
    fun reportsAccident(fragment: Fragment);
    fun helpUser(fragment: Fragment);
    fun configurationUser(fragment: Fragment);
}