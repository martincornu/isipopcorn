
package com.alcedo.marty.isipopcorn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Statistics implements Serializable {

    @SerializedName("pressRating")
    @Expose
    private Double pressRating;
    @SerializedName("pressReviewCount")
    @Expose
    private Integer pressReviewCount;
    @SerializedName("userRating")
    @Expose
    private Double userRating;
    @SerializedName("userReviewCount")
    @Expose
    private Integer userReviewCount;
    @SerializedName("userRatingCount")
    @Expose
    private Integer userRatingCount;
    @SerializedName("editorialRatingCount")
    @Expose
    private Integer editorialRatingCount;

    public Double getPressRating() {
        return pressRating;
    }

    public void setPressRating(Double pressRating) {
        this.pressRating = pressRating;
    }

    public Integer getPressReviewCount() {
        return pressReviewCount;
    }

    public void setPressReviewCount(Integer pressReviewCount) {
        this.pressReviewCount = pressReviewCount;
    }

    public Double getUserRating() {
        return userRating;
    }

    public void setUserRating(Double userRating) {
        this.userRating = userRating;
    }

    public Integer getUserReviewCount() {
        return userReviewCount;
    }

    public void setUserReviewCount(Integer userReviewCount) {
        this.userReviewCount = userReviewCount;
    }

    public Integer getUserRatingCount() {
        return userRatingCount;
    }

    public void setUserRatingCount(Integer userRatingCount) {
        this.userRatingCount = userRatingCount;
    }

    public Integer getEditorialRatingCount() {
        return editorialRatingCount;
    }

    public void setEditorialRatingCount(Integer editorialRatingCount) {
        this.editorialRatingCount = editorialRatingCount;
    }

}
