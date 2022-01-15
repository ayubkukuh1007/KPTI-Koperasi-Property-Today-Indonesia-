package com.application.kpti.ui.detailproperty

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.R
import com.application.kpti.databinding.DetailpropertyFragmentBinding
import com.application.kpti.databinding.SplashscreenFragmentBinding
import com.application.kpti.ui.detailproperty.adappter.LocationListDetailPropertyAdapter
import com.application.kpti.ui.detailproperty.model.Data
import com.application.kpti.ui.detailproperty.model.ListDataProperty
import com.application.kpti.ui.location.adapter.LocationRecentlyListAdapter
import com.application.kpti.ui.location.model.Filter_Location
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.gson.Gson

class DetailpropertyFragment : Fragment(),LocationListDetailPropertyAdapter.OnItemClickListener{

    private lateinit var locationListDetailPropertyAdapter :LocationListDetailPropertyAdapter
    val jsonData = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"123\",\n" +
            "      \"property_image\": \"https://kpti.co.id/uploads/market/1617178962.jpeg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"123\",\n" +
            "      \"property_image\": \"https://kpti.co.id/uploads/market/1617178962.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"123\",\n" +
            "      \"property_image\": \"https://kpti.co.id/uploads/market/16171789621.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"123\",\n" +
            "      \"property_image\": \"https://kpti.co.id/uploads/market/16171789621.jpeg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"123\",\n" +
            "      \"property_image\": \"https://kpti.co.id/uploads/market/16171789623.jpeg\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    private var _binding: DetailpropertyFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailpropertyViewModel
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailpropertyFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val bottomSheet = binding.detailBottomsheet
        val gson = Gson().fromJson<ListDataProperty>(jsonData, ListDataProperty::class.java)
        locationListDetailPropertyAdapter = LocationListDetailPropertyAdapter(context = requireContext(),dataDetailProperties = gson.data,onItemClickListener = this)
        binding.rvphotos.adapter = locationListDetailPropertyAdapter
        binding.rvphotos.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.HORIZONTAL, false)
        locationListDetailPropertyAdapter.notifyDataSetChanged()


        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        binding.btnFavorite.setOnClickListener {

        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailpropertyFragment_to_navigation_home)
        }

        binding.pinLocation.setOnClickListener {
            findNavController().navigate(R.id.action_detailpropertyFragment_to_mapsFragment)
        }

        return view
    }

    override fun onItemDetailPropertyClick(listdataproperty: Data) {
        Toast.makeText(context, listdataproperty.id, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailpropertyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}