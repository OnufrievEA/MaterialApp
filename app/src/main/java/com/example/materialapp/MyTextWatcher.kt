package com.example.materialapp

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MyTextWatcher(
    private val inputLayout: TextInputLayout,
    private val et: TextInputEditText
) : TextWatcher {

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        et.text?.let {
            if (it.length > 5) inputLayout.error = "Too long"
            else inputLayout.error = ""
        }
    }
}