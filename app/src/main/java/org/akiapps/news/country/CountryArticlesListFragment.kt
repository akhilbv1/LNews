package org.akiapps.news.country

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_countries.*
import org.akiapps.news.R
import org.akiapps.news.base.ViewModelFactory
import javax.inject.Inject

class CountryArticlesListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory:ViewModelFactory

    lateinit var viewModel:CountriesNewsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries,container,false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this,viewModelFactory)[CountriesNewsViewModel::class.java]
    }


    private fun setupArticlesNews(){
        recArticles.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
    }




}