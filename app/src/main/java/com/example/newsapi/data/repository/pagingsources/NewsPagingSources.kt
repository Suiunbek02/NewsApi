package com.example.newsapi.data.repository.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapi.data.network.apiservice.NewsApi
import com.example.newsapi.model.NewsModel
import retrofit2.HttpException
import java.io.IOException

class NewsPagingSources(
    private val newsApi: NewsApi
) : PagingSource<Int, NewsModel>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, NewsModel> {
        val position = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(1000)

        return try {
            val response = newsApi.fetchNews("apple", position)
            val nextPage = response.totalResults
            val nextPageNumber =
                if (nextPage > pageSize) position + 1
                else null
            PagingSource.LoadResult.Page(
                data = response.articles,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (exception: IOException) {
            return PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return PagingSource.LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}