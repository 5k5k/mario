package com.morladim.mario.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.morladim.mario.R
import com.morladim.mario.androiditem.AndroidFragment
import com.morladim.mario.databinding.FragmentMainViewPagerBinding
import com.morladim.mario.main.menu.MenuConstants
import com.morladim.mario.main.menu.db.MenuEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.reflect.full.createInstance

/**
 * @Author 5k5k
 * @Date 2021/11/28
 */
@AndroidEntryPoint
class MainViewPagerFragment : Fragment() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainViewPagerBinding.inflate(inflater)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        lifecycleScope.launch {
//            val menuEntity = mainViewModel.getFirstMenu()
//            val menuInfo = MenuConstants.menuMaps[menuEntity.id]!!
//            binding.viewPager.adapter = MainViewPagerAdapter(this@MainViewPagerFragment, menuInfo)
//
//            TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
//                tab.setIcon(getTabIcon(position))
//                tab.setText(getTabText(position))
//            }.attach()

            val live = mainViewModel.getFirstMenu()

            val nameObserver = Observer<MenuEntity> { menuEntity ->
                val menuInfo = MenuConstants.menuMaps[menuEntity.id]!!

                if (binding.viewPager.adapter == null) {
                    binding.viewPager.adapter =
                        MainViewPagerAdapter(this@MainViewPagerFragment, menuInfo)

                    TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
                        tab.setIcon(getTabIcon(position))
                        tab.setText(getTabText(position))
                    }.attach()
                } else {
                    val clazz = menuInfo.clazz
                    val a = ( binding.viewPager.adapter as MainViewPagerAdapter).fragments!!
                    a[FIRST_PAGE_INDEX] = {clazz.createInstance() }
                    if(clazz == AndroidFragment::class){
                        l.set(R.mipmap.ic_main_category)
                    }else{
                        l.set(R.mipmap.ic_main_setting)
                    }

                    binding.viewPager.adapter!!.notifyItemChanged(FIRST_PAGE_INDEX)
//                    TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
//                        tab.setIcon(getTabIcon(position))
//                        tab.setText(getTabText(position))
//                    }.attach()
                }
            }

            live.observe(this@MainViewPagerFragment, nameObserver)

        }

        return binding.root
    }

    fun tt():Fragment{
        return AndroidFragment()
    }

    val l = ObservableField<Int>(R.mipmap.ic_main_category)

    fun getTabIcon(position: Int): Int {
        return when (position) {
            FIRST_PAGE_INDEX -> l.get()!!
            ITEMS_PAGE_INDEX -> R.mipmap.ic_main_category
            SAMPLE_PAGE_INDEX -> R.mipmap.ic_main_instance
//            LEETCODE_PAGE_INDEX -> R.mipmap.ic_main_leetcode
            SETTING_PAGE_INDEX -> R.mipmap.ic_main_setting
            else -> throw IndexOutOfBoundsException()
        }
    }

    fun getTabText(position: Int): Int {
        return when (position) {
            FIRST_PAGE_INDEX -> R.string.main_android
            ITEMS_PAGE_INDEX -> R.string.main_android
            SAMPLE_PAGE_INDEX -> R.string.main_instance
//            LEETCODE_PAGE_INDEX -> R.string.main_leetcode
            SETTING_PAGE_INDEX -> R.string.main_setting
            else -> throw IndexOutOfBoundsException()
        }
    }
}