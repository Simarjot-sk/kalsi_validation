package com.simarjot.mvvmformtest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val loginForm = LoginForm()

    fun validate() {
       loginForm.kalsiValidator.validateAllFieldsManually()
    }
}