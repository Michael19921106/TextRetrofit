package com.test.michael.textretrofit.api;

import com.test.michael.textretrofit.common.RequestUrl;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 14:17
 * Description:定义请求接口，即程序中都需要什么请求操作
 */
public class RequestApi {


    private static RequestService requestService;
    public static RequestService createApi(){
        if (requestService ==null){
            synchronized (RequestApi.class){
                if (requestService ==null){
                    requestService = RetrofitUtils.createApi(RequestService.class, RequestUrl.Config.API);
                }
            }
        }
        return requestService;
    }
}  