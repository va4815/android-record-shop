package com.northcoders.recordshop.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshop.service.ApiService;
import com.northcoders.recordshop.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private static final String TAG = "AlbumRepository";
    private List<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        ApiService service = RetrofitInstance.getService();

        service.getAllAlbums().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {
                Log.i(TAG, throwable.getMessage());
            }
        });

        return mutableLiveData;
    }

    public void createAlbum(Album album) {
        ApiService albumApiService = RetrofitInstance.getService();

        Call<Album> call = albumApiService.createAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(), "Album added to database", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(), "Unable to add album to database", Toast.LENGTH_SHORT).show();
                Log.e(TAG, throwable.getMessage());
            }
        });

    }

    public void updateAlbum(Album album) {
        ApiService albumApiService = RetrofitInstance.getService();

        Call<Album> call = albumApiService.updateAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(), "Album updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(), "Unable to update album", Toast.LENGTH_SHORT).show();
                Log.e(TAG, throwable.getMessage());
            }
        });
    }

    public void deleteAlbum(Long id) {
        ApiService albumApiService = RetrofitInstance.getService();

        Call<Void> call = albumApiService.deleteAlbum(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(application.getApplicationContext(), "Album deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });
    }

}
