package com.example.myapplicationiipertemuan9.activities;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplicationiipertemuan9.models.movie.Movie;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.R;

public class DetailActivity extends AppCompatActivity {
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("TITLE"));
        }
        ImageView ivPoster = findViewById(R.id.iv_poster);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(getIntent().getStringExtra("TITLE"));
        Glide.with(DetailActivity.this)
                .load(Const.IMG_URL_300 + getIntent().getStringExtra("IMG_URL"))
                .into(ivPoster);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}