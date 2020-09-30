package com.simarjot.mvvmformtest

import com.simarjot.kalsi_validation.*

class LoginForm {

    val email = KalsiField(emailValidator)

    val password = KalsiField(getMinLengthValidator(8))

    val nonMandatoryField = KalsiField(noneValidator)

    val requiredField = KalsiField(requiredValidator)

    val kalsiValidator =
        KalsiValidator(listOf(email, password, requiredField))
}
