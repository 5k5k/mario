package com.morladim.mario.main

import android.view.MenuItem
import androidx.core.view.forEachIndexed
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * 绑定bottomNavigationView和viewpager
 * @Author 5k5k
 * @Date 2021/12/18
 */
class NavigationViewMediator(
    val bottomNavigationView: BottomNavigationView,
    val viewPager2: ViewPager2,
    private val config: ((BottomNavigationView, ViewPager2) -> Unit)? = null
) {

    private val map = mutableMapOf<MenuItem, Int>()

    init {
        bottomNavigationView.menu.forEachIndexed { index, item ->
            map[item] = index
        }
    }

    fun attach() {
        config?.invoke(bottomNavigationView, viewPager2)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigationView.selectedItemId =
                    bottomNavigationView.menu.getItem(position).itemId
            }
        })

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            viewPager2.setCurrentItem(map[menuItem]!!, true)
            true
        }
    }
}