package com.example.mvvmrecyclerex;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmrecyclerex.ApiClient.ApiClient;
import com.example.mvvmrecyclerex.ApiInterface.ApiInterface;
import com.example.mvvmrecyclerex.DetailFragment.DetailFragment;
import com.example.mvvmrecyclerex.Model.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyListViewModel extends ViewModel
{
 public String id="";
 public String artistname="";
    public String artistimage="";
    public String moviename="";
    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private ArrayList<MyListViewModel> myListViewModelArrayList = new ArrayList<>();
    public MutableLiveData<ArrayList<MyListViewModel>> mutableLiveData = new MutableLiveData<>();

    public MyListViewModel(Movie movie) {
        this.id = movie.id;
        this.artistname = movie.artistname;
        this.artistimage = movie.artistimage;
        this.moviename = movie.moviename;
    }

    public MyListViewModel() {

    }

    public String getImageurl(){
        return artistimage;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadimage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView);

    }


    public MutableLiveData<ArrayList<MyListViewModel>> getMutableLiveData()
    {
        ApiInterface apiInterface = ApiClient.getInstance().getMyApi();

        Call<ArrayList<Movie>> call = apiInterface.getartistdata();
        call.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {

                movieArrayList = response.body();
                for (int i=0;i<movieArrayList.size();i++)
                {
                    Movie movie=movieArrayList.get(i);
                    MyListViewModel myListViewModel = new MyListViewModel(movie);
                    myListViewModelArrayList.add(myListViewModel);
                    mutableLiveData.setValue(myListViewModelArrayList);

                }


            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {

            }
        });



        return mutableLiveData;
    }


}
