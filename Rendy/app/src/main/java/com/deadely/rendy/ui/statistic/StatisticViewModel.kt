package com.deadely.rendy.ui.statistic

import com.deadely.rendy.base.BaseViewModel
import com.deadely.rendy.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticViewModel @Inject constructor(private val userRepository: UserRepository) :
    BaseViewModel() {

    init {
    }
}
