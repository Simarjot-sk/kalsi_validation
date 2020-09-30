package com.simarjot.mvvmformtest

import android.util.Patterns
import com.simarjot.kalsi_validation.KalsiField
import com.simarjot.kalsi_validation.KalsiValidator

class LoginForm {

    val email = KalsiField {
        if (Patterns.EMAIL_ADDRESS.matcher(it).matches())
            null
        else "Please Enter a valid Email"
    }

    val password = KalsiField {
        if (it.length < 8)
            "Password should be at least 8 characters long."
        else null
    }

    val nonMandatoryField = KalsiField {
        return@KalsiField null
    }

    val kalsiValidator =
        KalsiValidator(listOf(email, password))
}
