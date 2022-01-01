package com.morladim.mario.androiditem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.morladim.mario.R
import com.morladim.mario.base.ui.BaseBindingFragment
import com.morladim.mario.databinding.FragmentAndroidBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * tab category
 * @Author 5k5k
 * @Date 2021/12/5
 */
@AndroidEntryPoint
class AndroidFragment : BaseBindingFragment<FragmentAndroidBinding>(R.layout.fragment_android) {

    private val viewModel by viewModels<AndroidItemViewModel>()

    private val androidItemAdapter = AndroidItemPagingDataAdapter()

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding!!.viewModel = viewModel
        binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        binding!!.recyclerView.adapter = androidItemAdapter
        lifecycleScope.launch {
            viewModel.getPagingData().collect { pagingData ->
                androidItemAdapter.submitData(pagingData)
            }
        }

        androidItemAdapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    viewModel.loadingViewModel.contentViewVisible = true
                    viewModel.loadingViewModel.loadingViewVisible = false
                }
                is LoadState.Loading -> {
                    viewModel.loadingViewModel.contentViewVisible = false
                    viewModel.loadingViewModel.loadingViewVisible = true
                }
                is LoadState.Error -> {
                    val state = it.refresh as LoadState.Error
                    viewModel.loadingViewModel.loadingViewVisible = false
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