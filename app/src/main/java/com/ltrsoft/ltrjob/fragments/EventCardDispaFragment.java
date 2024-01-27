package com.ltrsoft.ltrjob.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.Adpter.EventCardAdapter;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.EventCard;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Event_class;

import java.util.ArrayList;
import java.util.List;

public class EventCardDispaFragment extends Fragment {
    RecyclerView recyclerView;
    private SearchView searchView;
    TextView t;
    EventCardAdapter myAdapter;
    List<Event_class> imglist;
    Event_class modelImage;
    LinearLayoutManager manager;
    String date;
    String time;
//    String url = "http://job.ltr-soft.com/Event/event_photo.php";

    public EventCardDispaFragment(){}

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.eventcarddisplayfragment,container,false);
        Toast.makeText(getActivity(), "event card display", Toast.LENGTH_SHORT).show();


        recyclerView = v.findViewById(R.id.recycleview);


        EventCard eventCard=new EventCard();
        eventCard.fetchEventData(requireContext(), recyclerView, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Event_class> list = (ArrayList<Event_class>)object;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                EventCardAdapter adapter = new EventCardAdapter(list);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

//Event_class eventClass = (Event_class) object;
//t.setText(eventClass.getEvent_name());

            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
