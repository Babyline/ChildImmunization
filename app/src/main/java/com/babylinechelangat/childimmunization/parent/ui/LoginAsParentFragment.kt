package com.babylinechelangat.childimmunization.parent.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.babylinechelangat.childimmunization.databinding.FragmentParentLoginBinding
import com.babylinechelangat.childimmunization.nurse.ui.NurseDashBoardActivity
import com.babylinechelangat.childimmunization.util.LoadingDialog
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.log

class LoginAsParentFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private var _binding: FragmentParentLoginBinding? = null
    private val binding: FragmentParentLoginBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParentLoginBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {

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
            this.findNavController().navigate(LoginAsParentFragmentDirections.actionLoginAsParentFragmentToForgotPasswordFragment())
        }
        binding.signUpInsteadBtn.setOnClickListener {
            this.findNavController().navigate(LoginAsParentFragmentDirections.actionLoginAsParentFragmentToSignUpAsParentFragment())
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
                    val intent = Intent(context, ParentDashBoardActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                } else {
                    Toast.makeText(context, task.exception?.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
