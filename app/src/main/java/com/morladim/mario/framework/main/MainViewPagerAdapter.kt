package com.morladim.mario.framework.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.morladim.mario.framework.category.CategoryFragment
import com.morladim.mario.framework.instance.InstanceFragment
import com.morladim.mario.framework.leetcode.LeetCodeFragment
import com.morladim.mario.framework.setting.SettingFragment

const val CATEGORY_PAGE_INDEX = 0
const val INSTANCE_PAGE_INDEX = 1
const val LEETCODE_PAGE_INDEX = 2
const val SETTING_PAGE_INDEX = 3

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5-9:23
 */
class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        CATEGORY_PAGE_INDEX to { CategoryFragment() },
        INSTANCE_PAGE_INDEX to { InstanceFragment() },
        LEETCODE_PAGE_INDEX to { LeetCodeFragment() },
        SETTING_PAGE_INDEX to { SettingFragment() }
    )

    override fun getItemCount(): Int {
        return fragmentsCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}