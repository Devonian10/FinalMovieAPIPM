package com.example.myapplicationiipertemuan9;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.*;
public class SearchFragment extends Fragment {
    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_search, container, false);

    }
}
