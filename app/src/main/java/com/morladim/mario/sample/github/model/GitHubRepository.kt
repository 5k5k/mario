package com.morladim.mario.sample.github.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


/**
 *
 * @Author 5k5k
 * @Date 2021/12/16
 */
@Singleton
class GitHubRepository @Inject constructor() {

    fun getPagingData(): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(1, initialLoadSize = 2),
            pagingSourceFactory = { GitHubPagingSource() }
        ).flow
    }

}

//private const val PAGE_SIZE = 10
