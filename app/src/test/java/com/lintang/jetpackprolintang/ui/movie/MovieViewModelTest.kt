@file:Suppress("DEPRECATION")

package com.lintang.jetpackprolintang.ui.movie

import com.lintang.jetpackprolintang.data.Movie
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    lateinit var movieViewModel: MovieViewModel
    lateinit var dummy: Movie

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
        dummy = Movie(
            "419704", "Ad Astra", 6.0, "2019-09-17",
            "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg", "/p3TCqUDoVsrIm8fHK9KOTfWnDjZ.jpg",
            "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown."
        )
    }


    @Test
    fun getMovies() {
        val movies = movieViewModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @After
    @Test
    fun findMovie() {
        val movie = movieViewModel.findMovie(dummy.id)
        assertNotNull(movie)
        assertEquals(dummy.id, movie?.id)
        assertEquals(dummy.overview, movie?.overview)
        assertEquals(dummy.title, movie?.title)
        assertEquals(dummy.backgroundPath, movie?.backgroundPath)
        assertEquals(dummy.posterPath, movie?.posterPath)
        Assert.assertEquals(dummy.voteAverage, movie?.voteAverage)

    }
}