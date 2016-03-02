package com.test.michael.textretrofit.entity;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 10:49
 * Description:
 * 使用@SerializedName标签定义属性序列化后的名字
 * 使用 new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();创建Gson对象，没有@Expose注释的属性将不会被序列化
 */
public class DailyStories {
    @Expose
    private String date;
    @Expose
    private List<Story> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
}