package com.example.myapplicationiipertemuan9.adapters;

import android.view.*;
import android.widget.*;

import androidx.annotation.*;
import androidx.recyclerview.widget.*;

import com.bumptech.glide.Glide;
import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.adapters.clicklistener.OnItemClickListener;
import com.example.myapplicationiipertemuan9.models.HomePlaying;
import com.example.myapplicationiipertemuan9.models.movie.Movie;
import com.example.myapplicationiipertemuan9.network.Const;

import java.util.*;

public class HomePlayingAdapter extends RecyclerView.Adapter<HomePlayingAdapter.ViewHolder> {
    private List<HomePlaying> nowPlayings;
    private OnItemClick onItemClick;
    private OnItemClickListener onClickListener;
    public HomePlayingAdapter(List<HomePlaying> nowPlayings, OnItemClick onItemClick) {
        this.nowPlayings = nowPlayings;
        this.onItemClick = onItemClick;
    }
    public void setClickListener(OnItemClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movie, viewGroup, false);
        return new ViewHolder(view, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(viewHolder.itemView.getContext())
                .load(Const.IMG_URL_200 + nowPlayings.get(i).getImgUrl())
                .into(viewHolder.ivPoster);
        viewHolder.tvTitle.setText(nowPlayings.get(i).getTitle());
    }
    public void appendList(List<HomePlaying> listToAppend){
        nowPlayings.addAll(listToAppend);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return nowPlayings.size();
    }

    public interface OnItemClick {
        void onClick(int pos);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnItemClick onItemClick;
        ImageView ivPoster;
        TextView tvTitle;

        ViewHolder(@NonNull View itemView, OnItemClick onItemClick) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            this.onItemClick = onItemClick;
        }

        @Override
        public void onClick(View view) {
            onItemClick.onClick(getAdapterPosition());
        }
    }
}
