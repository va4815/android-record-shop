package com.northcoders.recordshop.ui.newalbum

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.northcoders.recordshop.R
import com.northcoders.recordshop.databinding.SpinnerArtistItemBinding
import com.northcoders.recordshop.model.Artist

class ArtistAdapter : BaseAdapter() {

    private var items: MutableList<Artist> = mutableListOf()

    fun setList(list: List<Artist>) {
        items.clear()
        items.addAll(list)
    }

    fun list() : List<Artist> {
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
        val binding: SpinnerArtistItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent?.context),
            R.layout.spinner_artist_item,
            parent,
            false
        )

        val item = getItem(position) as Artist

        binding.item = item

        return binding.root
    }




}