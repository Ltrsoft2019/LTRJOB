package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

public class EventDetailFragment extends Fragment {
    private TextView duration1, eventname1, guest1, vanue1, date1, time1;
    private TextView description1;

    private ImageView imageView1;


    private Button button;

    public EventDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.eventdetailfragment, container, false);
        Toast.makeText(getActivity(), "event  detail", Toast.LENGTH_SHORT).show();


        eventname1 = v.findViewById(R.id.name);
        description1 = v.findViewById(R.id.discription);
        duration1 = v.findViewById(R.id.duration);
        guest1 = v.findViewById(R.id.guest);
        vanue1 = v.findViewById(R.id.discription1);
        date1 = v.findViewById(R.id.date);
        time1 = v.findViewById(R.id.time);

        button = v.findViewById(R.id.loginButton);

        imageView1 = v.findViewById(R.id.img);


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


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "joined succssfully", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }
}

