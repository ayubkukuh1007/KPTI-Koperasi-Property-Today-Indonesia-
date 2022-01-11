package com.application.kpti.ui.splashscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.application.kpti.R
import com.application.kpti.databinding.SplashscreenFragmentBinding

class SplashscreenFragment : Fragment() {

    private var _binding: SplashscreenFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var animFadein : Animation //img bottom
    private lateinit var animTransaltexl : Animation //img bottom
    private lateinit var animTransaltexr : Animation //img bottom
    private lateinit var animTransaltey : Animation //img bottom

    companion object {
        fun newInstance() = SplashscreenFragment()
    }

    private lateinit var viewModel: SplashscreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SplashscreenFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        //animate
        animFadein = AnimationUtils.loadAnimation(context,R.anim.splash_fade_in)
        animTransaltexl = AnimationUtils.loadAnimation(context,R.anim.splash_translate_toright)
        animTransaltexr = AnimationUtils.loadAnimation(context,R.anim.splash_translate_toleft)
        animTransaltey = AnimationUtils.loadAnimation(context,R.anim.splash_translate_tobottom)

        binding.logo.startAnimation(animTransaltey)
        binding.splashLine1.startAnimation(animFadein)
        binding.bottomImg.startAnimation(animFadein)
        binding.btnGetstarted.startAnimation(animTransaltexl)
        binding.splashLine2.startAnimation(animTransaltexr)
        binding.splashLine2.startAnimation(animTransaltexr)

        binding.btnGetstarted.setOnClickListener {
            findNavController().navigate(R.id.action_splashscreenFragment_to_loginFragment)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashscreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}