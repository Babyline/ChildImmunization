package com.babylinechelangat.childimmunization.nurse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babylinechelangat.childimmunization.R
import com.babylinechelangat.childimmunization.databinding.FragmentSignUpAsNurseBinding

class SignUpAsNurseFragment : Fragment() {
    private var _binding: FragmentSignUpAsNurseBinding? = null
    private val binding: FragmentSignUpAsNurseBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpAsNurseBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
