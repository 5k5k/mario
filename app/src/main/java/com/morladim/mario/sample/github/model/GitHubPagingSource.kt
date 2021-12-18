package com.morladim.mario.sample.github.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.morladim.mario.main.factory.RetrofitRepository

/**
 *
 * @Author 5k5k
 * @Date 2021/12/16
 */
class GitHubPagingSource : PagingSource<Int, Repo>() {

//    @Inject
//    lateinit var gitHubService: GitHubService

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        return try {
            val page = params.key ?: 1 // set page 1 as default
            val pageSize = params.loadSize
            val repoResponse = RetrofitRepository().getGitHubService(RetrofitRepository().getGitHubRetrofit())
            .searchRepos(page, pageSize)
            val repoItems = repoResponse.items
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}