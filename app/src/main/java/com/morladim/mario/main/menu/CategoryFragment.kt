package com.morladim.mario.main.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.base.GridItemDecoration
import com.morladim.mario.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * @Author 5k5k
 * @Date 2021/12/20
 */
@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private val viewModel by viewModels<CategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.addItemDecoration(GridItemDecoration(2,8))

        val menuEvent: MenuEvent = object : MenuEvent {
            override fun onClick(menuItemData: MenuItemData) {
                println(menuItemData.menuEntity.name)
            }
        }

        val adapter = MenuItemListAdapter(menuEvent)
        recyclerView.adapter = adapter

        viewModel.menuList.observe(this, {
            var list = it?.map { it1 -> MenuItemData(it1, MenuConstants.menuMaps[it1.id]!!) }
            list?.let {
                adapter.submitList(list)
            }
        })

    }
}