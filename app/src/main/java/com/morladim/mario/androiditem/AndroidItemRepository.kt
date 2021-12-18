package com.morladim.mario.androiditem

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.morladim.mario.androiditem.db.AndroidItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
class AndroidItemRepository @Inject constructor(private val pagingSource: AndroidItemPagingSource) {

    fun getPagingData(): Flow<PagingData<AndroidItemEntity>> {
        return Pager(
            config = PagingConfig(1),
            pagingSourceFactory = { pagingSource }
        ).flow
    }
}