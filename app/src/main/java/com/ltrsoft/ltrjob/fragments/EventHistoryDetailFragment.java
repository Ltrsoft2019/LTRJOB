package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;


public class EventHistoryDetailFragment extends Fragment {
    private TextView duration1, eventname1, guest1, vanue1, date1, time1;
    private TextView description1;

    private ImageView imageView1,back;

    public EventHistoryDetailFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_event_history_detail, container, false);
        eventname1 = v.findViewById(R.id.name);
        description1 = v.findViewById(R.id.discription);
        duration1 = v.findViewById(R.id.duration);
        guest1 = v.findViewById(R.id.guest);
        vanue1 = v.findViewById(R.id.discription1);
        date1 = v.findViewById(R.id.date);
        time1 = v.findViewById(R.id.time);


        imageView1 = v.findViewById(R.id.img);
        back = v.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                getFragmentManager().beginTransaction().replace(R.id.container,dashboardFragment).commit();
            }
        });



        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString("nameee");
            String description = bundle.getString("description");
            String duration = bundle.getString("duration");
            String guest = bundle.getString("guest");
            String venue = bundle.getString("venue");
            String date_time = bundle.getString("date_time");


            eventname1.setText(name);
            description1.setText(description);
            duration1.setText(duration);
            guest1.setText(guest);
            vanue1.setText(venue);
            time1.setText(date_time);






        }



        if (bundle != null) {
            String imageUrl = bundle.getString("imag");


            ImageView eventImageView = v.findViewById(R.id.img);

            if (imageUrl != null) {
                Picasso.get().load(imageUrl).into(eventImageView);
            }
        }







        return v;
    }
}