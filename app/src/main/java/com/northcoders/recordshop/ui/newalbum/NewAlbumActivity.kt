package com.northcoders.recordshop.ui.newalbum

import android.os.Bundle
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
import com.northcoders.recordshop.model.Artist

class NewAlbumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewAlbumBinding
    private lateinit var viewModel: NewAlbumActivityViewModel

    private lateinit var artistAdapter: ArtistAdapter

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

        viewModel = ViewModelProvider(this).get(NewAlbumActivityViewModel::class.java)

        binding.artistSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val artist = artistAdapter.list()[position]
                Toast.makeText(parent?.context, "clicked: "+artist.name, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        artistAdapter = ArtistAdapter()
        binding.artistSpinner.adapter = artistAdapter


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