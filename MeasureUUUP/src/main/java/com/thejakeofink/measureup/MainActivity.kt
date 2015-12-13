package com.thejakeofink.measureup

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.main_toolbar) as Toolbar?

        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar.title = "We did it!"

        drawer = findViewById(R.id.drawer_view) as DrawerLayout?

        var drawerToggle = object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.empty, R.string.empty) {

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }

        drawer?.setDrawerListener(drawerToggle);
        drawerToggle.syncState()

        val navView = findViewById(R.id.nav_view) as NavigationView

        navView.setNavigationItemSelectedListener {
            var toastText = getStringData(it.itemId)
            Snackbar.make(drawer, toastText, Snackbar.LENGTH_INDEFINITE).show()
            return@setNavigationItemSelectedListener true
        }
    }

    fun getStringData(action: Int): String {
        when (action) {
            R.id.action_data -> return getString(R.string.title_activity_data)
            R.id.action_length -> return getString(R.string.title_activity_length)
            R.id.action_mass -> return getString(R.string.title_activity_mass)
            R.id.action_temp -> return getString(R.string.title_activity_temp)
            R.id.action_tip -> return getString(R.string.title_activity_tip)
            R.id.action_volume -> return getString(R.string.title_activity_volume)
            else -> return ""
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.action_settings -> {
                Snackbar.make(drawer, "Some Snacky Snack", Snackbar.LENGTH_INDEFINITE).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
