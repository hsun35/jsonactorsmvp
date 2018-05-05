package com.example.hefen.jsonactorsmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hefen.jsonactorsmvp.R;
import com.example.hefen.jsonactorsmvp.model.Actor;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hefen on 5/4/2018.
 */

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    List<Actor> actorList;
    Context context;

    public MyAdapter(List<Actor> actorList, Context context) {
        this.actorList = actorList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        final MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Actor actor = actorList.get(position);
        String imageUrl = actor.getImage();

        if (imageUrl == null || imageUrl.length() == 0) {
            //holder.imageViewMyImage.setImageResource(R.drawable.simpsons);
        } else {
            Picasso.with(context).load(imageUrl).into(holder.imageViewMyImage);
        }

        holder.nameTextView.setText(actor.getName());
        holder.countryTextView.setText(actor.getCountry());
        holder.heightTextView.setText(actor.getHeight());
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;// descriptionTextView, countryTextView;
        TextView countryTextView;
        TextView heightTextView;
        ImageView imageViewMyImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.textViewName);

            heightTextView = itemView.findViewById(R.id.textViewHeight);
            countryTextView = itemView.findViewById(R.id.textViewCountry);
            //countryTextView = itemView.findViewById(R.id.textViewCountry);
            imageViewMyImage = itemView.findViewById(R.id.imageView);
        }
    }


}
