package com.morladim.mario.androiditem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.androiditem.AndroidItemPagingDataAdapter
import com.morladim.mario.androiditem.AndroidItemViewModel
import com.morladim.mario.databinding.FragmentAndroidBinding
import com.morladim.mario.main.menu.MenuConstants
import com.morladim.mario.sample.github.ui.GitHubPagingDataAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * tab category
 * @Author 5k5k
 * @Date 2021/12/5
 */
@AndroidEntryPoint
class AndroidFragment : Fragment() {

    private val viewModel by viewModels<AndroidItemViewModel>()

    private val repoAdapter = GitHubPagingDataAdapter()

    private val androidItemAdapter = AndroidItemPagingDataAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAndroidBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter =androidItemAdapter
        lifecycleScope.launch {
            viewModel.getPagingData().collect { pagingData ->
                androidItemAdapter.submitData(pagingData)
            }
        }
        androidItemAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    progressBar.visibility = View.INVISIBLE
                    recyclerView.visibility = View.VISIBLE
                }
                is LoadState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.INVISIBLE
                }
                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        context,
                        "Load Error: ${state.error.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
    }
}