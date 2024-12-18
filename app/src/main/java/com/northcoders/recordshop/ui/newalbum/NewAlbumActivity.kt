package com.northcoders.recordshop.ui.newalbum

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.northcoders.recordshop.R
import com.northcoders.recordshop.databinding.ActivityNewAlbumBinding
import com.northcoders.recordshop.model.Artist
import com.northcoders.recordshop.model.Gender

class NewAlbumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_new_album)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById<View>(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_album)

        val artists: List<Artist> = arrayListOf(
            Artist(123, "bbb", Gender.F),
            Artist(111, "aaa", Gender.F)
        )
        binding.artistSpinner.adapter = ArtistAdapter(this.applicationContext, artists)

    }

}