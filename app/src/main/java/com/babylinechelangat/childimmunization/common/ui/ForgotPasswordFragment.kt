package com.babylinechelangat.childimmunization.common.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.databinding.FragmentForgotPasswordBinding
import com.babylinechelangat.childimmunization.util.LoadingDialog
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordFragment : Fragment() {
  private var _binding: FragmentForgotPasswordBinding? = null
    private val binding: FragmentForgotPasswordBinding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitBtn.setOnClickListener {
           val email = binding.emailInput.text.toString().trim { it < ' '}
            if (email.isNotEmpty() || !email.contains("@")) {
                Toast.makeText(requireActivity(), "Invalid email address", Toast.LENGTH_SHORT).show()
            } else {
                firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Snackbar.make(
                                view,
                                "Password reset email link sent to $email. Check inbox",
                                Snackbar.LENGTH_SHORT
                            ).show()
                            val navController = findNavController()
                            navController.navigate(ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToAuthFragment())
                        } else {
                            Toast.makeText(requireActivity(), task.exception?.message.toString(), Toast.LENGTH_SHORT ).show()
                        }
                    }
            }
        }
    }
}
