package com.example.firstactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(/* id = */ R.id.bottomNavigationView)
        bottomNavigationView.background = null
        val fab : FloatingActionButton = findViewById(R.id.fab)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId != R.id.home) {
                Handler(Looper.getMainLooper()).postDelayed({
                    fab.hide()
                }, 300)

            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    fab.show()
                }, 300)

            }
            Handler(Looper.getMainLooper()).postDelayed({
                changeFragment(it.itemId)
            }, 200)

            true
        }

        changeFragment(R.id.home)
    }



    private fun changeFragment(menuItemId: Int) {
        val ft = supportFragmentManager.beginTransaction()

        when (menuItemId) {
            R.id.home -> ft.replace(R.id.main_frame, Home()).commitAllowingStateLoss()
            R.id.Profile -> ft.replace(R.id.main_frame, Person()).commitAllowingStateLoss()
            R.id.Search -> ft.replace(R.id.main_frame, Search()).commitAllowingStateLoss()
            R.id.Settings -> ft.replace(R.id.main_frame, Settings()).commitAllowingStateLoss()
        }
    }


}


