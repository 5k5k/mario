package com.morladim.mario.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.morladim.mario.R
import com.morladim.mario.base.ui.BaseFragment
import com.morladim.mario.main.menu.MenuInfo
import dagger.hilt.android.AndroidEntryPoint

/**
 * 主页Fragment
 * 这里关于menu的item id，是与R中其他id类似全局唯一，所以最好还是在xml中声明
 *
 * @Author 5k5k
 * @Date 2021/11/28
 */
@AndroidEntryPoint
class MainViewPagerFragment : BaseFragment(R.layout.fragment_main_view_pager) {

    private val mainViewModel by viewModels<MainFragmentViewModel>()

    override fun initView(view: View, savedInstanceState: Bundle?) {
        val tabs = view.findViewById<BottomNavigationView>(R.id.tabs)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        //第一个标签数据改变后更新UI
        val menuInfoObserver = Observer<MenuInfo> { menuInfo ->
            tabs.menu.findItem(R.id.custom_item).setTitle(menuInfo.titleId).setIcon(menuInfo.iconId)
            if (viewPager.adapter == null) {
                viewPager.adapter =
                    MainViewPagerAdapter(this@MainViewPagerFragment, menuInfo.clazz)

                NavigationViewMediator(tabs, viewPager) { tab, viewPager2 ->
                    //先写着以后调整
                    viewPager2.isSaveEnabled = false
//                        viewPager2.isUserInputEnabled = false
                    //去掉长按toast
                    (tab.getChildAt(0) as? ViewGroup)?.children?.forEach { it.setOnLongClickListener { true } }
                }.attach()
            } else {
                (viewPager.adapter as MainViewPagerAdapter).changeFirstFragment(menuInfo.clazz)
            }
        }
        mainViewModel.menuInfo.observe(this@MainViewPagerFragment, menuInfoObserver)
    }
}