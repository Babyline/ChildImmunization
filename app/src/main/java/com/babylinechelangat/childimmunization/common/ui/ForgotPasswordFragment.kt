package com.babylinechelangat.childimmunization.common.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babylinechelangat.childimmunization.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
  private var _binding: FragmentForgotPasswordBinding? = null
    private val binding: FragmentForgotPasswordBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding?.root
    }
}
