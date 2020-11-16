package com.example.materialapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : BaseActivity(), FabFragment.Listener {

    private lateinit var passEt: TextInputEditText
    private lateinit var passLayout: TextInputLayout
    private lateinit var alertButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        alertButton.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")
        }

        val myWatcher = MyTextWatcher(passLayout, passEt)
        passEt.addTextChangedListener(myWatcher)
    }

    private fun initView() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        passEt = findViewById(R.id.myEt2)
        passLayout = findViewById(R.id.textInputLayout2)
        alertButton = findViewById(R.id.buttonEnabled)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu);
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
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

