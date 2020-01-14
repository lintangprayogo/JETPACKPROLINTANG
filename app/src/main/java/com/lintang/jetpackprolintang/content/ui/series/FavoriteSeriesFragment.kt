package com.lintang.jetpackprolintang.content.ui.series


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.source.local.entity.SeriesEntity
import com.lintang.jetpackprolintang.base.ui.BaseFragment
import com.lintang.jetpackprolintang.base.vo.Status
import kotlinx.android.synthetic.main.fragment_favorite_series.*


/**
 * A simple [Fragment] subclass.
 */
class FavoriteSeriesFragment : BaseFragment() {
    private lateinit var mViewModel: SeriesViewModel
    private lateinit var adapter: SeriesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_series, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = obtainViewModel()
        setUpRecylerView()
        mViewModel.getSeriesesFavorite().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    setupEventView(progress_bar, true)
                }
                Status.SUCCESS -> {
                    setupEventView(progress_bar, false)
                    setupEventView(empty_series, it.data.isNullOrEmpty())
                    adapter.submitList(it.data)
                }
                Status.ERROR -> {
                    setupEventView(progress_bar, false)
                    showToast("Terjadi Kesalahan")
                }
            }
        })
    }


    fun setUpRecylerView() {
        adapter = SeriesAdapter()
        context?.let { adapter.setLayout(it, R.layout.items_movie) }
        adapter.setListner({ data ->
            context?.let {
                baseStartActivity<SeriesDetailActivity, SeriesEntity?>(it, SeriesFragment.TAG, data)
            }
        })
        rv_serieses.adapter = adapter
        rv_serieses.layoutManager = LinearLayoutManager(context)
    }
}