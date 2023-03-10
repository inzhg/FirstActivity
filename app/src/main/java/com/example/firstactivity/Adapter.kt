package com.example.firstactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Home) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var datas = mutableListOf<MenuData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val menu: TextView = itemView.findViewById(R.id.tv_rv_menu)

        fun bind(item: MenuData) {
            menu.text = item.menu

        }
    }
}

data class MenuData (val menu : String)
