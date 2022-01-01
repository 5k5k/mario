package com.morladim.mario.sample.github.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.morladim.mario.R
import com.morladim.mario.base.ui.BaseFragment
import com.morladim.mario.sample.github.GitHubViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *
 * @Author 5k5k
 * @Date 2021/12/15
 */
@AndroidEntryPoint
class GitHubFragment : BaseFragment(R.layout.fragment_github) {

    private val viewModel by lazy { ViewModelProvider(this)[GitHubViewModel::class.java] }

    private val repoAdapter = GitHubPagingDataAdapter()

    override fun initView(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter =
            repoAdapter.withLoadStateFooter(GitHubFooterAdapter { repoAdapter.retry() })
        lifecycleScope.launch {
            viewModel.getPagingData().collect { pagingData ->
                repoAdapter.submitData(pagingData)
            }
        }
        repoAdapter.addLoadStateListener {
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
                    ).show()
                }
            }
        }
    }
}