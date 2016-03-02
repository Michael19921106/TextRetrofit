package com.test.michael.textretrofit.respository;

import android.content.Context;

import com.test.michael.textretrofit.entity.DailyStories;
import com.test.michael.textretrofit.api.RequestApi;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 14:17
 * Description:
 */
public class NetRepositoryImpl implements NetRepository {
    private Context context;
    public NetRepositoryImpl(Context context){
        this.context = context;
    }

    @Override
    public void getLatestDailyStories(final Callback<DailyStories> callback) {
        RequestApi.createApi().getLatestDailyStories(new retrofit.Callback<DailyStories>() {
            @Override
            public void success(DailyStories dailyStories, Response response) {
                callback.success(dailyStories,response.getUrl());
            }

            @Override
            public void failure(RetrofitError error) {
                callback.failure(error,error.getUrl());
            }
        });
    }
}