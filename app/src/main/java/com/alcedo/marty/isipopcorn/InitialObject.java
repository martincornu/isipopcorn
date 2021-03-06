package com.alcedo.marty.isipopcorn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class InitialObject implements Serializable {

    @SerializedName("movieShowtimes")
    @Expose
    private List<MovieShowtime> movieShowtimeList= null;

    public List<MovieShowtime> getMovieShowtimeList() {
        return movieShowtimeList;
    }

    public void setMovieShowtimeList(List<MovieShowtime> movieShowtimeList) {
        this.movieShowtimeList = movieShowtimeList;
    }
}