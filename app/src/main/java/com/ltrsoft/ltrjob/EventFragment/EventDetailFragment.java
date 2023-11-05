package com.ltrsoft.ltrjob.EventFragment;

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
    private TextView duration, eventname, guest, vanue, date, time;
    private TextView description;

    private ImageView imageView;


    private Button button;

    public EventDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.eventdetailfragment, container, false);
        Toast.makeText(getActivity(), "event  detail", Toast.LENGTH_SHORT).show();
        eventname = v.findViewById(R.id.name);
        description = v.findViewById(R.id.eventdescription);
        duration = v.findViewById(R.id.eventd);
        guest = v.findViewById(R.id.eventguest);
        vanue = v.findViewById(R.id.eventvenue);
        date = v.findViewById(R.id.eventdate);
        time = v.findViewById(R.id.eventtime);

        button = v.findViewById(R.id.button);

        imageView = v.findViewById(R.id.imageView1);


        Bundle bundle = getArguments();
        eventname.setText(bundle.getString("nameee"));
        description.setText(bundle.getString("desccription"));

        duration.setText(bundle.getString("duration"));
        guest.setText(bundle.getString("guest"));
        vanue.setText(bundle.getString("vanue"));
        date.setText(bundle.getString("date_time"));
        time.setText(bundle.getString("time"));


        if (bundle != null) {
            String imageUrl = bundle.getString("imag");


            ImageView eventImageView = v.findViewById(R.id.imageView1);

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

