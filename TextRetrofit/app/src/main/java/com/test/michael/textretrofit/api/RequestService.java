package com.test.michael.textretrofit.api;

import com.test.michael.textretrofit.entity.DailyStories;

import retrofit.Callback;
import retrofit.http.GET;

/**
 *
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 10:47
 * Description:https://samebug.io/exceptions/80815/java.lang.IllegalArgumentException/retrofitinterfacegetuser-must-have-return-type-or
 */
public interface RequestService {
    @GET("/news/latest")
    void getLatestDailyStories(Callback<DailyStories> callback);
}  