package com.lintang.jetpackprolintang.ui.series


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.ui.BaseFragment
import com.lintang.jetpackprolintang.data.Series
import kotlinx.android.synthetic.main.fragment_series.*

/**
 * A simple [Fragment] subclass.
 */
class SeriesFragment : BaseFragment() {

    private lateinit var mViewModel: SeriesViewModel
    private lateinit var serieses: List<Series>
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
        mViewModel = ViewModelProviders.of(this).get(SeriesViewModel::class.java)
        serieses = mViewModel.getSerieses()
        setUpRecylerView()
    }


    fun setUpRecylerView() {
        adapter = SeriesAdapter()
        context?.let { adapter.setLayout(it, R.layout.items_movie) }

        adapter.setData(serieses)
        adapter.setListner({ data ->
            context?.let {
                baseStartActivity<SeriesDetailActivity, String>(it, TAG, data.id ?: "0")
            }
        })
        rv_serieses.adapter = adapter
        rv_serieses.layoutManager = LinearLayoutManager(context)


    }


}
