package com.morladim.mario.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.morladim.mario.R
import com.morladim.mario.databinding.FragmentMainViewPagerBinding
import com.morladim.mario.main.menu.MenuInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.full.createInstance

/**
 * 主页Fragment
 * @Author 5k5k
 * @Date 2021/11/28
 */
@AndroidEntryPoint
class MainViewPagerFragment : Fragment() {

    private val mainViewModel by viewModels<MainFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainViewPagerBinding.inflate(inflater)
        initMenu(binding.tabs.menu)

        //第一个标签数据改变后更新UI
        val menuInfoObserver = Observer<MenuInfo> { menuInfo ->
            if (binding.viewPager.adapter == null) {
                binding.tabs.menu.add(0, 0, 0, menuInfo.titleId)
                binding.tabs.menu.findItem(0).setIcon(menuInfo.iconId)
                binding.viewPager.adapter =
                    MainViewPagerAdapter(this@MainViewPagerFragment, menuInfo)

                NavigationViewMediator(binding.tabs, binding.viewPager) { tab, viewPager2 ->
//                        viewPager2.isUserInputEnabled = false
                    //去掉长按toast
                    (tab.getChildAt(0) as? ViewGroup)?.children?.forEach { it.setOnLongClickListener { true } }
                }.attach()
            } else {
                binding.tabs.menu.findItem(0).setTitle(menuInfo.titleId)
                binding.tabs.menu.findItem(0).setIcon(menuInfo.iconId)
                val map = (binding.viewPager.adapter as MainViewPagerAdapter).fragments!!
                map[FIRST_PAGE_INDEX] = { menuInfo.clazz.createInstance() }
                binding.viewPager.adapter!!.notifyItemChanged(FIRST_PAGE_INDEX)
            }
        }
        mainViewModel.menuInfo.observe(this@MainViewPagerFragment, menuInfoObserver)

        return binding.root
    }

    private fun initMenu(menu: Menu) {
        menu.add(0, 1, 1, R.string.main_android)
        menu.findItem(1).setIcon(R.mipmap.ic_main_instance)

        menu.add(0, 2, 2, R.string.main_instance)
        menu.findItem(2).setIcon(R.mipmap.ic_main_instance)

        menu.add(0, 3, 3, R.string.main_setting)
        menu.findItem(3).setIcon(R.mipmap.ic_main_setting)
    }

}