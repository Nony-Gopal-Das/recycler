package com.examp.myrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static ClickListener clickListener;
    Context context;
    String[] title,desc;
    int[] images;
    private int i;

    public MyAdapter(Context context, String[] title, String[] desc, int[] images) {
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleTextView.setText(title[position]);
        holder.descTextView.setText(title[position]);
        holder.flagImageView.setImageResource(images[position]);




    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        TextView titleTextView,descTextView;
        ImageView flagImageView;
        private View v;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextViewId);
            descTextView = itemView.findViewById(R.id.descriptionTexId);
            flagImageView = itemView.findViewById(R.id.ausFlag);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),v);

        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;


        }
    }

    public interface ClickListener{

    void onItemClick(int position,View v);
    void onItemLongClick(int position,View v);

    }
    public void setOnItemClickListener(ClickListener clickListener)
    {

        MyAdapter.clickListener = clickListener;
    }
}
