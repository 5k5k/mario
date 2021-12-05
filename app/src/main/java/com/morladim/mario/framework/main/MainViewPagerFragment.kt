package com.morladim.mario.framework.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.morladim.mario.R
import com.morladim.mario.databinding.FragmentMainViewPagerBinding

/**
 * @Author 5k5k
 * @Date 2021/11/28-7:26
 */
class MainViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainViewPagerBinding.inflate(inflater)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.viewPager.adapter = MainViewPagerAdapter(this)

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.setText(getTabText(position))
        }.attach()

        return binding.root
    }

    fun getTabIcon(position: Int): Int {
        return when (position) {
            CATEGORY_PAGE_INDEX -> R.mipmap.ic_main_category
            INSTANCE_PAGE_INDEX -> R.mipmap.ic_main_instance
            LEETCODE_PAGE_INDEX -> R.mipmap.ic_main_leetcode
            SETTING_PAGE_INDEX -> R.mipmap.ic_main_setting
            else -> throw IndexOutOfBoundsException()
        }
    }

    fun getTabText(position: Int): Int {
        return when (position) {
            CATEGORY_PAGE_INDEX -> R.string.main_category
            INSTANCE_PAGE_INDEX -> R.string.main_instance
            LEETCODE_PAGE_INDEX -> R.string.main_leetcode
            SETTING_PAGE_INDEX -> R.string.main_setting
            else -> throw IndexOutOfBoundsException()
        }
    }
}