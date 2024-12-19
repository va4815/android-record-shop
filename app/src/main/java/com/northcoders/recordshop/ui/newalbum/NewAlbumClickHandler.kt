package com.northcoders.recordshop.ui.newalbum

import android.content.Context
import android.util.Log
import android.view.View
import com.northcoders.recordshop.model.Song

class NewAlbumClickHandler(val context: Context, val newAlbumInterface: NewAlbumInterface) {

    fun onAddSongClicked(view: View) {
        newAlbumInterface.onAddSongClicked(view)
    }

    fun onSubmitClicked(view: View) {
        newAlbumInterface.onCreateAlbumClicked(view)
    }

}