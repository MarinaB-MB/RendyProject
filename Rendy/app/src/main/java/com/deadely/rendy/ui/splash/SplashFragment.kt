package com.deadely.rendy.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.base.Event
import com.deadely.rendy.databinding.FragmentSplashBinding
import com.deadely.rendy.utils.setFullscreen
import com.deadely.rendy.utils.showActionBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment :
    BaseFragment<FragmentSplashBinding, SplashViewModel>(R.layout.fragment_splash) {
    override val viewModel: SplashViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFullscreen(true)
        showActionBar(false)
        viewModel.getActiveUser()
    }

    override fun onReceiveEvent(event: Event) {
        super.onReceiveEvent(event)
        when (event) {
            is SplashViewModel.SplashEvent.TimerFinishEvent -> {
                if (event.isUserExist) {
                    openMainAuthScreen()
                } else {
                    openChoiceScreen()
                }
            }
        }
    }

    private fun openMainAuthScreen() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNavAuthGraph())
    }

    private fun openChoiceScreen() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToChoiceFragment())
    }
}
