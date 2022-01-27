package com.babylinechelangat.childimmunization.parent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.babylinechelangat.childimmunization.databinding.FragmentSignUpAsParentBinding

class SignUpAsParentFragment: Fragment() {
    private var _binding: FragmentSignUpAsParentBinding? = null
    private val binding: FragmentSignUpAsParentBinding? get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpAsParentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
