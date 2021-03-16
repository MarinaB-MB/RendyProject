package com.deadely.rendy.ui.statistic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.deadely.rendy.DatabaseManager
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.databinding.FragmentStatisticBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticFragment :
    BaseFragment<FragmentStatisticBinding, StatisticViewModel>(R.layout.fragment_statistic) {
    override val viewModel: StatisticViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DatabaseManager.getDatabaseValue(
            "users/${currentUser?.uid}",
            {
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            },
            {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        )
    }
}
