package com.application.kpti.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.application.kpti.R
import com.application.kpti.databinding.FragmentHomeBinding
import com.application.kpti.ui.home.Epoxy.HomeController
import com.application.kpti.ui.home.Epoxy.HomeProperty
import com.application.kpti.ui.home.Epoxy.PropertyPopuler
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import com.google.android.gms.tasks.Task
import com.google.gson.Gson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import okhttp3.Dispatcher

//@AndroidEntryPoint
class HomeFragment : Fragment(),HomeController.homeOnItemclickListener {

    //get current location
    private lateinit var fusedLocationClient : FusedLocationProviderClient
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val jsonData = "{\n" +
            "  \"init_location\": \"Sleman, D.I Yogyakarta\",\n" +
            "  \"img_user\": \"link_img_user\",\n" +
            "  \"property_populer\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617176534.jpeg\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Griya Kuwat\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617809640.png\",\n" +
            "  \"isFavorite\": false,\n" +
            "      \"property_name\": \"Griya Sedayu\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1628311145.jpg\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Griya Sentosa\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1616913755.jpg\",\n" +
            "  \"isFavorite\": false,\n" +
            "      \"property_name\": \"Sentolo Resident\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"property_terkini\": [\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617176534.jpeg\",\n" +
            "  \"isFavorite\": false,\n" +
            "      \"property_name\": \"Griya Kuwat\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617809640.png\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Griya Sedayu\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1628311145.jpg\",\n" +
            "  \"isFavorite\": false,\n" +
            "      \"property_name\": \"Griya Sentosa\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1616913755.jpg\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Sentolo Resident\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"property_sekitar\": [\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617176534.jpeg\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Griya Kuwat\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617809640.png\",\n" +
            "  \"isFavorite\": false,\n" +
            "      \"property_name\": \"Griya Sedayu\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1628311145.jpg\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Griya Sentosa\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1616913755.jpg\",\n" +
            "  \"isFavorite\": true,\n" +
            "      \"property_name\": \"Sentolo Resident\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        val homeController = HomeController(this)

        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<HomeProperty> = moshi.adapter(HomeProperty::class.java)
        val propetys = jsonAdapter.fromJson(jsonData)

        lifecycleScope.launch {
            homeController.submit(propetys!!)
            withContext(Dispatchers.Main){
                binding.rvHome.setController(homeController)
                homeController.requestModelBuild()
            }
        }
        binding.location.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_locationFragment)
        }

        binding.userAvatar.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_profilFragment)
        }

        checkGPSEnable()
        return view
    }

    override fun onResume() {
        super.onResume()
        when(locationEnabled()){
            true -> getLastLocation()
        }
    }
    override fun OnclickItemPropertypopuler(nameProperty: String) {
        Toast.makeText(context, nameProperty, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_navigation_home_to_detailpropertyFragment)
    }

    override fun OnclickItemPropertyterkini(namaProperty: String) {
        Toast.makeText(context, "Click Item Property Terkini "+namaProperty, Toast.LENGTH_SHORT).show()
    }

    override fun OnclickItemPropertysekitar(namaProperty: String) {
        Toast.makeText(context, "Click Item Property Sekitar "+namaProperty, Toast.LENGTH_SHORT).show()
    }

    private fun locationEnabled() : Boolean {
        val locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun checkGPSEnable(){
        val manager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            val dialogBuilder = AlertDialog.Builder(requireContext())
            dialogBuilder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") { _, _
                        -> startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    }
                    .setNegativeButton("No") { dialog, _ ->
                        dialog.cancel()
                    }
            val alert = dialogBuilder.create()
            alert.show()
        }
    }
    @SuppressLint("MissingPermission")
    fun getLastLocation(){

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        fusedLocationClient.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, object : CancellationToken() {
            override fun isCancellationRequested(): Boolean = false

            override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken = this

        }).addOnSuccessListener {
            val lat = LatLng(it.latitude,it.longitude)
            val scope = CoroutineScope(Job() + Dispatchers.Main)
            scope.launch {
                val Currentlocation = getAddress(lat)
                withContext(Dispatchers.Main){
                    binding.location.text = Currentlocation
                }
            }
        }
    }


    suspend fun getAddress(lat: LatLng) : String? = withContext(Dispatchers.IO) {
        try {
            val geocoder = Geocoder(context)
            val list = geocoder.getFromLocation(lat.latitude, lat.longitude,1)
            list[0].getAddressLine(0)
        } catch (e: java.lang.Exception) {
           "Indonesia"
        }
    }

}