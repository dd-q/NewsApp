package com.loc.newsapp.data.remote

import com.loc.newsapp.BuildConfig
import com.loc.newsapp.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApi {

    @GET("blog.json")
    suspend fun getNews(
        @Query("query") search: String,
        @Query("start") page: Int,
        @Header("X-Naver-Client-Id") clientKey: String = BuildConfig.NAVER_CLIENT_ID,
        @Header("X-Naver-Client-Secret") secretKey: String = BuildConfig.NAVER_SECRET_ID
    ) : NewsResponse
}