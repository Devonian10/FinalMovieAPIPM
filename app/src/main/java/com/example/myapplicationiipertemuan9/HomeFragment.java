package com.example.myapplicationiipertemuan9;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewHero;
    private List<Hero> models = new ArrayList<>();
    private HeroRecyclerAdapter.RecyclerViewClickListener listener;

    public void ClickOnMe(){
        listener = new HeroRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);

            }
        };
    }
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHero = (RecyclerView)view.findViewById(R.id.rv_hero);
        recyclerViewHero.setHasFixedSize(true);

        models.addAll(HeroDatabase.getListData());
        ClickOnMe();
        recyclerViewHero.setLayoutManager(new LinearLayoutManager(getActivity()));
        HeroRecyclerAdapter adapter = new HeroRecyclerAdapter(models, listener);
        recyclerViewHero.setAdapter(adapter);
        return view;
    }

}