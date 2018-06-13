package xudeyang.bawie.com.oc.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mac on 2018/5/16.
 */

public class RetrofitUtil {

    public static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private ApiService mApiService;

    private static RetrofitUtil mInstance;

    Interceptor appInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl httpUrl = request
                    .url()
                    .newBuilder()
                    .addQueryParameter("source", "android")
                    .addQueryParameter("appVersion", "101")
                    .build();
            Request requestNew = request
                    .newBuilder()
                    .url(httpUrl)
                    .build();
            return chain.proceed(requestNew);
        }

    };
    private RetrofitUtil() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);
        builder.addInterceptor(appInterceptor);
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public ApiService getUsers() {
        return mApiService;
    }

    public static ApiService getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (null == mInstance) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
        ApiService users = mInstance.getUsers();
        return users;
    }




}
