package com.simarjot.kalsi_validation

import androidx.lifecycle.MediatorLiveData

/**
 *Provides an Abstraction for the validation logic of the whole form.
 */
class KalsiValidator(private val fields:List<KalsiField>) {

    //performs logical AND on all the fields, to find if all fields are valid or not.
    private fun areAllFieldsValid() =
        fields.map { it.isValid() }
            .reduce { acc, errorValue -> acc && errorValue }


    //this value depends on all the fields. if even a single field is changed, error on each field is calculated
    val isValid = MediatorLiveData<Boolean>().apply {
        fields.forEach { field ->
            addSource(field.error) {
                value = areAllFieldsValid()
            }
        }
    }
}
