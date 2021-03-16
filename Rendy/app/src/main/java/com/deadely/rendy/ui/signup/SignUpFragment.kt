package com.deadely.rendy.ui.signup

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.databinding.FragmentSignUpBinding
import com.deadely.rendy.utils.ErrorUtils
import com.deadely.rendy.utils.ValidationUtils
import com.deadely.rendy.utils.snack
import com.google.firebase.auth.UserProfileChangeRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up) {
    override val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            etName.filters = arrayOf(ValidationUtils.filterEmoji)
            etEmail.filters = arrayOf(ValidationUtils.filterEmoji)
            etPassword.filters = arrayOf(ValidationUtils.filterEmoji)

            binding.buttonRegister.isEnabled = false

            etEmail.doAfterTextChanged { viewModel.email = etEmail.text.toString().trim() }
            etName.doAfterTextChanged { viewModel.name = etName.text.toString().trim() }
            etPassword.doAfterTextChanged { viewModel.password = etPassword.text.toString().trim() }
            buttonRegister.setOnClickListener {
                register(
                    etName.text.toString().trim(),
                    etEmail.text.toString().trim(),
                    etPassword.text.toString().trim()
                )
            }
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.valid.collect { isValid ->
                binding.buttonRegister.isEnabled = isValid
            }
        }
    }

    private fun showProgress(show: Boolean) {
        with(binding) {
        }
    }

    private fun register(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val userProfile = UserProfileChangeRequest.Builder().setDisplayName(name).build()
                currentUser?.updateProfile(userProfile)?.addOnSuccessListener {
                    showProgress(false)
                    findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToNavAuthGraph())
                }?.addOnFailureListener {
                    showProgress(false)
                    ErrorUtils.proceed(it) { error -> binding.rootContainer.snack(error) }
                }
            }.addOnFailureListener(requireActivity()) {
                showProgress(false)
                ErrorUtils.proceed(it) { error -> binding.rootContainer.snack(error) }
            }
    }
}
