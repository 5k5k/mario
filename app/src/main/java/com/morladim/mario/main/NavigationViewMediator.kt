package com.morladim.mario.main

import android.view.MenuItem
import androidx.core.view.forEachIndexed
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 *
 * @Author 5k5k
 * @Date 2021/12/18
 */
class NavigationViewMediator(
    val bottomNavigationView: BottomNavigationView,
    val viewPager2: ViewPager2,
    private val config: ((BottomNavigationView,ViewPager2) -> Unit)? = null
) {

    val map = mutableMapOf<MenuItem, Int>()

    init {
        //建立MenuItem的索引id映射
        bottomNavigationView.menu.forEachIndexed { index, item ->
            map[item] = index
        }
    }

    fun attach() {
        //由于config是可空类型 所以必须用invoke执行
        config?.invoke(bottomNavigationView,viewPager2)
        //监听viewPager的页面改变
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //通过position参数 设置BottomNavigationView选中的Item
                bottomNavigationView.selectedItemId = bottomNavigationView.menu.getItem(position).itemId
            }
        })

        //监听BottomNavigationView的item点击
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
//            viewPager2.currentItem =
//                map[menuItem] ?: error("BottomNavigationView的Item${menuItem.itemId}没有对应的元素")
            viewPager2.setCurrentItem(map[menuItem]!!, true)
//            viewPager2.item
            true
        }
    }
}