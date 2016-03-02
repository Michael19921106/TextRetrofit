package com.test.michael.textretrofit.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 10:51
 * Description:
 */
public class Story {
    @Expose
    private List<String> images;
    @Expose
    private String type;
    @Expose
    private String id;
    @Expose
    @SerializedName("ga_prefix")
    private String gaPrefix;
    @Expose
    private String title;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}