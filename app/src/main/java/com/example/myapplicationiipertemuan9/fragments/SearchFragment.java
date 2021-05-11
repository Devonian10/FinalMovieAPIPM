package com.example.myapplicationiipertemuan9.fragments;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Toast;

import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.adapters.UpcomingAdapter;
import com.example.myapplicationiipertemuan9.models.SearchResponse;
import com.example.myapplicationiipertemuan9.models.Search;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.network.MovieApiClient;
import com.example.myapplicationiipertemuan9.network.MovieApiInterface;

import java.util.*;

import retrofit2.*;
public class SearchFragment extends Fragment {
    private static final String TAG = "UpcomingFragment";
    private RecyclerView recyclerView;
    private UpcomingAdapter adapter;
    private List<Search> upcomings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.rv_upcoming);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        loadData();
        return view;
    }

    public void loadData() {
        MovieApiInterface movieApiInterface = MovieApiClient
                .getRetrofit().create(MovieApiInterface.class);
        Call<SearchResponse> upcomingCall = movieApiInterface.getUpcomings(Const.API_KEY);
        upcomingCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    upcomings = response.body().getUpcomings();
                    adapter = new UpcomingAdapter(upcomings);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
