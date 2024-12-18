package com.northcoders.recordshop.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.recordshop.ui.newalbum.NewAlbumActivity;

public class MainActivityClickHandler {
    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view) {
        Intent intent = new Intent(view.getContext(), NewAlbumActivity.class);
        context.startActivity(intent);
    }

}
