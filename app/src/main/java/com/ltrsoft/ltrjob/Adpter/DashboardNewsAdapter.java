package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.ltrsoft.ltrjob.pojoclass.News_Photo;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DashboardNewsAdapter extends RecyclerView.Adapter<DashboardNewsAdapter.ViewHolder> {

    private List<News_Photo> imageList;

    public DashboardNewsAdapter(ArrayList<News_Photo> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_image_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News_Photo imageClass = imageList.get(position);

        String Photo_path = imageClass.getNews_photo_path();
        System.out.println("photo path ="+Photo_path);

        Picasso.get()
                .load(Photo_path)
                .into(holder.dashimg, new Callback() {
                    @Override
                    public void onSuccess() {
                    }
                    @Override
                    public void onError(Exception e) {
//                        System.out.println("error while loading image "+e.toString());
                    }
                });

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView dashimg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dashimg = itemView.findViewById(R.id.dash_image);
        }
    }
}
