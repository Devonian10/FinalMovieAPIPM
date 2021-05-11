package com.example.myapplicationiipertemuan9.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplicationiipertemuan9.fragments.DashboardFragment;
import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.fragments.SearchFragment;
import com.example.myapplicationiipertemuan9.fragments.HomeFragment;
import com.example.myapplicationiipertemuan9.fragments.TvShowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.item_now_playing);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.item_now_playing:
                getSupportActionBar().setTitle(getResources().getString(R.string.menu_now_playing));
                fragment = new HomeFragment();
                break;
            case R.id.item_tvshow:
                getSupportActionBar().setTitle(getResources().getString(R.string.menu_Tvshow));
                fragment = new TvShowFragment();
                break;
            case R.id.item_popular:
                getSupportActionBar().setTitle(getResources().getString(R.string.menu_popular));
                fragment = new DashboardFragment();
                break;
            case R.id.item_upcoming:
                getSupportActionBar().setTitle(getResources().getString(R.string.menu_upcoming));
                fragment = new SearchFragment();
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}