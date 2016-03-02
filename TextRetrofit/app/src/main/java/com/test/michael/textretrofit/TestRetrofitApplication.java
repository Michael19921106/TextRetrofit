package com.test.michael.textretrofit;

import android.app.Application;
import android.content.Context;

import com.test.michael.textretrofit.respository.NetRepository;
import com.test.michael.textretrofit.respository.NetRepositoryImpl;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 13:30
 * Description:
 */
public class TestRetrofitApplication extends Application {
    private static Context context;
    private static NetRepository netRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static NetRepository getNetRepository(){
        if (netRepository ==null){
            netRepository = new NetRepositoryImpl(context);
        }
        return netRepository;
    }
}