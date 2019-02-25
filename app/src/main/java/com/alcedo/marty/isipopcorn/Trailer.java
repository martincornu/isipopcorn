
package com.alcedo.marty.isipopcorn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trailer implements Serializable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("href")
    @Expose
    private String href;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
