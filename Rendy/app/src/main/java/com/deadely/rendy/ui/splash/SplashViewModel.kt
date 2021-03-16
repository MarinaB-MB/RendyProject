package com.deadely.rendy.ui.splash

import androidx.lifecycle.viewModelScope
import com.deadely.rendy.base.BaseViewModel
import com.deadely.rendy.base.Event
import com.deadely.rendy.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userRepository: UserRepository) :
    BaseViewModel() {

    fun getActiveUser() = viewModelScope.launch {
        delay(2000)
        val isUserExist = userRepository.isActiveUserExist()
        channel.send(SplashEvent.TimerFinishEvent(isUserExist))
    }

    sealed class SplashEvent : Event() {
        class TimerFinishEvent(val isUserExist: Boolean) : SplashEvent()
    }
}
