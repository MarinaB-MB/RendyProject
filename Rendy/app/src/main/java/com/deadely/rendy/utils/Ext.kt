package com.deadely.rendy.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.deadely.rendy.App
import com.google.android.material.snackbar.Snackbar

fun Fragment.showActionBar(isShow: Boolean) {
    if (isShow) {
        (activity as AppCompatActivity).supportActionBar?.show()
    } else {
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}

fun Activity.setFullscreen(isFullscreen: Boolean) {
    if (isFullscreen) {
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}

fun Fragment.setFullscreen(isFullscreen: Boolean) {
    activity?.setFullscreen(isFullscreen)
}

fun View.snack(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}

fun View.snack(stringId: Int) {
    Snackbar.make(this, App.instance.getString(stringId), Snackbar.LENGTH_SHORT).show()
}
