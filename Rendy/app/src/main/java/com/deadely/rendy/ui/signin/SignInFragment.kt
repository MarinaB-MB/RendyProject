package com.deadely.rendy.ui.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.databinding.FragmentSignInBinding
import com.deadely.rendy.utils.ErrorUtils
import com.deadely.rendy.utils.snack
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {
    override val viewModel: SignInViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        initObservers()
    }

    private fun setListeners() {
        with(binding) {
            etEmail.doAfterTextChanged { viewModel.email = etEmail.text.toString().trim() }
            etPassword.doAfterTextChanged { viewModel.password = etPassword.text.toString().trim() }
            buttonSignIn.setOnClickListener {
                login(etEmail.text.toString().trim(), etPassword.text.toString().trim())
            }
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.valid.collect { isValid ->
                binding.buttonSignIn.isEnabled = isValid
            }
        }
    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener { data ->
            updateUser(email, password)
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToNavAuthGraph())
        }.addOnFailureListener(requireActivity()) {
            ErrorUtils.proceed(it) { error ->
                binding.rootContainer.snack(error)
            }
        }
    }

    private fun updateUser(email: String, password: String) {
        val database = Firebase.database
        val reference = database.getReference("users/${auth.currentUser.uid}/")
        val user = UserOne(email = email, password = password)
        reference.setValue(user)
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.e("TAG", "onDataChange: ${snapshot.value}")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", "onDataChange: ${error.message}")
            }
        })
    }
}

data class UserOne(
    val email: String,
    val password: String
)
