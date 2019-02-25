
package com.alcedo.marty.isipopcorn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Release implements Serializable {

    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
