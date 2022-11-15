package com.example.newsapi.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.newsapi.data.repository.NewsRepository
import com.example.newsapi.model.NewsModel

class NewsViewModel(
    private val repository: NewsRepository
): ViewModel() {

    fun fetchNewsRepository(): LiveData<PagingData<NewsModel>> {
        return repository.fetchNew().cachedIn(viewModelScope)
    }
}