package com.lintang.jetpackprolintang.content.ui.series


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.model.SeriesModel
import com.lintang.jetpackprolintang.base.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_series.*


class SeriesFragment : BaseFragment() {

    private lateinit var mViewModel: SeriesViewModel

    private lateinit var adapter: SeriesAdapter

    companion object {
        val TAG = "SERIES_ID"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_series, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = obtainViewModel()
        setUpRecylerView()
        setupEventView(progress_bar, true)
        mViewModel.getSerieses().observe(this, Observer {
            setupEventView(progress_bar, false)
            if (it != null) {
                adapter.setData(it)
            } else {
                showToast("Terjadi Kesalahan")
            }
        })
    }


    fun setUpRecylerView() {
        adapter = SeriesAdapter()
        context?.let { adapter.setLayout(it, R.layout.items_movie) }
        adapter.setListner({ data ->
            context?.let {
                baseStartActivity<SeriesDetailActivity, SeriesModel>(it, TAG, data)
            }
        })
        rv_serieses.adapter = adapter
        rv_serieses.layoutManager = LinearLayoutManager(context)


    }


}
