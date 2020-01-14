package com.lintang.jetpackprolintang.content.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.data.source.local.entity.MovieEntity
import com.lintang.jetpackprolintang.base.ui.BaseFragment
import com.lintang.jetpackprolintang.base.vo.Status.*
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : BaseFragment() {
    private lateinit var mViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    companion object {
        val TAG = "DATA_MOVIE"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = obtainViewModel()
        setUpRecylerView()
        mViewModel.getMovies().observe(this, Observer {
            when (it.status) {
                LOADING -> {
                    setupEventView(progress_bar, true)
                }
                SUCCESS -> {
                    setupEventView(progress_bar, false)
                    adapter.submitList(it.data)
                }
                ERROR -> {
                    setupEventView(progress_bar, false)
                    showToast("Terjadi Kesalahan")
                }
            }
        }
        )
    }


    fun setUpRecylerView() {
        adapter = MovieAdapter()
        context?.let { adapter.setLayout(it, R.layout.items_movie) }
        adapter.setListner { data ->
            context?.let {
                baseStartActivity<MovieDetailActivity, MovieEntity?>(it, TAG, data)
            }
        }
        rv_movies.adapter = adapter
        rv_movies.layoutManager = LinearLayoutManager(context)

    }

}