package com.babylinechelangat.childimmunization.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babylinechelangat.childimmunization.databinding.ActivityLandingBinding

class LandingActivity: AppCompatActivity() {
    private var _binding: ActivityLandingBinding? = null
    private val binding: ActivityLandingBinding? get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}
