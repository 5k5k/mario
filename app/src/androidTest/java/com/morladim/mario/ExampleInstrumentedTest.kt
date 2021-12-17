package com.morladim.mario

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.morladim.mario.db.DatabaseRepository
import com.morladim.mario.db.item.AndroidItemEntity
import com.morladim.mario.db.menu.MenuEntity
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import java.util.concurrent.Executors

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.morladim.mario", appContext.packageName)
    }

    /**
     * 插入android item数据
     */
    @Test
    fun insertToAndroidItem() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val androidItemDao =
            DatabaseRepository().getDatabase(appContext, Executors.newSingleThreadExecutor())
                .userDao()
        val now = Date()
        val item = AndroidItemEntity(0, now, now, "Paging 3", "iii", 0, false, -1, 3f)
        androidItemDao.insertAll(item)
    }


    /**
     * 初始化菜单数据
     */
    @Test
    fun resetMenuInfo() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val executors = Executors.newSingleThreadExecutor()
        val db = DatabaseRepository().getDatabase(appContext, executors)
        db.runInTransaction {
            db.menuDao().deleteAll()
            var current = 1
            val android = MenuEntity(current, "Android", current, true)
            val yang = MenuEntity(++current, "WanAndroid", current, false)
            val kotlin = MenuEntity(++current, "Kotlin", current, false)
            val androidStudio = MenuEntity(++current, "AS", current, false)
            val leetCode = MenuEntity(++current, "LeetCode", current, false)
            val git = MenuEntity(++current, "Git", current, false)
            val shell = MenuEntity(++current, "Shell", current, false)
            val architecture = MenuEntity(++current, "架构", current, false)
            val vi = MenuEntity(++current, "Vi", current, false)
            val sql = MenuEntity(++current, "Sql", current, false)
            val regular = MenuEntity(++current, "正则", current, false)

            db.menuDao().insertAll(
                android,
                yang,
                kotlin,
                androidStudio,
                leetCode,
                git,
                shell,
                architecture,
                vi,
                sql,
                regular
            )
        }

    }
}