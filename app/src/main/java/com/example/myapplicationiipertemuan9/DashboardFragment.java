package com.example.myapplicationiipertemuan9;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.os.*;
public class DashboardFragment extends Fragment {
    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
}
