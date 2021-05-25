package org.akiapps.news.mainactivity

import android.os.Bundle
import org.akiapps.news.R
import org.akiapps.news.base.AppBaseActivity
import org.akiapps.news.country.CountryArticlesListFragment
import org.akiapps.news.databinding.ActivityMainBinding

class MainActivity : AppBaseActivity<MainViewModel,ActivityMainBinding>() {

    private val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        binding.bnvMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_selected_country -> {
                    supportFragmentManager.beginTransaction().also {
                        it.replace(R.id.container,CountryArticlesListFragment(),"Countries_List")
                        it.commitNow()
                    }
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        binding.bnvMenu.selectedItemId = R.id.action_selected_country
    }


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


}