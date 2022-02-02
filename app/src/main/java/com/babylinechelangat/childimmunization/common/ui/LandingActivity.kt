package com.babylinechelangat.childimmunization.common.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.babylinechelangat.childimmunization.R
import com.babylinechelangat.childimmunization.common.Constants
import com.babylinechelangat.childimmunization.databinding.ActivityLandingBinding
import com.babylinechelangat.childimmunization.nurse.ui.NurseDashBoardActivity
import com.babylinechelangat.childimmunization.parent.ui.ParentDashBoardActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LandingActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseFirestore: FirebaseFirestore
    private var _binding: ActivityLandingBinding? = null
    private val binding: ActivityLandingBinding? get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLandingBinding.inflate(layoutInflater)
        firebaseFirestore = FirebaseFirestore.getInstance()
        setContentView(binding?.root)
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            if (firebaseAuth.currentUser != null) {
                firebaseFirestore
                    .collection(Constants.usersCollection)
                    .document(firebaseAuth.currentUser!!.uid)
                    .addSnapshotListener { documentSnapshot, firebaseFirestoreException ->
                        if (firebaseFirestoreException != null) {
                            Log.d("firestoreException", firebaseFirestoreException.message.toString())
                            return@addSnapshotListener
                        }
                        if(documentSnapshot?.get("userClass") == "Nurse") {
                            val intent = Intent(this, NurseDashBoardActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val intent = Intent(this, NurseDashBoardActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

            } else {
                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}