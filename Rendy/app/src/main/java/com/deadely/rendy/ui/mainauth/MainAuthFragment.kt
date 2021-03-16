package com.deadely.rendy.ui.mainauth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.databinding.FragmentMainAuthBinding
import com.deadely.rendy.utils.setFullscreen
import com.deadely.rendy.utils.setupWithNavController
import com.deadely.rendy.utils.showActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainAuthFragment :
    BaseFragment<FragmentMainAuthBinding, MainAuthViewModel>(R.layout.fragment_main_auth) {
    override val viewModel: MainAuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFullscreen(false)
        showActionBar(true)
        if (savedInstanceState == null) {
            binding.navAuthView.init(childFragmentManager)
        }
    }

    private fun BottomNavigationView?.init(fragmentManager: FragmentManager) {
        val navGraphIds = listOf(
            R.navigation.nav_statistic, R.navigation.nav_lessons
        )
        this?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = fragmentManager,
            containerId = R.id.navAuthHostFragment,
        )
    }
}
