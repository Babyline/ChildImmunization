package com.babylinechelangat.childimmunization.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.databinding.FragmentAuthBinding
import com.google.firebase.auth.FirebaseAuth

class AuthFragment : Fragment() {
    private var _binding: FragmentAuthBinding? = null
    private val binding: FragmentAuthBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(layoutInflater)
        _binding!!.loginAsParentBtn.setOnClickListener {
            val navController = findNavController()
            navController.navigate(AuthFragmentDirections.actionAuthFragmentToLoginAsParentFragment())
        }
        _binding!!.loginAsNurseBtn.setOnClickListener {
            val navController = findNavController()
            navController.navigate(AuthFragmentDirections.actionAuthFragmentToLoginAsNurseFragment())
        }
        return binding?.root
    }
}
