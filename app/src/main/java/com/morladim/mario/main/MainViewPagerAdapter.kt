package com.morladim.mario.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.morladim.mario.kotlin.KotlinFragment
import com.morladim.mario.main.instance.InstanceFragment
import com.morladim.mario.main.menu.CategoryFragment
import com.morladim.mario.main.setting.SettingFragment
import com.morladim.mario.sample.github.ui.GitHubFragment
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

const val FIRST_PAGE_INDEX = 0
const val ITEMS_PAGE_INDEX = 1
const val SAMPLE_PAGE_INDEX = 2
const val SETTING_PAGE_INDEX = 3

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
class MainViewPagerAdapter(fragment: Fragment, clazz: KClass<out Fragment>) :
    FragmentStateAdapter(fragment) {

    private val fragments: MutableMap<Int, () -> Fragment> by lazy {
        mutableMapOf(
//            FIRST_PAGE_INDEX to { AndroidFragment() },
            ITEMS_PAGE_INDEX to { CategoryFragment() },
            SAMPLE_PAGE_INDEX to { GitHubFragment() },
//            SAMPLE_PAGE_INDEX to { SettingFragment() },
            SETTING_PAGE_INDEX to { KotlinFragment() }
        )
    }

    init {
        changeFirstFragment(clazz)
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    fun changeFirstFragment(clazz: KClass<out Fragment>) {
        fragments[FIRST_PAGE_INDEX] = { clazz.createInstance() }
        notifyItemChanged(FIRST_PAGE_INDEX)
    }
}