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
import com.ltrsoft.ltrjob.fragments.EventDetailFragment;
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.squareup.picasso.Callback;
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
        context = parent.getContext();
        return new ImageViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewholder holder, int position) {

        Event_class model=imageList.get(position);


        holder.name.setText(model.getEvent_name());
        Toast.makeText(context, ""+model.getEvent_name().toString(), Toast.LENGTH_SHORT).show();

//        System.out.println(model.getName());
//        holder.vanue.setText(model.getEvent_venue());
        holder.date.setText(model.getEvent_date_time());
        holder.duration.setText(model.getEvent_duration());


//                .load("https://institute.ltr-soft.com/event_photo/inputfiles/vector-contact-us-background.jpg")

        String Photo_path = model.getPhoto_path();
        System.out.println("photo path ="+Photo_path);

        Picasso.get()
                .load(Photo_path)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {


                    }

                    @Override
                    public void onError(Exception e) {
                        System.out.println("error while loading image "+e.toString());
                    }
                });


        holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hey", Toast.LENGTH_SHORT).show();

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                EventDetailFragment w = new EventDetailFragment();

                Bundle bundle = new Bundle();
                bundle.putString("nameee", model.getEvent_name());
                bundle.putString("description", model.getEvent_description());
                bundle.putString("duration", model.getEvent_duration());
                bundle.putString("guest", model.getEvent_guest());
                bundle.putString("date_time", model.getEvent_date_time());

                EventDetailFragment w1 = new EventDetailFragment();
                w.setArguments(bundle);


               activity. getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, w1)
                        .addToBackStack(null)
                        .commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
    public class ImageViewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView desc,time,date,duration;
        TextView link;

        CardView c;
        public ImageViewholder(@NonNull View itemV) {
            super(itemV);
            imageView=itemV.findViewById(R.id.AI);


            name=itemV.findViewById(R.id.txt1);
            link=itemV.findViewById(R.id.txt3);
            c=itemV.findViewById(R.id.c);
            date=itemV.findViewById(R.id.txt4);
            duration=itemV.findViewById(R.id.txt5);

        }
    }
}
