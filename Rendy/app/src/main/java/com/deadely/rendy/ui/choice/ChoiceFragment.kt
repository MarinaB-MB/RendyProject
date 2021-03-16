package com.deadely.rendy.ui.choice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.databinding.FragmentChoiceBinding
import com.deadely.rendy.utils.setFullscreen
import com.deadely.rendy.utils.showActionBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChoiceFragment :
    BaseFragment<FragmentChoiceBinding, ChoiceViewModel>(R.layout.fragment_choice) {

    override val viewModel: ChoiceViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFullscreen(false)
        showActionBar(true)
        binding.buttonSignIn.setOnClickListener {
            findNavController().navigate(ChoiceFragmentDirections.actionChoiceFragmentToSignInFragment())
        }
        binding.buttonSignUp.setOnClickListener {

            findNavController().navigate(ChoiceFragmentDirections.actionChoiceFragmentToSignUpFragment())
        }
    }
}
