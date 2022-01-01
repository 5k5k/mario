package com.morladim.mario.androiditem

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.morladim.mario.androiditem.db.AndroidItemDao
import com.morladim.mario.androiditem.db.AndroidItemEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
//@ActivityRetainedScoped
@Singleton
class AndroidItemPagingSource @Inject constructor(private val dao: AndroidItemDao) :
    PagingSource<Int, AndroidItemEntity>() {

    override fun getRefreshKey(state: PagingState<Int, AndroidItemEntity>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AndroidItemEntity> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val offset = (page - 1) * pageSize * 3
            //为了支持协程加入suspend
            val entities = dao.getByPage(pageSize, offset)
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (entities.isNotEmpty()) page + 1 else null
            LoadResult.Page(entities, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}