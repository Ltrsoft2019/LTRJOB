package com.ltrsoft.ltrjob.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.Classes.DashboardImageClass;
import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class DashboardImageAdapter extends RecyclerView.Adapter<DashboardImageAdapter.ViewHolder> {

    public ArrayList <DashboardImageClass> listofdashimg = new ArrayList<>();

    public DashboardImageAdapter(ArrayList<DashboardImageClass> listofdashimg) {
        this.listofdashimg = listofdashimg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_image_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DashboardImageClass imageClass = listofdashimg.get(position);
        Log.d("url",imageClass.getImage());
        //String imgurl = "https://institute.ltr-soft.com/notification_photo/"+imageClass.getImage();
        String imgurl = "https://institute.ltr-soft.com/company_details/inputfiles/img1.jpeg";

       Picasso.get().load(imgurl).into(holder.dashimg);
    }

    @Override
    public int getItemCount() {
        return listofdashimg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView dashimg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dashimg = itemView.findViewById(R.id.dash_image);
        }
    }
}
