package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventCardAdapter extends RecyclerView.Adapter<EventCardAdapter.ImageViewholder> {
    private Context context;
    private List<Event_class> imageList;

    public EventCardAdapter(List<Event_class> imageList) {
        this.context = context;
        this.imageList = imageList;

    }


    @NonNull
    @Override
    public ImageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.eventcard,parent,false);
        return new ImageViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewholder holder, int position) {

        Event_class model=imageList.get(position);

        // holder.name.setText(model.getId()+"  "+model.getName());
        holder.name.setText(model.getEvent_name());
//        System.out.println(model.getName());
        holder.vanue.setText(model.getEvent_venue());
        holder.date.setText(model.getEvent_date_time());
        holder.duration.setText(model.getEvent_duration());



        String imageUrl = model.getPhoto_path();
        Picasso.get().load(imageUrl).into(holder.imageView);


        holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hey", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
               // EventDetailFragment w=new EventDetailFragment();

                Bundle a=new Bundle();
                a.putString("nameee", model.getEvent_name());
                a.putString("duration", model.getEvent_duration());
                a.putString("guest", model.getEvent_guest());
                a.putString("vanue", model.getEvent_venue());
                a.putString("date_time", model.getEvent_date_time());
//                a.putString("time", model.get());







            }
        });

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
    public class ImageViewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,vanue;
        TextView desc,time,date,duration;
        TextView link;

        CardView c;
        public ImageViewholder(@NonNull View itemV) {
            super(itemV);
            imageView=itemV.findViewById(R.id.AI);


            name=itemV.findViewById(R.id.txt1);
            vanue=itemV.findViewById(R.id.txt2);

            link=itemV.findViewById(R.id.txt3);
            c=itemV.findViewById(R.id.c);
            date=itemV.findViewById(R.id.txt4);
            duration=itemV.findViewById(R.id.txt5);

        }
    }
}
