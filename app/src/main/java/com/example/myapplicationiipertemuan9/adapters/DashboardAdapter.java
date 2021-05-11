package com.example.myapplicationiipertemuan9.adapters;

import androidx.recyclerview.widget.*;
import androidx.annotation.*;
import android.view.*;
import android.widget.*;


import com.bumptech.glide.Glide;
import com.example.myapplicationiipertemuan9.models.Dashboard;
import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.network.Const;
import java.util.*;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    private List<Dashboard> populars;

    public DashboardAdapter(List<Dashboard> populars) {
        this.populars = populars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(viewHolder.itemView.getContext())
                .load(Const.IMG_URL_200 + populars.get(i).getImgUrl())
                .into(viewHolder.ivPoster);
        viewHolder.tvTitle.setText(populars.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return populars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
