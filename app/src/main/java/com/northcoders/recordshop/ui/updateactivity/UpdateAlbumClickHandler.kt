package com.northcoders.recordshop.ui.updateactivity

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.northcoders.recordshop.model.Album
import com.northcoders.recordshop.ui.mainactivity.MainActivity
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel
import java.util.Objects

class UpdateAlbumClickHandler {

    private lateinit var album: Album
    private lateinit var context: Context
    private lateinit var viewModel: MainActivityViewModel

    constructor(album: Album, context: Context, viewModel: MainActivityViewModel) {
        this.album = album
        this.context = context
        this.viewModel = viewModel
    }

    fun onBackBtnClicked(view: View) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

    fun onUpdateAlbumBtnClicked(view: View) {
        val updatedAlbum = Album(album);

        if (Objects.equals(updatedAlbum.name, "")
            || Objects.equals(updatedAlbum.releasedDate, "")
            || Objects.equals(updatedAlbum.genre, "")
            ) {
            Toast.makeText(context, "Fields cannot be empty.", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(context, MainActivity::class.java)

            viewModel.updateAlbum(album)

            context.startActivity(intent)
        }

    }

    fun onDeleteAlbumBtnClick(view: View) {
        val intent = Intent(context, MainActivity::class.java)

        val id: Long = album.id
        viewModel.deleteAlbum(id)

        context.startActivity(intent)
    }

}