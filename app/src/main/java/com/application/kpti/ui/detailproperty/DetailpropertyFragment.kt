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
import com.application.kpti.R
import com.application.kpti.databinding.DetailpropertyFragmentBinding
import com.application.kpti.databinding.SplashscreenFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailpropertyFragment : Fragment() {

    companion object {
        fun newInstance() = DetailpropertyFragment()
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailpropertyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}