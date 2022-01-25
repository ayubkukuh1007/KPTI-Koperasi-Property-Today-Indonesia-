package com.application.kpti.helper

import android.content.Context
import android.widget.Toast

public fun Context.showmessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}