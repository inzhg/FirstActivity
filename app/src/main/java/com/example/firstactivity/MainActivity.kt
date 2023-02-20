package com.example.firstactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var MenuAdapter: Adapter
    private val datas = mutableListOf<MenuData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(/* id = */ R.id.bottomNavigationView)
        bottomNavigationView.background = null

        bottomNavigationView.setOnItemSelectedListener {
            changeFragment(it.itemId)
            true
        }

        changeFragment(R.id.home)
    }



    private fun changeFragment(menuItemId: Int) {
        val ft = supportFragmentManager.beginTransaction()

        when (menuItemId) {
            R.id.home -> {
                ft.replace(R.id.main_frame, Home()).commitAllowingStateLoss()
//                initRecycler() #이부분이 오류
            }
            R.id.Profile -> ft.replace(R.id.main_frame, Person()).commitAllowingStateLoss()
            R.id.Search -> ft.replace(R.id.main_frame, Search()).commitAllowingStateLoss()
            R.id.Settings -> ft.replace(R.id.main_frame, Settings()).commitAllowingStateLoss()
        }
    }

    private fun initRecycler() {

        MenuAdapter = Adapter(Home) // 원래 Home대신 this가 들어가는데 오류가 나서 바꿈
        findViewById<RecyclerView>(R.id.rv_item).adapter = MenuAdapter

        datas.apply {
            add(MenuData( menu = "mary",))
            add(MenuData( menu = "hi",))
            add(MenuData( menu = "hello",))

            MenuAdapter.datas = datas
            MenuAdapter.notifyDataSetChanged()
        }
    }
}