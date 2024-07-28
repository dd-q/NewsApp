package com.loc.newsapp.data.remote.dto

import com.loc.newsapp.domain.model.Article

data class NewsResponse(
    val display: Int,
    val items: List<Article>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)