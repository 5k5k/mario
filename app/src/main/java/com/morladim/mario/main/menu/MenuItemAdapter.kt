package com.morladim.mario.main.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.databinding.ItemCategoryMenuBinding

/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
class MenuItemAdapter(private val viewModel: CategoryViewModel) :
    RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemCategoryMenuBinding) : RecyclerView.ViewHolder(binding.root) {
//        val name: TextView = itemView.findViewById(R.id.name)
//        val description: TextView = itemView.findViewById(R.id.description_text)
//        val starCount: TextView = itemView.findViewById(R.id.star_count_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.name.text = list[position].name
//        holder.bind(itemViewModels[position])
    }

    override fun getItemCount(): Int {
        return 1
    }
}