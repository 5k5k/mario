package com.morladim.mario.main.instance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.databinding.FragmentInstanceBinding
import com.morladim.mario.main.menu.MenuItemAdapter
import com.morladim.mario.main.menu.MenuItemViewModel
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
        recyclerView.layoutManager = LinearLayoutManager(context)
        progressBar.visibility = View.INVISIBLE

        lifecycleScope.launch {
            val adapter = MenuItemAdapter(viewModel.getMenuData())
            recyclerView.adapter = adapter
        }

    }
}