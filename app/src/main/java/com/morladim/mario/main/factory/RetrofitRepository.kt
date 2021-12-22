package com.morladim.mario.main.factory

import com.morladim.mario.sample.github.model.GitHubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitRepository {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GitHubRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LocalRetrofit

    @Provides
    @Singleton
    @GitHubRetrofit
    fun getGitHubRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getGitHubService(@GitHubRetrofit retrofit: Retrofit): GitHubService {
        return retrofit.create(GitHubService::class.java)
    }

}