package com.example.myapplicationiipertemuan9.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.*;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationiipertemuan9.R;
import com.example.myapplicationiipertemuan9.activities.Hero;

public class HeroRecyclerAdapter extends RecyclerView.Adapter<HeroRecyclerAdapter.ViewHolder> {

    private List<Hero> models;
    private RecyclerViewClickListener listener;

    public HeroRecyclerAdapter(List<Hero> models, RecyclerViewClickListener listener) {
        this.models = models;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero model = models.get(position);
        holder.ivHeroPhoto.setBackgroundResource(model.getPhoto());
        holder.ivHeroName.setText(model.getName());
        //holder.ivHeroSummary.setText(model.getSummary());
        holder.ivHeroBirthday.setText(model.getBirthday());
        holder.ivHeroConstellation.setText(model.getConstellation());
        holder.ivHeroVision.setText(model.getVision());
        holder.ivHeroAffiliates.setText(model.getAffiliates());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivHeroPhoto;
        TextView ivHeroName, ivHeroSummary, ivHeroBirthday, ivHeroVision, ivHeroConstellation, ivHeroAffiliates;
        Button detail;
        //ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroPhoto = itemView.findViewById(R.id.iv_hero_photo);
            ivHeroName = itemView.findViewById(R.id.iv_hero_name);
           //ivHeroSummary = itemView.findViewById(R.id.iv_hero_summary);
            ivHeroBirthday = itemView.findViewById(R.id.iv_hero_birthday);
            ivHeroAffiliates = itemView.findViewById(R.id.LOL);
            ivHeroVision = itemView.findViewById(R.id.LOL2);
            ivHeroConstellation = itemView.findViewById(R.id.LOL3);
            //mainLayout = itemView.findViewById(R.id.MainLayout);
            detail = itemView.findViewById(R.id.Buttonview);
            detail.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            listener.onClick(view, getAdapterPosition());
        }

    }
}
