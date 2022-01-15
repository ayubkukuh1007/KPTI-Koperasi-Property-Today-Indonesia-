package com.application.kpti.ui.home

import android.annotation.SuppressLint
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.kpti.R
import com.application.kpti.databinding.FragmentHomeBinding
import com.application.kpti.ui.home.Epoxy.HomeController
import com.application.kpti.ui.home.Epoxy.HomeProperty
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import com.google.android.gms.tasks.Task
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.Dispatcher


class HomeFragment : Fragment(),HomeController.homeOnItemclickListener {

    //get current location
    private lateinit var fusedLocationClient : FusedLocationProviderClient
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val stest = "{\n" +
            "  \"isFavorite\": true,\n" +
            "  \"isString\": \"isString\"\n" +
            "}"

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
        getLastLocation()
        val homeController = HomeController(homeOnItemclickListener = this)
        binding.rvHome.setController(homeController)
        val json = Gson().fromJson<HomeProperty>(jsonData, HomeProperty::class.java)
        homeController.submit(json)

        binding.location.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_locationFragment)
        }
        return view
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
                getAddress(lat)
            }
        }
    }


    suspend fun getAddress(lat: LatLng) = withContext(Dispatchers.IO) {
        try {
            val geocoder = Geocoder(context)
            val list = geocoder.getFromLocation(lat.latitude, lat.longitude,1)
            withContext(Dispatchers.Main){
                binding.location.text = list[0].getAddressLine(0)
            }
        } catch (e: java.lang.Exception) {
            "Indonesia"
        }
    }

}