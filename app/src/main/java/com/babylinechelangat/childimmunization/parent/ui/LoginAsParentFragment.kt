package com.babylinechelangat.childimmunization.parent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.databinding.FragmentParentLoginBinding

class LoginAsParentFragment : Fragment() {

    private var _binding: FragmentParentLoginBinding? = null
    private val binding: FragmentParentLoginBinding? get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParentLoginBinding.inflate(layoutInflater)
        _binding!!.forgotPasswordBtn.setOnClickListener {
            this.findNavController().navigate(LoginAsParentFragmentDirections.actionLoginAsParentFragmentToForgotPasswordFragment())
        }
        _binding!!.signUpInsteadBtn.setOnClickListener {
            this.findNavController().navigate(LoginAsParentFragmentDirections.actionLoginAsParentFragmentToSignUpAsParentFragment())
        }
        return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
