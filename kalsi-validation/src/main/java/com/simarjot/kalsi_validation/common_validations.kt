package com.simarjot.kalsi_validation

import android.util.Patterns

fun getMinLengthValidator(minLength: Int): (KalsiField, String?) -> String? {
    return { _:KalsiField, fieldValue: String? ->
        if (fieldValue == null || fieldValue.length < minLength)
            "This field should contain at least $minLength characters."
        else null
    }
}

val requiredValidator = { _:KalsiField, fieldValue: String? ->
    if (fieldValue.isNullOrEmpty())
        "This field is required."
    else null
}

val emailValidator = { _:KalsiField, fieldValue: String? ->
    if (fieldValue == null || !Patterns.EMAIL_ADDRESS.matcher(fieldValue).matches())
        "Please enter a valid Email."
    else null
}

val noneValidator = { _:KalsiField, _: String? ->
    null
}
