package com.morladim.mario.androiditem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.db.item.AndroidItemEntity
/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
class AndroidItemPagingDataAdapter :
    PagingDataAdapter<AndroidItemEntity, AndroidItemPagingDataAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<AndroidItemEntity>() {
            override fun areItemsTheSame(
                oldItem: AndroidItemEntity,
                newItem: AndroidItemEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: AndroidItemEntity,
                newItem: AndroidItemEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
//        val description: TextView = itemView.findViewById(R.id.description_text)
//        val starCount: TextView = itemView.findViewById(R.id.star_count_text)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.name.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github, parent, false)
        return ViewHolder(view)
    }

}
