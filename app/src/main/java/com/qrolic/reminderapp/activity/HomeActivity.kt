package com.qrolic.reminderapp.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.qrolic.reminderapp.BuildConfig
import com.qrolic.reminderapp.R
import com.qrolic.reminderapp.fragment.CalendarFragment
import com.qrolic.reminderapp.fragment.DoneReminderFragment
import com.qrolic.reminderapp.fragment.HomeFragment
import com.qrolic.reminderapp.fragment.TodayFragment
import com.qrolic.reminderapp.util.MARKET_URL
import com.qrolic.reminderapp.util.PLAYSTORE_BASE_URL


class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
//        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView = findViewById(R.id.bottomNavigation)

        bottomNavigationView.setOnItemSelectedListener {
                menu ->

            when(menu.itemId){

                R.id.navHome -> {
                    navController.navigate(R.id.nav_home)
                    true
                }

                R.id.navCalendar -> {
                    navController.navigate(R.id.nav_calendar)
                    true
                }

                R.id.navDone -> {
                    navController.navigate(R.id.nav_done)
                    true
                }
                R.id.navToday -> {
                    navController.navigate(R.id.nav_today)
                    true
                }

                R.id.navOverdue -> {
                    navController.navigate(R.id.nav_over_due)
                    true
                }

                else -> false
            }
        }






//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home,
//                R.id.nav_calendar,
//                R.id.nav_done,
//                R.id.nav_over_due,
//                R.id.nav_today,
//                R.id.nav_tomorrow,
//                R.id.nav_upcoming,
//                R.id.nav_settings
//
//
//
//            ), drawerLayout
//        )
//
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        bottomNavigationView.setupWithNavController(navController)
//
//        var menu = bottomNavigationView.menu



    }
    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun setFragment(fr : Fragment){
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.nav_host_fragment,fr)
        frag.commit()
    }

}