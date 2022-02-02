package com.babylinechelangat.childimmunization.nurse.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.databinding.FragmentNurseLoginBinding
import com.babylinechelangat.childimmunization.util.LoadingDialog
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginAsNurseFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth

    private var _binding: FragmentNurseLoginBinding? = null
    private val binding: FragmentNurseLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()
        _binding = FragmentNurseLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitBtn.setOnClickListener {
            val email = binding.emailInput.text.toString().trim { it < ' ' }
            val password = binding.passwordInput.text.toString().trim { it < ' ' }
            if (email.isEmpty() || password.isEmpty()) {
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "Email or password cannot be empty",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if (!email.contains("@")){
                Toast.makeText(requireActivity(), "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            else {
                login(email, password)
            }
        }
        binding.forgotPasswordBtn.setOnClickListener {
            val navController = findNavController()
            navController.navigate(LoginAsNurseFragmentDirections.actionLoginAsNurseFragmentToForgotPasswordFragment())
        }
        binding.signUpInsteadBtn.setOnClickListener {
            this.findNavController()
                .navigate(LoginAsNurseFragmentDirections.actionLoginAsNurseFragmentToSignUpAsNurseFragment())
        }
    }

    private fun login(email: String, password: String) {
        val dialog = LoadingDialog.createDialog(requireActivity())
        dialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                dialog.dismiss()
                if (task.isSuccessful) {
                    Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        "Signed in as ${task.result?.user?.email}",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    val intent = Intent(context, NurseDashBoardActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                } else {
                    Toast.makeText(context, task.exception?.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
