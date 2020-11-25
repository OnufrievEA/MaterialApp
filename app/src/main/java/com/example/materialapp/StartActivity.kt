package com.example.materialapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.materialapp.mainScreen.MainFragment
import com.example.materialapp.settings.SettingsFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class StartActivity : BaseActivity(), SettingsFragment.Listener, MainFragment.Listener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)


        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment);

//        appBarConfiguration = AppBarConfiguration(
//            navController.graph,
//            drawer
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
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

    override fun fabClicked() {
        val coordinator = findViewById<CoordinatorLayout>(R.id.coordinator)
        val snackbar = Snackbar.make(coordinator, "Fab clicked", Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}