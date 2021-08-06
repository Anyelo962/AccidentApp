package com.example.accident_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accident_app.R
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style

class MapActivity : AppCompatActivity() {
    private var mapView: MapView?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, getString(R.string.MAPBOX_TOKEN));
        setContentView(R.layout.activity_map)

        mapView = findViewById(R.id.id_mapView)

        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapBoxMap ->

            mapBoxMap.setStyle(Style.MAPBOX_STREETS){

            }
        }
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }
}