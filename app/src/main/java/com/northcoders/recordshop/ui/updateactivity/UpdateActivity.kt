package com.northcoders.recordshop.ui.updateactivity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
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
import com.northcoders.recordshop.model.Genre
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel
import com.northcoders.recordshop.ui.newalbum.GenreAdapter

class UpdateActivity : AppCompatActivity() {

    private val INTENT_KEY_ALBUM = "INTENT_KEY_ALBUM"

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var handler: UpdateAlbumClickHandler
    private lateinit var selectAlbum: Album
    private lateinit var genreAdapter: GenreAdapter


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_update)
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // genre spinner
        genreAdapter = GenreAdapter()
        genreAdapter.setList(Genre.entries)
        binding.genreSpinner.adapter = genreAdapter
        binding.genreSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val genre = genreAdapter.list()[position]

                binding.album?.genre = genre.ordinal.toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //
        val album: Album? = intent.getParcelableExtra(INTENT_KEY_ALBUM, Album::class.java)
        if (album != null) {
            selectAlbum = album
            binding.album = selectAlbum

            binding.clickHandler = UpdateAlbumClickHandler(selectAlbum, this, viewModel)

            binding.genreSpinner.setSelection(selectAlbum.displayGenre.ordinal)
        }

    }
}