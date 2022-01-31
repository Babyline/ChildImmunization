package com.babylinechelangat.childimmunization.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babylinechelangat.childimmunization.databinding.ActivityAuthBinding

class AuthActivity: AppCompatActivity() {
    private var _binding: ActivityAuthBinding? = null
    private val binding: ActivityAuthBinding? get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}
