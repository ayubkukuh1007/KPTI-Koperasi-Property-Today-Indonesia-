package com.application.kpti.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.application.kpti.databinding.FragmentProfilBinding
import com.application.kpti.ui.profil.adapter.AdapterProfileViewpager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterProfileViewpager2 : AdapterProfileViewpager2
    private val titles = arrayOf("Info", "Favorite", "Setting")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val view = binding.root
        //add tab
        binding.profileTab.addTab(binding.profileTab.newTab().setText("Info"))
        binding.profileTab.addTab(binding.profileTab.newTab().setText("Favorite"))
        binding.profileTab.addTab(binding.profileTab.newTab().setText("Setting"))

        adapterProfileViewpager2 = AdapterProfileViewpager2(this)

        binding.profileViewPager2.adapter =  adapterProfileViewpager2

        TabLayoutMediator(
            binding.profileTab,
            binding.profileViewPager2
        ) { tab: TabLayout.Tab, position: Int -> tab.setText(titles.get(position))
            }.attach()

        return view
    }

}