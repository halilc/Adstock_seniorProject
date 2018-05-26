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


public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    private String[] titles;

    public VerticalAdapter(String[] titles) {
        this.titles = titles;
    }

    @Override
    public VerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical, viewGroup, false);
        return new VerticalAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(VerticalAdapter.ViewHolder holder, int position) {
        String title = titles[position];
        String description = "Hello world, " + title;
        Log.d("TitleBurda", title);
        holder.title.setText(title);
        holder.description.setText(description);
    }
    @Override
    public int getItemCount() {
        return titles.length;
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
            logo.setImageDrawable(itemView.getResources().getDrawable(R.drawable.lemar));
        }

    }
}