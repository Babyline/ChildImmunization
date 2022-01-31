package com.babylinechelangat.childimmunization.nurse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.R
import com.babylinechelangat.childimmunization.databinding.FragmentNurseLoginBinding

class LoginAsNurseFragment : Fragment() {

    private var _binding: FragmentNurseLoginBinding? = null
    private val binding: FragmentNurseLoginBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNurseLoginBinding.inflate(inflater)
        _binding!!.forgotPasswordBtn.setOnClickListener {
            val navController = findNavController()
             navController.navigate(LoginAsNurseFragmentDirections.actionLoginAsNurseFragmentToForgotPasswordFragment())
        }

        _binding!!.signUpInsteadBtn.setOnClickListener {
            this.findNavController().navigate(LoginAsNurseFragmentDirections.actionLoginAsNurseFragmentToSignUpAsNurseFragment())
        }
       return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}
