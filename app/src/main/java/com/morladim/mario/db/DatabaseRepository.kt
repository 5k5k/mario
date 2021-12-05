package com.morladim.mario.db

import android.content.Context
import androidx.room.Room
import com.morladim.mario.db.item.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Qualifier
import javax.inject.Singleton

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
        ).setQueryExecutor(executor).build()
    }

    @Provides
    @Singleton
    @DbExecutor
    fun dbExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    fun getItemDao(db: AppDatabase): ItemDao {
        return db.userDao()
    }

    @Provides
    @Singleton
    fun otherExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }
}