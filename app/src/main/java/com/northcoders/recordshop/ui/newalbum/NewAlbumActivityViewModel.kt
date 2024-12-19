package com.northcoders.recordshop.ui.newalbum

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.northcoders.recordshop.model.Album
import com.northcoders.recordshop.model.AlbumRepository
import com.northcoders.recordshop.model.Artist
import com.northcoders.recordshop.model.ArtistRepository

class NewAlbumActivityViewModel(@NonNull application: Application) : AndroidViewModel(application) {

    private val artistRepository: ArtistRepository = ArtistRepository(application)
    private val albumRepository: AlbumRepository = AlbumRepository(application)

    fun getAllArtists() : LiveData<List<Artist>> {
        return artistRepository.getAllArtistsData()
    }

    fun createAlbum(album: Album) {
        albumRepository.createAlbum(album)
    }

}