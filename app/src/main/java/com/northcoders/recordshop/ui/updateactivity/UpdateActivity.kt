package com.northcoders.recordshop.ui.updateactivity

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.northcoders.recordshop.R
import com.northcoders.recordshop.databinding.ActivityUpdateBinding
import com.northcoders.recordshop.model.Album

class UpdateActivity : AppCompatActivity() {

    private val INTENT_KEY_ALBUM = "INTENT_KEY_ALBUM"

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var handler: UpdateAlbumClickHandler
    private lateinit var selectAlbum: Album



    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_update)
        val viewModel: UpdateActivityViewModel = ViewModelProvider(this).get(UpdateActivityViewModel::class.java)

        val album: Album? = intent.getParcelableExtra(INTENT_KEY_ALBUM, Album::class.java)
        if (album != null) {
            selectAlbum = album
            binding.clickHandler = UpdateAlbumClickHandler(selectAlbum, this, viewModel)
        }


    }
}