package com.example.skycoreapp.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skycoreapp.R;
import com.example.skycoreapp.model.Business;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.MyViewHolder> {
    private Context context;
    List<Business> businesss;
    public ListItemAdapter(Context context, List<Business> business) {
        this.context = context;
        this.businesss=business;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                holder.title.setText(businesss.get(position).getName());
        String replaceString=businesss.get(position).getAlias().replaceAll("-"," ");
                holder.text_Subtitle.setText(replaceString);
   String rating= String.valueOf(businesss.get(position).getRating());
holder.ratingImag.setText(rating);
        holder.ratingImag.setGravity(Gravity.CENTER);

//        Picasso.get().load(String.valueOf(businesss.get(position).getRating().toString())).into(holder.ratingImag);
        Picasso.get().load(businesss.get(position).getImageUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return businesss.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.text_Subtitle)
        TextView text_Subtitle;
        @BindView(R.id.image)
        ImageView image;

        @BindView(R.id.ratingImag)
        TextView ratingImag;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
