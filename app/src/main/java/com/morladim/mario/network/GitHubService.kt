package com.morladim.mario.network

import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    /**
     * Get repos ordered by stars.
     */
    @GET("search/repositories?sort=stars&q=Android")
    suspend fun searchRepos(
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse

}