package com.example.newsapi.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.newsapi.data.network.apiservice.NewsApi
import com.example.newsapi.data.repository.pagingsources.NewsPagingSources
import com.example.newsapi.model.NewsModel

class NewsRepository(
    private val newsApi: NewsApi
) {

    fun fetchNew(): LiveData<PagingData<NewsModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                NewsPagingSources(newsApi)
            }, initialKey = 1
        ).liveData
    }
}