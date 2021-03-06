package com.xinly.cake.component.net.interceptor;


import com.xinly.core.net.JHttpLoggingInterceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 如果是上传文件格式的，不需要添加过滤
 * <p>
 * Created by zm on 2019/8/20.
 */

public class XinlyHttpLoggingInterceptor extends JHttpLoggingInterceptor {

    /**
     * 需要被过滤掉log的url地址
     */
    public static final String[] FILTER_URLS = {"/upload/image"};

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        try {
            final String url = request.url().url().toString();
            for (String filter_url : FILTER_URLS) {
                if (url.contains(filter_url)) {
                    Response response = chain.proceed(request);
                    return response;
                }
            }
        } catch (Exception e) {
            return super.intercept(chain);
        }
        return super.intercept(chain);
    }
}
