package com.example.mvvmrecyclerex.Model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    public String id="";

    @SerializedName("name")
    public String artistname="";

    @SerializedName("imageurl")
    public String artistimage="";

    @SerializedName("moviename")
    public String moviename="";

    public Movie(String id, String artistname, String artistimage, String moviename) {
        this.id = id;
        this.artistname = artistname;
        this.artistimage = artistimage;
        this.moviename = moviename;
    }

    public Movie() {
    }
}
