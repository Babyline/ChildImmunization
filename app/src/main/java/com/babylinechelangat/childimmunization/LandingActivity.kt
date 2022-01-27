package com.babylinechelangat.childimmunization

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.babylinechelangat.childimmunization.databinding.ActivityLandingBinding
import com.babylinechelangat.childimmunization.parent.LoginFragment

class LandingActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginAsParentBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.loginAsNurseBtn.setOnClickListener {
            loginAsNurse()
        }
    }

    private fun loginAsParent() {
        val loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction()
            .add( loginFragment, LoginFragment.TAG)
            .commitNow()
    }

    private fun loginAsNurse() {

    }

}
