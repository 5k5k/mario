package com.morladim.mario.framework.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.morladim.mario.framework.KotlinFragment
import com.morladim.mario.framework.android.AndroidFragment
import com.morladim.mario.framework.instance.InstanceFragment
import com.morladim.mario.framework.leetcode.LeetCodeFragment
import com.morladim.mario.framework.setting.SettingFragment

const val ANDROID_PAGE_INDEX = 0
const val KOTLIN_PAGE_INDEX = 1
const val INSTANCE_PAGE_INDEX = 2
const val LEETCODE_PAGE_INDEX = 3
const val SETTING_PAGE_INDEX = 4

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        ANDROID_PAGE_INDEX to { AndroidFragment() },
        KOTLIN_PAGE_INDEX to { KotlinFragment() },
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