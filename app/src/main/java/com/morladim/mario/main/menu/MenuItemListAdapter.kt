package com.morladim.mario.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.main.menu.MenuItemListAdapter.MenuViewHolder

/**
 *
 * @Author fireman
 * @Date 2021/12/21
 */
class MenuItemListAdapter(private val menuEvent: MenuEvent) :
    ListAdapter<MenuItemData, MenuViewHolder>(MenuDiffCallback) {

    class MenuViewHolder(itemView: View, menuEvent: MenuEvent) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.description)
        private val numTextView: TextView = itemView.findViewById(R.id.num)
        private var currentData: MenuItemData? = null

        init {
            itemView.setOnClickListener {
                currentData?.let {
                    menuEvent.onClick(it)
                }
            }
        }

        fun bind(menuData: MenuItemData) {
            currentData = menuData

            nameTextView.text = menuData.menuEntity.name
            descriptionTextView.text = menuData.menuEntity.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_menu, parent, false)
        return MenuViewHolder(view, menuEvent)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object MenuDiffCallback : DiffUtil.ItemCallback<MenuItemData>() {
    override fun areItemsTheSame(oldItem: MenuItemData, newItem: MenuItemData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MenuItemData, newItem: MenuItemData): Boolean {
        return oldItem.menuEntity.id == newItem.menuEntity.id
    }
}