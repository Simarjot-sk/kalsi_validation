package com.simarjot.kalsi_validation

import android.util.Patterns

fun getMinLengthValidator(minLength: Int): (String?) -> String? {
    return { fieldValue: String? ->
        if (fieldValue == null || fieldValue.length < minLength)
            "This field should contain at least $minLength characters."
        else null
    }
}

val requiredValidator = { fieldValue: String? ->
    if (fieldValue.isNullOrEmpty())
        "This field is required."
    else null
}

val emailValidator = { fieldValue: String? ->
    if (fieldValue == null || !Patterns.EMAIL_ADDRESS.matcher(fieldValue).matches())
        "Please enter a valid Email."
    else null
}

val noneValidator = { _: String? ->
    null
}
