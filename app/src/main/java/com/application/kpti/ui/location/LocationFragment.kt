package com.application.kpti.ui.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.R
import com.application.kpti.databinding.LocationFragmentBinding
import com.application.kpti.ui.location.adapter.LocationChoosestateListAdapter
import com.application.kpti.ui.location.adapter.LocationRecentlyListAdapter
import com.application.kpti.ui.location.model.ChooseState
import com.application.kpti.ui.location.model.Filter_Location
import com.application.kpti.ui.location.model.Recently
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class LocationFragment : Fragment(),
    LocationRecentlyListAdapter.OnItemClickListener,
    LocationChoosestateListAdapter.OnItemClickListener{

    private var _binding: LocationFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LocationViewModel
    private lateinit var locationRecentlyListAdapter :LocationRecentlyListAdapter
    private lateinit var locationChoosestateListAdapter: LocationChoosestateListAdapter

    val jsonData = "{\n" +
            "  \"recently\": [\n" +
            "    {\n" +
            "      \"location_name\": \"Yogyakarta\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Bekasi\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Bogor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Bantul\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Wates\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Sukoharjo\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"choose_state\": [\n" +
            "    {\n" +
            "      \"location_name\": \"Yogyakarta\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Bekasi\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Bogor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Bantul\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Wates\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"location_name\": \"Sukoharjo\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LocationFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<Filter_Location> = moshi.adapter(Filter_Location::class.java)
        val locations = jsonAdapter.fromJson(jsonData)

        locationRecentlyListAdapter = LocationRecentlyListAdapter(context = requireContext(),location = locations!!.recently,onItemClickListener = this)
        binding.rvRecenly.adapter = locationRecentlyListAdapter
        binding.rvRecenly.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.VERTICAL, false)

        locationChoosestateListAdapter = LocationChoosestateListAdapter(context = requireContext(),location = locations.choose_state,onItemClickListener = this)
        binding.rvChooseState.adapter = locationChoosestateListAdapter
        binding.rvChooseState.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.VERTICAL, false)

        binding.imgLocationExit.setOnClickListener {
            findNavController().navigate(R.id.action_locationFragment_to_navigation_home)
        }

        return view
    }

    override fun onItemRecentlyClick(location: Recently) {
        Toast.makeText(context, location.location_name, Toast.LENGTH_SHORT).show()
    }

    override fun onItemChoosestateClick(location: ChooseState) {
        Toast.makeText(context,location.location_name, Toast.LENGTH_SHORT).show()
    }
}