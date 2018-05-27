package com.app10.hllcn.adstock;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    private ArrayList<String> titles ;
    private ArrayList<String> descriptions;
    public VerticalAdapter(ArrayList<String> titles,ArrayList<String> descriptions) {
        this.titles = titles;
        this.descriptions = descriptions;
    }

    @Override
    public VerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical, viewGroup, false);
        return new VerticalAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(VerticalAdapter.ViewHolder holder, int position) {
        String title = titles.get(position);
        String description = descriptions.get(position);
        //Log.d("TitleBurda",title);
        if(position == 0){
            holder.logo.setImageResource(R.drawable.lemar);
        }else if(position == 1){
            holder.logo.setImageResource(R.drawable.sega);
        }
        else if(position == 2){
            holder.logo.setImageResource(R.drawable.a1);
        }else if(position == 3){
            holder.logo.setImageResource(R.drawable.a2);
        }else if(position == 4){
            holder.logo.setImageResource(R.drawable.a3);
        }else if(position == 5){
            holder.logo.setImageResource(R.drawable.a4);
        }else if(position == 6){
            holder.logo.setImageResource(R.drawable.a5);
        }else if(position == 7){
            holder.logo.setImageResource(R.drawable.a6);
        }else if(position == 8){
            holder.logo.setImageResource(R.drawable.a7);
        }else if(position == 9){
            holder.logo.setImageResource(R.drawable.a8);
        }
        else {
            holder.logo.setImageResource(R.drawable.a9);
        }

        holder.title.setText(title);
        holder.description.setText(description);
    }
    @Override
    public int getItemCount() {
        return titles.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private ImageView logo;
        ViewHolder(final View itemView) {
            super(itemView);
            this.logo = itemView.findViewById(R.id.icon);
            this.title = itemView.findViewById(R.id.title);
            this.description = (TextView) itemView.findViewById(R.id.description);
            //logo.setImageDrawable(itemView.getResources().getDrawable(R.drawable.lemar));
        }

    }
}