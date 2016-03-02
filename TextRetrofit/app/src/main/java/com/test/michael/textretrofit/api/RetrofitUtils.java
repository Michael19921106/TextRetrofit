package com.test.michael.textretrofit.api;

import com.google.gson.GsonBuilder;
import com.test.michael.textretrofit.BuildConfig;
import com.test.michael.textretrofit.TestRetrofitApplication;
import com.test.michael.textretrofit.net.OKHttpUtils;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 13:41
 * Description:通过RestAdapter生成一个刚才定义的接口的实现类，使用的是动态代理。
 */
public class RetrofitUtils {

    private static RestAdapter restAdapter;

    public static <T> T createApi(Class<T> clazz,String api){
        if (restAdapter ==null){
            synchronized (RetrofitUtils.class){
                if (restAdapter ==null){
                    restAdapter = new RestAdapter.Builder()
                            .setEndpoint(api)
                            .setClient(new OkClient(OKHttpUtils.getInstance
                                    (TestRetrofitApplication.getContext())))
                            .setConverter(new GsonConverter(new GsonBuilder()
                                    .excludeFieldsWithoutExposeAnnotation().create()))
                            .setLogLevel(BuildConfig.DEBUG?RestAdapter.LogLevel.FULL :
                                    RestAdapter.LogLevel.NONE)
                            .build();
                }
            }
        }
        return restAdapter.create(clazz);
    }
}  