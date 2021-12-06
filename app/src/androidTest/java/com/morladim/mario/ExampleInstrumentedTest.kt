package com.morladim.mario

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.morladim.mario.db.DatabaseRepository
import com.morladim.mario.db.item.AndroidItemEntity
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

    @Test
    fun insertToAndroidItem() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val androidItemDao = DatabaseRepository().getDatabase(appContext, Executors.newSingleThreadExecutor()).userDao()
        val now = Date()
        val item = AndroidItemEntity(0,now,now,"Paging 3","iii",0,false,-1,3f)
        androidItemDao.insertAll(item)
    }
}