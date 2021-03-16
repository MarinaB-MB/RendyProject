package com.deadely.rendy.utils

import android.text.InputFilter

object ValidationUtils {

    val filterEmoji = InputFilter { source, start, end, _, _, _ ->
        for (i in start until end) {
            val type = Character.getType(source[i])
            if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                return@InputFilter ""
            }
        }
        null
    }
}
