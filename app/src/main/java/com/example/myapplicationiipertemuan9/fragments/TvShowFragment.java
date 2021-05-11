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
import com.example.myapplicationiipertemuan9.activities.DetailTvShowActivity;
import com.example.myapplicationiipertemuan9.adapters.TvShowAdapter;
import com.example.myapplicationiipertemuan9.models.TvShowPlaying;
import com.example.myapplicationiipertemuan9.models.TvShowPlayingResponse;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.network.TvShowApiClient;
import com.example.myapplicationiipertemuan9.network.TvShowApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowFragment extends Fragment implements TvShowAdapter.OnItemClick {
    private static final String TAG = "TvShowFragment";

    private RecyclerView recyclerView;
    private TvShowAdapter tvShowadapter;
    private List<TvShowPlaying> tvShowPlayings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);
        recyclerView = view.findViewById(R.id.rv_Tv_show);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        loadData();
        return view;
    }

    public void loadData() {
        TvShowApiInterface tvApiInterface = TvShowApiClient.getRetrofit()
                .create(TvShowApiInterface.class);

        Call<TvShowPlayingResponse> tvShowPlayingCall = tvApiInterface.getAiringToday(Const.API_KEY);
        tvShowPlayingCall.enqueue(new Callback<TvShowPlayingResponse>() {
            @Override
            public void onResponse(Call<TvShowPlayingResponse> call, Response<TvShowPlayingResponse> response) {
                if (response.isSuccessful() && response.body().getTvPlaying() != null) {
                    tvShowPlayings = response.body().getTvPlaying();
                    tvShowadapter = new TvShowAdapter(tvShowPlayings, TvShowFragment.this);
                    recyclerView.setAdapter(tvShowadapter);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TvShowPlayingResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(int pos) {
        String s = tvShowPlayings.get(pos).getTitle();
        Intent detailActivity = new Intent(getActivity(), DetailTvShowActivity.class);
        detailActivity.putExtra("ID", tvShowPlayings.get(pos).getId());
        detailActivity.putExtra("TITLE", tvShowPlayings.get(pos).getTitle());
        detailActivity.putExtra("IMG_URL", tvShowPlayings.get(pos).getImgUrl());
        startActivity(detailActivity);
    }
}
