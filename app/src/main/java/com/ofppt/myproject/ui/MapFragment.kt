package com.ofppt.myproject.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ofppt.myproject.R


class MapFragment : DialogFragment() {

    private lateinit var googleMap: GoogleMap
    var lat = 0.0
    var lng = 0.0
    var name : String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.map_layout, container, false)

        name = requireArguments().getString("name")
        lat = requireArguments().getDouble("lat")
        lng = requireArguments().getDouble("lng")

        val mapFragment =
            childFragmentManager?.findFragmentById(R.id.map_fragment) as? SupportMapFragment



            mapFragment!!.getMapAsync(OnMapReadyCallback { mMap: GoogleMap ->
                if (activity != null) {
                    googleMap = mMap
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                    googleMap.getUiSettings().setMyLocationButtonEnabled(true)
                    googleMap.getUiSettings().setCompassEnabled(true)
                    googleMap.getUiSettings().setRotateGesturesEnabled(true)
                    googleMap.getUiSettings().setZoomGesturesEnabled(true)

                    // Add a marker in Sydney and move the camera
                    val latlng = LatLng(lat, lng)
                    googleMap.addMarker(MarkerOptions().position(latlng).title(name))
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng))


                }

            })

        return v
    }


}