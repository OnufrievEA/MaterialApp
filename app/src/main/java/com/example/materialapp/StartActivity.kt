package com.example.materialapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.materialapp.mainScreen.MainFragment
import com.example.materialapp.settings.SettingsFragment
import com.google.android.material.navigation.NavigationView

class StartActivity : BaseActivity(), SettingsFragment.Listener, MainFragment.Listener {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.startFragment, R.id.mainFragment, R.id.settingsFragment
            ), drawer
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
    }

    override fun colorBtnClicked(btnId: Int) {
        when (btnId) {
            R.id.blueBtn -> {
                setMainTheme(true)
                recreate()
            }
            R.id.orangeBtn -> {
                setMainTheme(false)
                recreate()
            }
        }
    }

    override fun alertBtnClicked() {
        val myDialogFragment = MyDialogFragment()
        val manager = supportFragmentManager
        myDialogFragment.show(manager, "myDialog")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}