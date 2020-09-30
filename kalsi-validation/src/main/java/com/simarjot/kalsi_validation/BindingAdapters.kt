package com.simarjot.kalsi_validation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("kalsi_error")
fun handleError(til:TextInputLayout, errorMessage:String?){
    til.error = errorMessage
}

