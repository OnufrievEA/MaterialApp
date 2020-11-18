package com.example.materialapp

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : BaseActivity(), FabFragment.Listener {

    private var passEt: TextInputEditText? = null
    private var passLayout: TextInputLayout? = null
    private var alertBtn: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        val myWatcher = MyTextWatcher(passLayout, passEt)
        passEt?.addTextChangedListener(myWatcher)
    }

    private fun initView() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar as ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true)

        passEt = findViewById(R.id.myEt2)
        passLayout = findViewById(R.id.textInputLayout2)
        alertBtn = findViewById(R.id.alertBtn)

        alertBtn?.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")
        }
    }

    override fun fabClicked() {
        val container = findViewById<CoordinatorLayout>(R.id.container)
        val snackbar = Snackbar.make(
            container,
            resources.getString(R.string.photo_added),
            Snackbar.LENGTH_SHORT
        )
        snackbar.show()
    }
}

