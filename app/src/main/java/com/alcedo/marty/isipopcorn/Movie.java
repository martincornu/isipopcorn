
package com.alcedo.marty.isipopcorn;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie implements Serializable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("castingShort")
    @Expose
    private CastingShort castingShort;
    @SerializedName("release")
    @Expose
    private Release release;
    @SerializedName("runtime")
    @Expose
    private Integer runtime;
    @SerializedName("genre")
    @Expose
    private List<Genre> genre = null;
    @SerializedName("poster")
    @Expose
    private Poster poster;
    @SerializedName("trailer")
    @Expose
    private Trailer trailer;
    @SerializedName("trailerEmbed")
    @Expose
    private String trailerEmbed;
    @SerializedName("link")
    @Expose
    private List<Link> link = null;
    @SerializedName("statistics")
    @Expose
    private Statistics statistics;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CastingShort getCastingShort() {
        return castingShort;
    }

    public void setCastingShort(CastingShort castingShort) {
        this.castingShort = castingShort;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public String getTrailerEmbed() {
        return trailerEmbed;
    }

    public void setTrailerEmbed(String trailerEmbed) {
        this.trailerEmbed = trailerEmbed;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

}
