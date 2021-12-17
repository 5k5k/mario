package com.morladim.mario.sample.github

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.morladim.mario.network.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PAGE_SIZE = 10

/**
 *
 * @Author 5k5k
 * @Date 2021/12/16
 */
class RepoRepository @Inject constructor() {

    fun getPagingData(): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE, initialLoadSize = 20),
            pagingSourceFactory = { GitHubPagingSource() }
        ).flow
    }

}