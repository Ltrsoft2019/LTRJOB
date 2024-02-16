package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

public class NewsDetail extends Fragment {


    public NewsDetail() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view= inflater.inflate(R.layout.fragment_news_detail, container, false);


        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString("company_name");
            String description = args.getString("company_email");
            String date = args.getString("job_description");
            String resource = args.getString("company_phone");

            String photoPath = args.getString("job_position");

            TextView titleTextView = view.findViewById(R.id.title);
            titleTextView.setText(title);

            TextView descriptionTextView = view.findViewById(R.id.des);
            descriptionTextView.setText(description);

            TextView dateTextView = view.findViewById(R.id.date);
            dateTextView.setText(date);

            TextView resourceTextView = view.findViewById(R.id.resource);
            resourceTextView.setText(resource);

            ImageView photoImageView = view.findViewById(R.id.photo);

            String imgurl = "https://institute.ltr-soft.com/company_details/"+photoPath;
            Picasso.get().load(imgurl).into(photoImageView);
        }





        return view;
    }
}