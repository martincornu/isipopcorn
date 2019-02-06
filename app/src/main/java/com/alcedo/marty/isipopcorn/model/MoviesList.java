package com.alcedo.marty.isipopcorn.model;

import com.alcedo.marty.isipopcorn.MovieShowtime;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MoviesList {
    @SerializedName("moviesList")
    private List<MovieShowtime> moviesList;

    public List<MovieShowtime> getMoviesList() {
        return moviesList;
    }

    public void setMoviesArrayList(List<MovieShowtime> moviesArrayList) {
        this.moviesList = moviesArrayList;
    }
}
