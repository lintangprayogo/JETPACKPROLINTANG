package com.lintang.jetpackprolintang.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.lintang.jetpackprolintang.R
import com.lintang.jetpackprolintang.base.ui.BaseFragment
import com.lintang.jetpackprolintang.data.Movie
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : BaseFragment() {
    private lateinit var mViewModel: MovieViewModel
    private lateinit var movies: List<Movie>
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
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movies = mViewModel.getMovies()
        setUpRecylerView()
    }


    fun setUpRecylerView() {
        adapter = MovieAdapter()
        context?.let { adapter.setLayout(it, R.layout.items_movie) }
        adapter.setData(movies)
        adapter.setListner { data ->
            context?.let {
                baseStartActivity<MovieDetailActivity, String>(it, TAG, data.id ?: "0")
            }
        }
        rv_movies.adapter = adapter
        rv_movies.layoutManager = LinearLayoutManager(context)


    }

}