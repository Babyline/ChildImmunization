package com.babylinechelangat.childimmunization.common.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.babylinechelangat.childimmunization.R
import com.babylinechelangat.childimmunization.databinding.ActivityLandingBinding
import com.babylinechelangat.childimmunization.nurse.ui.NurseDashBoardActivity
import com.google.firebase.auth.FirebaseAuth

class LandingActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private var _binding: ActivityLandingBinding? = null
    private val binding: ActivityLandingBinding? get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            if (firebaseAuth.currentUser != null) {
                val intent = Intent(this, NurseDashBoardActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, NurseDashBoardActivity::class.java)
                startActivity(intent)
            }
        }, 2000)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}