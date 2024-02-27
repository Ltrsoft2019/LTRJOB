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
import com.ltrsoft.ltrjob.fragments.EventHistoryDetailFragment;
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventHistoryAdapter extends RecyclerView.Adapter<EventHistoryAdapter.EventViewHolder> {
    private Context context;
    private List<Event_class> eventList;

    public EventHistoryAdapter(List<Event_class> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventhistorycard, parent, false);
        context = parent.getContext();
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event_class model = eventList.get(position);

        holder.name.setText(model.getEvent_name());
        holder.venue.setText(model.getEvent_venue());
        holder.date.setText(model.getEvent_date_time());
        holder.duration.setText(model.getEvent_duration());

        String photoPath = model.getPhoto_path();
        Picasso.get()
                .load(photoPath)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                EventHistoryDetailFragment w = new EventHistoryDetailFragment();
                activity. getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, w)
                        .addToBackStack(null)
                        .commit();


            }
        });


    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, venue, date, duration;
        CardView cardView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.txt1);
            venue = itemView.findViewById(R.id.txt2);
            cardView = itemView.findViewById(R.id.c);
            date = itemView.findViewById(R.id.txt4);
            duration = itemView.findViewById(R.id.txt5);


        }
    }
}
