package com.application.kpti.ui.home

import android.os.Bundle
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
import com.google.gson.Gson

class HomeFragment : Fragment(),HomeController.homeOnItemclickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val jsonData = "{\n" +
            "  \"init_location\": \"Sleman, D.I Yogyakarta\",\n" +
            "  \"img_user\": \"link_img_user\",\n" +
            "  \"property_populer\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617176534.jpeg\",\n" +
            "      \"property_name\": \"Griya Kuwat\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617809640.png\",\n" +
            "      \"property_name\": \"Griya Sedayu\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1628311145.jpg\",\n" +
            "      \"property_name\": \"Griya Sentosa\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4,\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1616913755.jpg\",\n" +
            "      \"property_name\": \"Sentolo Resident\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"property_terkini\": [\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617176534.jpeg\",\n" +
            "      \"property_name\": \"Griya Kuwat\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617809640.png\",\n" +
            "      \"property_name\": \"Griya Sedayu\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1628311145.jpg\",\n" +
            "      \"property_name\": \"Griya Sentosa\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1616913755.jpg\",\n" +
            "      \"property_name\": \"Sentolo Resident\",\n" +
            "      \"price\": \"100.000.000\",\n" +
            "      \"location\": \"Mlati, Sleman\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"property_sekitar\": [\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617176534.jpeg\",\n" +
            "      \"property_name\": \"Griya Kuwat\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1617809640.png\",\n" +
            "      \"property_name\": \"Griya Sedayu\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1628311145.jpg\",\n" +
            "      \"property_name\": \"Griya Sentosa\",\n" +
            "      \"distance\": \"1 KM dari lokasi anda\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"img_property\": \"https://kpti.co.id/uploads/market/small/1616913755.jpg\",\n" +
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
        val homeController = HomeController(homeOnItemclickListener = this)
        binding.rvHome.setController(homeController)
        val json = Gson().fromJson<HomeProperty>(jsonData,HomeProperty::class.java)
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

    override fun OnclickItemPropertyterkini() {

    }

    override fun OnclickItemPropertysekitar() {

    }
}