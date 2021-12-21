package com.morladim.mario.main.instance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.base.GridItemDecoration
import com.morladim.mario.databinding.FragmentInstanceBinding
import com.morladim.mario.main.menu.CategoryViewModel
import com.morladim.mario.main.menu.MenuItemAdapter
import com.morladim.mario.main.menu.MenuItemViewModel
import com.morladim.mario.main.menu.db.MenuEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@AndroidEntryPoint
class InstanceFragment : Fragment() {

    private val viewModel by viewModels<MenuItemViewModel>()
    private val viewModel1 by viewModels<CategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInstanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.layoutManager = GridLayoutManager(context,3)
        recyclerView.addItemDecoration(GridItemDecoration(3,8))
        progressBar.visibility = View.INVISIBLE

        lifecycleScope.launch {
//            val adapter = MenuItemAdapter(viewModel.getMenuData())
//            recyclerView.adapter = adapter

//            val menuEntity = viewModel.getMenuData().get(0)
            val adapter = MenuItemAdapter(viewModel1)
            recyclerView.adapter = adapter
        }

//        v.observe(this,{
//            if(!b){
//                it[0].name = it[0].name +"111"
//                b = true
//            }
//        })
//         viewModel1.menuList.value!![0].name = viewModel1.menuList.value!![0].name+"11"
    }
}