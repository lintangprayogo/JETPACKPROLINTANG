package com.lintang.jetpackprolintang.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.ui.BaseActivity
import com.lintang.jetpackprolintang.ui.movie.MovieFragment
import com.lintang.jetpackprolintang.ui.series.SeriesFragment
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
}
