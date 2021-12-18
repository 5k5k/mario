package com.morladim.mario.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.morladim.mario.androiditem.AndroidFragment
import com.morladim.mario.kotlin.KotlinFragment
import com.morladim.mario.main.instance.InstanceFragment
import com.morladim.mario.main.menu.MenuInfo
import com.morladim.mario.main.setting.SettingFragment
import dagger.hilt.android.scopes.ActivityScoped
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
@ActivityScoped
class MainViewPagerAdapter(fragment: Fragment, private val menuEntity: MenuInfo) :
    FragmentStateAdapter(fragment) {

//    var fragments: Map<Int, () -> Fragment>? = null
    var fragments: MutableMap<Int, () -> Fragment>? =     mutableMapOf(
    FIRST_PAGE_INDEX to { AndroidFragment() },
    ITEMS_PAGE_INDEX to { KotlinFragment() },
    SAMPLE_PAGE_INDEX to { InstanceFragment() },
    SETTING_PAGE_INDEX to { SettingFragment() }
)

    private fun fragmentsCreator(): Map<Int, () -> Fragment> {
        if (fragments != null) {
            return fragments!!
        }
        val clazz = menuEntity.clazz
//        val entryPoint = EntryPointAccessors.fromFragment(fragment, FragmentEntryPoint::class.java)
//        val menuDatabaseRepository = entryPoint.getMenuDatabaseRepository()

//        fragments = mapOf(
//            FIRST_PAGE_INDEX to { clazz.createInstance() as Fragment },
//            ITEMS_PAGE_INDEX to { KotlinFragment() },
//            SAMPLE_PAGE_INDEX to { InstanceFragment() },
//            SETTING_PAGE_INDEX to { SettingFragment() }
//        )
        fragments = mutableMapOf(
            FIRST_PAGE_INDEX to { clazz.createInstance() },
            ITEMS_PAGE_INDEX to { KotlinFragment() },
            SAMPLE_PAGE_INDEX to { InstanceFragment() },
            SETTING_PAGE_INDEX to { SettingFragment() }
        )
        return fragments!!
    }

    override fun getItemCount(): Int {
        return fragments!!.size
//        return fragmentsCreator().size
    }

    override fun createFragment(position: Int): Fragment {
        println(position)
        return fragments!![position]?.invoke() ?: throw IndexOutOfBoundsException()
//        return fragmentsCreator()[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}