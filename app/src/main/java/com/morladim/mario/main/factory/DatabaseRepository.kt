package com.morladim.mario.main.factory

import android.content.Context
import androidx.room.Room
//import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.morladim.mario.androiditem.db.AndroidItemDao
import com.morladim.mario.main.db.AppDatabase
import com.morladim.mario.main.menu.db.MenuDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
// TODO: 2021/12/2 okhttp4
@Module
@InstallIn(SingletonComponent::class)
class DatabaseRepository {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DbExecutor

    @Provides
    @Singleton
    fun getDatabase(
        @ApplicationContext context: Context,
        @DbExecutor executor: Executor
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "mario.db"
        )
            .createFromAsset("db/v1.db")
//            .addMigrations(MIGRATION_1_2)
            .setQueryExecutor(executor).build()
    }

//    val MIGRATION_1_2 = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL(
//                "CREATE TABLE `menu` (`id` INTEGER not null , `name` TEXT not null, `sort` INTEGER TEXT not null, `first` INTEGER TEXT not null, " +
//                        "PRIMARY KEY(`id`))"
//            )
//        }
//    }

    @Provides
    @Singleton
    @DbExecutor
    fun dbExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    fun getItemDao(db: AppDatabase): AndroidItemDao {
        return db.userDao()
    }

    @Provides
    @Singleton
    fun getMenuDao(db: AppDatabase): MenuDao {
        return db.menuDao()
    }

    @Provides
    @Singleton
    fun otherExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }
}