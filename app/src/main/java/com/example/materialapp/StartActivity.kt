package com.example.materialapp

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.materialapp.mainScreen.MainFragment
import com.example.materialapp.settings.SettingsFragment
import com.example.materialapp.startFragment.StartFragment

class StartActivity : BaseActivity(), SettingsFragment.Listener, MainFragment.Listener,
    StartFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        if (savedInstanceState == null) {
            val startFragment = StartFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, startFragment)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
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

    override fun fragmentStartBackBtnClicked() {
    }


    override fun fragmentStartNextBtnClicked() {
        val mainFragment = MainFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, mainFragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun fragmentMainBackBtnClicked() {
        supportFragmentManager.popBackStack()
    }

    override fun fragmentMainNextBtnClicked() {
        val settingsFragment = SettingsFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, settingsFragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun fragmentSettingsBackBtnClicked() {
        supportFragmentManager.popBackStack()
    }

    override fun fragmentSettingsNextBtnClicked() {
    }

}


//        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.main, R.id.color_chose), drawer)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navigationView.setupWithNavController(navController)


//        val toggle = ActionBarDrawerToggle(
//            this,
//            drawer,
//            toolbar,
//            0,
//            0
//        )
//        drawer.addDrawerListener(toggle)
//        toggle.syncState()
//
////        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        navigationView.setNavigationItemSelectedListener(this)


//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.main -> startActivity(Intent(this, MainActivity::class.java))
//            R.id.color_chose -> startActivity(Intent(this, SettingsActivity::class.java))
//        }
//        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
//        drawer.closeDrawer(GravityCompat.START)
//        return false
//    }

//    override fun onBackPressed() {
//        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }