package com.example.newsapi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapi.R
import com.example.newsapi.databinding.FragmentNewsBinding
import com.example.newsapi.ui.adapter.NewsAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsFragment : Fragment(R.layout.fragment_news) {

    private val binding by viewBinding(FragmentNewsBinding::bind)
    private val viewModel by viewModel<NewsViewModel>()
    private val newsAdapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.newsRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }
    }

    private fun setupObserve() {

        viewModel.fetchNewsRepository().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                newsAdapter.submitData(it)
            }
        }
    }
}
