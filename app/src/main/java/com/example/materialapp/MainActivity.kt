package com.example.materialapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var passEt: TextInputEditText
    private lateinit var passLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passEt = findViewById(R.id.myEt2)
        passLayout = findViewById(R.id.textInputLayout2)

        val myWatcher = MyTextWatcher(passLayout, passEt)
        passEt.addTextChangedListener(myWatcher)
    }
}

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