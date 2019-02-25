
package com.alcedo.marty.isipopcorn;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example implements Serializable {

    @SerializedName("movieShowtimes")
    @Expose
    private List<MovieShowtime> movieShowtimes = null;

    public List<MovieShowtime> getMovieShowtimes() {
        return movieShowtimes;
    }

    public void setMovieShowtimes(List<MovieShowtime> movieShowtimes) {
        this.movieShowtimes = movieShowtimes;
    }

}
