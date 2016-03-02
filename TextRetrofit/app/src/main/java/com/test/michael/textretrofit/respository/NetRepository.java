package com.test.michael.textretrofit.respository;

import com.test.michael.textretrofit.entity.DailyStories;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 14:16
 * Description:
 */
public interface NetRepository {
    void getLatestDailyStories(Callback<DailyStories> callback);

     interface Callback<T> {

        /**
         * Successful
         *
         * @param t
         * @param url
         */
         void success(T t, String url);


        /**
         * Unsuccessful
         *
         * @param e unexpected exception.
         */
         void failure(Exception e, String url);
    }
}  