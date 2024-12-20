package com.northcoders.recordshop.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityMainBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.ui.updateactivity.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private final String INTENT_KEY_ALBUM = "INTENT_KEY_ALBUM";

    private RecyclerView recyclerView;
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler clickHandler;

    private SearchView searchView;
    private List<Album> filteredAlbumList;

    @Override
    protected void onResume() {
        super.onResume();
        getAllAlbums();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        clickHandler = new MainActivityClickHandler(this);

        binding.setClickHandler(clickHandler);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        getAllAlbums();

    }

    private void filterList(String newText) {
        filteredAlbumList = new ArrayList<>();

        for (Album album : albumList) {
            if (album.getName().toLowerCase().contains(newText.toLowerCase())) {
                filteredAlbumList.add(album);
            }

            if (filteredAlbumList.isEmpty()) {
                Toast.makeText(this, "No Album found", Toast.LENGTH_SHORT).show();
            } else {
                albumAdapter.setFilteredList(filteredAlbumList);
            }

        }

    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumList = albums;
                displayAlbumsInRecyclerView();
            }
        });
    }

    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.mainRecyclerView;
        albumAdapter = new AlbumAdapter(albumList, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);

        Album selectAlbum;
        if (filteredAlbumList == null || filteredAlbumList.isEmpty()) {
            selectAlbum = albumList.get(position);
        } else {
            selectAlbum = filteredAlbumList.get(position);
        }

        selectAlbum.setDisplayGenre(Genre.valueOf(selectAlbum.getGenre()));
        intent.putExtra(INTENT_KEY_ALBUM, selectAlbum);

        startActivity(intent);
    }
}