package com.example.myapplicationiipertemuan9.fragments;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;


import android.util.*;
import android.view.*;
import android.os.*;
import android.widget.*;


import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.adapters.DashboardAdapter;
import com.example.myapplicationiipertemuan9.models.Dashboard;
import com.example.myapplicationiipertemuan9.models.DashboardResponse;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.network.MovieApiClient;
import com.example.myapplicationiipertemuan9.network.MovieApiInterface;
import java.util.*;

import retrofit2.*;
import retrofit2.Response;


public class DashboardFragment extends Fragment {
    private static final String TAG = "PopularFragment";
    private RecyclerView recyclerView;
    private DashboardAdapter adapter;
    private List<Dashboard> populars;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = view.findViewById(R.id.rv_popular);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        loadData();
        return view;
    }

    public void loadData() {
        MovieApiInterface movieApiInterface = MovieApiClient.getRetrofit()
                .create(MovieApiInterface.class);

        Call<DashboardResponse> nowPlayingCall = movieApiInterface.getPopulars(Const.API_KEY);
        nowPlayingCall.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                if (response.isSuccessful() && response.body().getPopulars() != null) {
                    populars = response.body().getPopulars();
                    adapter = new DashboardAdapter(populars);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

