package com.northcoders.recordshop.ui.updateactivity

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import com.northcoders.recordshop.model.AlbumRepository

class UpdateActivityViewModel(@NonNull application: Application) : AndroidViewModel(application) {

    private val albumRepository: AlbumRepository = AlbumRepository(application)

}