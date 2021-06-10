package com.example.myapplicationiipertemuan9.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.adapters.clicklistener.OnItemClickListener;
import com.example.myapplicationiipertemuan9.models.TvShowPlaying;
import com.example.myapplicationiipertemuan9.network.Const;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {
    private List<TvShowPlaying> tvPlaying;
    private OnItemClick onItemClick;
    private OnItemClickListener clickListener;

    public TvShowAdapter(List<TvShowPlaying> tvPlaying, OnItemClick onItemClick) {
        this.tvPlaying = tvPlaying;
        this.onItemClick = onItemClick;
    }
    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
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
                .load(Const.IMG_URL_200 + tvPlaying.get(i).getPosterPath2())
                .into(viewHolder.ivPoster);
        viewHolder.tvTitle.setText(tvPlaying.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return tvPlaying.size();
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
