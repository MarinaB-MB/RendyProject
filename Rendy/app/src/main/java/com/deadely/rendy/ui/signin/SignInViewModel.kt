package com.deadely.rendy.ui.signin

import android.util.Patterns
import com.deadely.rendy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : BaseViewModel() {
    var email = ""
        set(value) {
            field = value
            validateForm()
        }
    var password = ""
        set(value) {
            field = value
            validateForm()
        }

    private val _valid = MutableStateFlow(false)
    val valid = _valid

    private fun validateForm() {
        val condition = Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && password.isNotEmpty() && password.length > 6 && email.isNotEmpty()
        _valid.value = condition
    }
}
