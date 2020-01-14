package com.lintang.jetpackprolintang.content.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lintang.jetpackprolintang.base.ui.BaseFragment


class ContentPager(
    fm: FragmentManager, lifecycle: Lifecycle, val fragments: List<BaseFragment>, val
    tabTitles: List<String>
) : FragmentStateAdapter(fm, lifecycle) {


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getPageTitle(pos: Int): String {
        return tabTitles[pos]
    }


}