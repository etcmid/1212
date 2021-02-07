package com.example.mthwapp;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class TApi {
    private static final String BASE_URL = "http://api.weatherstack.com/";
    private static final String ACCESS_KEY = "17c07b21543ef254313a8fec9eb35227";

    private static Retrofit retrofit;


    public static <S> S createService(
            Class<S> serviceClass) {
        if(retrofit==null){
//            OkHttpClient client = new OkHttpClient();
//
//            client.interceptors().add(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request();
//                    HttpUrl url = request.url().newBuilder().addQueryParameter("ACCESS_KEY",ACCESS_KEY).build();
//                    request = request.newBuilder().url(url).build();
//                    return chain.proceed(request);
//                }
//            });

            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create());
//                            .client(client);
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
}
