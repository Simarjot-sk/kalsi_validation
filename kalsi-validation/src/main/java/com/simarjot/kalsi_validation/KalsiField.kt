package com.simarjot.kalsi_validation

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

/**
 * Encapsulates validation login of a field along with the error message and the actual value of the field.
 *
 * Constructor Arguments: Takes a validation function as a parameter, which will return a String message if there is an error,
 * and null is there is no error in the field.
 */
class KalsiField(val validation: (fieldValue: String) -> String?) {
    /**
     * Creates a field with required validator.
     */
    constructor() : this(requiredValidator)

    val fieldValue = MutableLiveData<String?>()
    val error = MediatorLiveData<String?>()

    init {
        //initializing error with null. So no errors appear till user has made changes to field
        error.value = ""

        error.addSource(fieldValue) {
            //this block will be called every time there is a change in field.
            it?:return@addSource
            error.value = validation(it)
        }
    }

    //error will contain null when field is valid and a String message otherwise.
    fun isValid() = error.value == null
}