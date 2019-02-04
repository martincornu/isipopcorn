
package com.alcedo.marty.isipopcorn;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieShowtime {

    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("releaseWeek")
    @Expose
    private String releaseWeek;
    @SerializedName("onShow")
    @Expose
    private OnShow onShow;
    @SerializedName("version")
    @Expose
    private Version version;
    @SerializedName("screenFormat")
    @Expose
    private ScreenFormat screenFormat;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("scr")
    @Expose
    private List<Scr> scr = null;

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getReleaseWeek() {
        return releaseWeek;
    }

    public void setReleaseWeek(String releaseWeek) {
        this.releaseWeek = releaseWeek;
    }

    public OnShow getOnShow() {
        return onShow;
    }

    public void setOnShow(OnShow onShow) {
        this.onShow = onShow;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public ScreenFormat getScreenFormat() {
        return screenFormat;
    }

    public void setScreenFormat(ScreenFormat screenFormat) {
        this.screenFormat = screenFormat;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public List<Scr> getScr() {
        return scr;
    }

    public void setScr(List<Scr> scr) {
        this.scr = scr;
    }

}
