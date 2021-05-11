package com.example.myapplicationiipertemuan9.adapters;

import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.network.Const;


import androidx.annotation.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import android.view.*;
import java.util.*;
import com.bumptech.glide.*;
import com.example.myapplicationiipertemuan9.models.Search;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {
    private List<Search> upcomings;

    public UpcomingAdapter(List<Search> upcomings) {
        this.upcomings = upcomings;
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
                .load(Const.IMG_URL_200 + upcomings.get(i).getImgUrl())
                .into(viewHolder.ivPoster);
        viewHolder.tvTitle.setText(upcomings.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return upcomings.size();
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
