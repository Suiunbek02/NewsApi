package com.example.newsapi.servcelocator

import com.example.newsapi.data.repository.NewsRepository
import com.example.newsapi.ui.fragment.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    factory {
        NewsRepository(get())
    }

    viewModel {
        NewsViewModel(get())
    }
}