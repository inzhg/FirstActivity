package com.example.firstactivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {
    private lateinit var MenuAdapter: Adapter
    private val datas = mutableListOf<MenuData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item : RecyclerView = view.findViewById(R.id.rv_item)
        initRecycler(item)
    }



    @SuppressLint("NotifyDataSetChanged")
    private fun initRecycler(item : RecyclerView) {

        MenuAdapter = Adapter(this)
        item.adapter = MenuAdapter

        datas.apply {
            add(MenuData( menu = "mary",))
            add(MenuData( menu = "hi",))
            add(MenuData( menu = "hello",))

            MenuAdapter.datas = datas
            MenuAdapter.notifyDataSetChanged()
        }
    }



}