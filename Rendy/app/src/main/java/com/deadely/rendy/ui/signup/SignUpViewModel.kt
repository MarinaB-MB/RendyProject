package com.deadely.rendy.ui.signup

import android.util.Patterns
import com.deadely.rendy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : BaseViewModel() {
    var name = ""
        set(value) {
            field = value
            validate()
        }

    var email = ""
        set(value) {
            field = value
            validate()
        }

    var password = ""
        set(value) {
            field = value
            validate()
        }
    private val _valid = MutableStateFlow(false)
    val valid = _valid

    private fun validate() {
        val condition = name.length >= 4 && Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password.length > 6
        _valid.value = condition
    }
}
