package com.test.michael.textretrofit.net;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.test.michael.textretrofit.common.Constant;

import java.util.concurrent.TimeUnit;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 13:11
 * Description: OKHttp网络请求配置，返回单例对象
 */
public class OKHttpUtils {
    private static OkHttpClient singleton;
    public static OkHttpClient getInstance(Context context){
        if (singleton == null){
            synchronized (OKHttpUtils.class){
//                if (singleton == null){
                    singleton = new OkHttpClient();
//                    singleton.setCache(new Cache(FileUtils.getHttpCacheDir(context), Constant
//                            .Config.HTTP_CACHE_SIZE));
                    singleton.setConnectTimeout(Constant.Config.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
                    singleton.setReadTimeout(Constant.Config.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);
//                    singleton.networkInterceptors().add(new CacheInterceptor());
//                }
            }
        }
        return singleton;
    }
}  