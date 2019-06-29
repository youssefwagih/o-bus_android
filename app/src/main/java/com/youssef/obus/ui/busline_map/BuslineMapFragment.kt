package com.youssef.obus.ui.busline_map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.youssef.obus.R
import com.youssef.obus.data.models.Checkpoint
import com.youssef.obus.ui.buslines.BuslineMapViewModel
import kotlinx.android.synthetic.main.fragment_busline_map.*


class BuslineMapFragment : Fragment() {

    private lateinit var mapViewModel: BuslineMapViewModel
    private var googleMap: GoogleMap? = null

    companion object {
        fun newInstance() = BuslineMapFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_busline_map, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapViewModel = ViewModelProviders.of(this).get(BuslineMapViewModel::class.java)

        mapView.onCreate(savedInstanceState)

        mapView.onResume() // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(activity!!.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }



        mapView.getMapAsync { mMap ->
            googleMap = mMap

            val busline = BuslineMapFragmentArgs.fromBundle(arguments).busline
            Log.d("buslines", busline.checkpoints.toString())

            for (checkpoint: Checkpoint in busline.checkpoints) {
                mMap.addMarker(MarkerOptions().position(checkpoint.latLang).title(checkpoint.name)).showInfoWindow()
            }

            mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    busline.checkpoints[0].latLang,
                    15.0f
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}
