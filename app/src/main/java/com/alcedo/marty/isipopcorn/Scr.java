
package com.alcedo.marty.isipopcorn;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scr {

    @SerializedName("d")
    @Expose
    private String d;
    @SerializedName("t")
    @Expose
    private List<T> t = null;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }

}
