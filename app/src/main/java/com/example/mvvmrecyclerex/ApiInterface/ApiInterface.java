package com.example.mvvmrecyclerex.ApiInterface;

import com.example.mvvmrecyclerex.Model.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("androidwebmvvm.php")
    Call<ArrayList<Movie>> getartistdata();

}
