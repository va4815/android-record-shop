package com.northcoders.recordshop.ui.newalbum

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import com.northcoders.recordshop.model.Song
import com.northcoders.recordshop.ui.mainactivity.MainActivity

class NewAlbumClickHandler(val context: Context, val newAlbumInterface: NewAlbumInterface) {

    fun onAddSongClicked(view: View) {
        newAlbumInterface.onAddSongClicked(view)
    }

    fun onSubmitClicked(view: View) {
        newAlbumInterface.onCreateAlbumClicked(view)
    }

    fun onBackBtnClicked(view: View) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}