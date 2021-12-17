package com.morladim.mario.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.db.menu.MenuEntity
/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
class MenuItemAdapter(private val list: List<MenuEntity>) :
    RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
//        val description: TextView = itemView.findViewById(R.id.description_text)
//        val starCount: TextView = itemView.findViewById(R.id.star_count_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}