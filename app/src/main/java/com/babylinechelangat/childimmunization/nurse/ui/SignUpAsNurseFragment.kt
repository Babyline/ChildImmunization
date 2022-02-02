package com.babylinechelangat.childimmunization.nurse.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.babylinechelangat.childimmunization.common.Constants
import com.babylinechelangat.childimmunization.databinding.FragmentSignUpAsNurseBinding
import com.babylinechelangat.childimmunization.common.model.User
import com.babylinechelangat.childimmunization.util.LoadingDialog
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class SignUpAsNurseFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseFirestore: FirebaseFirestore
    private var _binding: FragmentSignUpAsNurseBinding? = null
    private val binding: FragmentSignUpAsNurseBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseFirestore = FirebaseFirestore.getInstance()
        _binding = FragmentSignUpAsNurseBinding.inflate(layoutInflater)
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
                signUp(email, password)
            }
        }
    }

    private fun signUp(email: String, password: String) {
        val dialog = LoadingDialog.createDialog(requireActivity())
        dialog.show()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                dialog.dismiss()
                if (task.isSuccessful) {
                    val id = task.result?.user?.uid!!
                    val firstname = binding.firstnameInput.text.toString().trim { it < ' ' }
                    val lastname = binding.lastnameInput.text.toString().trim { it < ' ' }
                    val phone = binding.phoneInput.text.toString().trim { it < ' ' }
                    val usersClass = User.fromUserClassToString(User.Companion.UserClass.Nurse)
                    if (firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty()) {
                        Toast.makeText(requireActivity(), "One or more fields is empty", Toast.LENGTH_SHORT).show()
                    } else {
                        val user = User(id, firstname, lastname, email, phone, usersClass)
                        firebaseFirestore
                            .collection(Constants.usersCollection)
                            .document(id)
                            .set(user, SetOptions.merge())
                            .addOnCompleteListener {
                                val intent =
                                    Intent(requireActivity(), NurseDashBoardActivity::class.java)
                                startActivity(intent)
                                requireActivity().finish()
                            }
                    }
                } else {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
