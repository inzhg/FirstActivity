package com.example.firstactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(/* id = */ R.id.bottomNavigationView)
        bottomNavigationView.background = null

        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId != R.id.home) {
                findViewById<FloatingActionButton>(R.id.fab).hide()
            } else findViewById<FloatingActionButton>(R.id.fab).show()
            changeFragment(it.itemId)
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


