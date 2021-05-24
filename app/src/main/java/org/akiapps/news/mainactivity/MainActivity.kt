package org.akiapps.news.mainactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import org.akiapps.news.R
import org.akiapps.news.base.AppBaseActivity
import org.akiapps.news.base.ViewModelFactory
import org.akiapps.news.extensions.showToast
import javax.inject.Inject

class MainActivity : AppBaseActivity<MainViewModel>() {

    private val TAG: String = MainActivity::class.java.simpleName

    /*@Inject
    lateinit var viewModelFactory: ViewModelFactory*/

    //lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =  ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        setContentView(R.layout.activity_main)
        setupBottomNavigationView()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.fetchArticles()
        viewModel.fetchSampleString()
        observeSampleString()
        observeArticles()
    }

    private fun setupBottomNavigationView() {
        bnvMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_selected_country -> {
                    showToast("Hurray Working")
                }
            }

            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun observeSampleString() {
        viewModel.sampleStringLiveData.observe(this, {
            Log.d(TAG, "string is $it")
        })
    }

    private fun observeArticles() {
        viewModel.articlesLiveData.observe(this, {
            it.checkResponse({
                Log.d(TAG, "list is ${it.value.articles.toList().size}")
            }, {
                Log.d(TAG, "error is ${it.errorBody}")
            })
        })
    }


}