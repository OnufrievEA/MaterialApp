package com.example.materialapp

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class SettingsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        initView()
    }

    private fun initView() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar as ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true)

        val blueBtn = findViewById<MaterialButton>(R.id.blueBtn)
        val orangeBtn = findViewById<MaterialButton>(R.id.orangeBtn)

        blueBtn.setOnClickListener {
            setMainTheme(true)
            recreate()
        }
        orangeBtn.setOnClickListener {
            setMainTheme(false)
            recreate()
        }
    }

}