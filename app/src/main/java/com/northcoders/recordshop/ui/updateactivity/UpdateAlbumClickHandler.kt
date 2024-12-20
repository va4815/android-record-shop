package com.northcoders.recordshop.ui.updateactivity

import android.content.Context
import android.content.Intent
import android.view.View
import com.northcoders.recordshop.model.Album
import com.northcoders.recordshop.ui.mainactivity.MainActivity

class UpdateAlbumClickHandler {

    private lateinit var album: Album
    private lateinit var context: Context
    private lateinit var viewModel: UpdateActivityViewModel

    constructor(album: Album, context: Context, viewModel: UpdateActivityViewModel) {
        this.album = album
        this.context = context
        this.viewModel = viewModel
    }

    fun onBackBtnClicked(view: View) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}