package com.northcoders.recordshop.ui.newalbum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.northcoders.recordshop.R
import com.northcoders.recordshop.databinding.ActivityNewAlbumBinding
import com.northcoders.recordshop.model.Album
import com.northcoders.recordshop.model.Artist
import com.northcoders.recordshop.model.Genre
import com.northcoders.recordshop.model.Song
import com.northcoders.recordshop.ui.mainactivity.MainActivity

class NewAlbumActivity : AppCompatActivity() {
    private val TAG = "NewAlbumActivity"

    private lateinit var binding: ActivityNewAlbumBinding
    private lateinit var viewModel: NewAlbumActivityViewModel

    private lateinit var artistAdapter: ArtistAdapter
    private lateinit var songAdapter: SongAdapter
    private lateinit var genreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_new_album)


        viewModel = ViewModelProvider(this).get(NewAlbumActivityViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_album)
        binding.album = Album()
        binding.song = Song()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById<View>(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.clickHandler = NewAlbumClickHandler(this, object : NewAlbumInterface {
            override fun onAddSongClicked(view: View) {
                val title = binding.song?.title
                val writer = binding.song?.writer
                val songLength = binding.song?.songLength

                if (title == null || writer == null || title.isEmpty() || writer.isEmpty()) {
                    Toast.makeText(view.context, "Cannot add song to the album", Toast.LENGTH_SHORT).show()
                } else {
                    val newSong = Song()
                    newSong.title = title
                    newSong.writer = writer
                    newSong.songLength = songLength!!.toLong()

                    val songs = binding.album?.songs as ArrayList
                    songs.add(newSong)

                    // set data to the listview
                    songAdapter.items = songs
                    songAdapter.notifyDataSetChanged()

                    // reset data
                    binding.song = Song()
                }



            }

            override fun onCreateAlbumClicked(view: View) {
                val album = binding?.album
                if (album != null) {
                    viewModel.createAlbum(album)

                    val intent = Intent(view.context, MainActivity::class.java)
                    view.context.startActivity(intent)
                }
            }
        })



        binding.artistSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val artist = artistAdapter.list()[position]

                var artistIds = mutableListOf<Long>()
                artistIds.add(artist.id)
                binding.album?.artistIds = artistIds
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

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

        artistAdapter = ArtistAdapter()
        binding.artistSpinner.adapter = artistAdapter

        genreAdapter = GenreAdapter()
        genreAdapter.setList(Genre.entries)
        binding.genreSpinner.adapter = genreAdapter

        songAdapter = SongAdapter()
        binding.songListView.adapter = songAdapter


        getAllArtists()

    }

    private fun getAllArtists() {
        viewModel.getAllArtists().observe(this, object : Observer<List<Artist>> {
            override fun onChanged(value: List<Artist>) {
                artistAdapter.setList(value)
                artistAdapter.notifyDataSetChanged()
            }
        })

    }

}