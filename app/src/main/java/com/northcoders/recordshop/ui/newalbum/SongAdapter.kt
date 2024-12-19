package com.northcoders.recordshop.ui.newalbum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.northcoders.recordshop.R
import com.northcoders.recordshop.databinding.ListviewSongItemBinding
import com.northcoders.recordshop.model.Song

class SongAdapter : BaseAdapter() {
    var items: MutableList<Song> = mutableListOf()

    fun setList(list: List<Song>) {
        items.clear()
        items.addAll(list)
    }

    fun list() : List<Song> {
        return items
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ListviewSongItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent?.context),
            R.layout.listview_song_item,
            parent,
            false
        )

        val item = getItem(position) as Song

        binding.item = item

        return binding.root
    }
}