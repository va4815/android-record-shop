package com.northcoders.recordshop.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        return albumRepository.getMutableLiveData();
    }

    public void createAlbum(Album album) {
        albumRepository.createAlbum(album);
    }

    public void updateAlbum(Album album) {
        albumRepository.updateAlbum(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteAlbum(id);
    }

}
