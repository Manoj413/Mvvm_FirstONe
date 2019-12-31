package com.example.mvvmrecyclerex.ApiClient;

import com.example.mvvmrecyclerex.ApiInterface.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private static final String BASE_URL="https://uniqueandrocode.000webhostapp.com/hiren/";
    private static ApiClient myClient;
    private Retrofit retrofit;
    private ApiClient(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized ApiClient getInstance(){
        if (myClient==null){
            myClient=new ApiClient();
        }
        return myClient;
    }
    public ApiInterface getMyApi(){
        return retrofit.create(ApiInterface.class);
    }

}
