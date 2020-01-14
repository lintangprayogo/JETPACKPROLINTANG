package com.lintang.jetpackprolintang.content.ui.favorite

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import com.lintang.jetpackprolintang.content.ui.ContentPager
import com.lintang.jetpackprolintang.content.ui.movie.FavoriteMovieFragment
import com.lintang.jetpackprolintang.content.ui.series.FavoriteSeriesFragment
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        supportActionBar?.title = getString(R.string.favorite)
        setUpPager()
    }

    private fun setUpPager() {

        val adapter = ContentPager(
            supportFragmentManager,
            lifecycle,
            listOf(
                FavoriteMovieFragment(),
                FavoriteSeriesFragment()
            ),
            listOf("Movie", "Series")
        )
        pager.adapter = adapter
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

    }
}
