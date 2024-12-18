package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Artist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<Album> createAlbum(Album album);

    @GET("artists")
    Call<List<Artist>> getAllArtists();

}
