package com.deadely.rendy.utils

import android.util.Log
import com.deadely.rendy.App
import com.deadely.rendy.R
import com.google.firebase.auth.FirebaseAuthException
import retrofit2.HttpException
import java.net.UnknownHostException

object ErrorUtils {
    fun proceed(t: Throwable, body: (message: String) -> Unit = {}) {
        Log.e("ErrorUtils.Throwable: ", t.message.toString())
        when (t) {
            is FirebaseAuthException -> {
                when (t.errorCode) {
                    "ERROR_EMAIL_ALREADY_IN_USE" -> body("Данный email уже используется.")
                    "ERROR_INVALID_EMAIL" -> body("Неверный email.")
                    "ERROR_WRONG_PASSWORD" -> body("Неверный пароль.")
                    "ERROR_WEAK_PASSWORD" -> body("Слабый пароль.")
                }
            }
            is HttpException -> body(t.message.toString())
            is UnknownHostException -> body(App.instance.getString(R.string.internet_connection_error))
            else -> body(App.instance.getString(R.string.unexpected_error))
        }
    }
}
