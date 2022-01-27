package com.babylinechelangat.childimmunization.common.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.databinding.FragmentLandingBinding

class LandingFragment : Fragment() {
    private var _binding: FragmentLandingBinding? = null
    private val binding: FragmentLandingBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingBinding.inflate(layoutInflater)
        _binding!!.loginAsParentBtn.setOnClickListener {
            val navController = findNavController()
            navController.navigate(LandingFragmentDirections.actionLandingFragmentToLoginAsParentFragment())
        }
        _binding!!.loginAsNurseBtn.setOnClickListener {
            val navController = findNavController()
            navController.navigate(LandingFragmentDirections.actionLandingFragmentToLoginAsNurseFragment())
        }
        return binding?.root
    }
}
