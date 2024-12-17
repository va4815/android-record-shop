package com.northcoders.recordshop.ui.mainactivity;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.AlbumItemLayoutBinding;
import com.northcoders.recordshop.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumItemViewHolder> {
    private List<Album> albumList;

    public static class AlbumItemViewHolder extends RecyclerView.ViewHolder {
        private AlbumItemLayoutBinding binding;

        public AlbumItemViewHolder(@NonNull AlbumItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public AlbumAdapter(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item_layout,
                parent,
                false
        );

        return new AlbumItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumItemViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.binding.setAlbum(album);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }



}
