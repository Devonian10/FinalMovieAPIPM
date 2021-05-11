package com.example.myapplicationiipertemuan9.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.activities.DetailActivity;
import com.example.myapplicationiipertemuan9.adapters.HomePlayingAdapter;
import com.example.myapplicationiipertemuan9.models.HomePlaying;
import com.example.myapplicationiipertemuan9.models.HomePlayingResponse;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.network.MovieApiClient;
import com.example.myapplicationiipertemuan9.network.MovieApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements HomePlayingAdapter.OnItemClick {
    private static final String TAG = "NowPlayingFragment";

    private RecyclerView recyclerView;
    private HomePlayingAdapter adapter;
    private List<HomePlaying> nowPlayings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rv_now_playing);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        loadData();
        return view;
    }

    public void loadData() {
        MovieApiInterface movieApiInterface = MovieApiClient.getRetrofit()
                .create(MovieApiInterface.class);

        Call<HomePlayingResponse> nowPlayingCall = movieApiInterface.getNowPlaying(Const.API_KEY);
        nowPlayingCall.enqueue(new Callback<HomePlayingResponse>() {
            @Override
            public void onResponse(Call<HomePlayingResponse> call, Response<HomePlayingResponse> response) {
                if (response.isSuccessful() && response.body().getNowPlayings() != null) {
                    nowPlayings = response.body().getNowPlayings();
                    adapter = new HomePlayingAdapter(nowPlayings, HomeFragment.this);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<HomePlayingResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(int pos) {
        String s = nowPlayings.get(pos).getTitle();
        Intent detailActivity = new Intent(getActivity(), DetailActivity.class);
        detailActivity.putExtra("ID", nowPlayings.get(pos).getId());
        detailActivity.putExtra("TITLE", nowPlayings.get(pos).getTitle());
        detailActivity.putExtra("IMG_URL", nowPlayings.get(pos).getImgUrl());
        startActivity(detailActivity);
    }

}