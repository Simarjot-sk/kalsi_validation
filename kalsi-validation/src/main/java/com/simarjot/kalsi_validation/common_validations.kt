package com.simarjot.kalsi_validation

import android.util.Patterns

fun getMinLengthValidator(minLength: Int): (String) -> String? {
    return { fieldValue ->
        if (fieldValue.length >= minLength) null
        else "This field should contain at least $minLength characters."
    }
}

val requiredValidator = { fieldValue: String ->
    if (fieldValue.isNotEmpty()) null
    else "This field is required."
}

val emailValidator = { fieldValue: String ->
    if (Patterns.EMAIL_ADDRESS.matcher(fieldValue).matches())
        null
    else "Please enter a valid Email."
}

val noneValidator = { _: String ->
    null
}
