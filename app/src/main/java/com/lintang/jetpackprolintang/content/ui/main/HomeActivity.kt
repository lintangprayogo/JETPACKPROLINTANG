package com.lintang.jetpackprolintang.content.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.tabs.TabLayoutMediator
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import com.lintang.jetpackprolintang.content.ui.ContentPager
import com.lintang.jetpackprolintang.content.ui.favorite.FavoriteActivity
import com.lintang.jetpackprolintang.content.ui.movie.MovieFragment
import com.lintang.jetpackprolintang.content.ui.series.SeriesFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpPager()
    }


    private fun setUpPager() {

        val adapter = ContentPager(
            supportFragmentManager, lifecycle, listOf(MovieFragment(), SeriesFragment()),
            listOf("Movie", "Series")
        )
        pager.adapter = adapter
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite_menu) {
            baseStartActivity<FavoriteActivity>(this)
        }
        return super.onOptionsItemSelected(item)
    }
}
