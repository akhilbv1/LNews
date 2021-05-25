package org.akiapps.news.country

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.akiapps.news.base.AppBaseFragment
import org.akiapps.news.databinding.FragmentCountriesBinding
import org.akiapps.news.extensions.playLoader
import org.akiapps.news.network.Article

class CountryArticlesListFragment :
    AppBaseFragment<CountriesNewsViewModel, FragmentCountriesBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        binding.lottieLoading.playLoader()
        viewModel.fetchArticles()
    }

    private fun setupArticlesNews(articlesList: ArrayList<Article>) {
        binding.recArticles.animate().alphaBy(1f)
        binding.lottieLoading.animate().alphaBy(0f)
        binding.recArticles.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CountriesListAdapter(articlesList)
        }
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCountriesBinding {
        return FragmentCountriesBinding.inflate(layoutInflater, container, false)
    }

    override fun getClassName(): String {
        return CountryArticlesListFragment::class.java.simpleName
    }

    override fun observeViewModelData() {
        viewModel.articlesLiveData.observe(this, {
            it.checkResponse({
                Log.d(getClassName(), "list is ${it.value.articles.toList().size}")
                setupArticlesNews(it.value.articles)
            }, {
                Log.d(getClassName(), "error is ${it.errorBody}")
            })
        })
    }
}