package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Artist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<Album> createAlbum(@Body Album album);

    @PUT("albums")
    Call<Album> updateAlbum(@Body Album album);

    @DELETE("albums/{id}")
    Call<Void> deleteAlbum(@Path("id") long id);

    @GET("artists")
    Call<List<Artist>> getAllArtists();


}
