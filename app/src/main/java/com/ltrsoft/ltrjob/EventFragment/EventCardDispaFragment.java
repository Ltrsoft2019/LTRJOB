package com.ltrsoft.ltrjob.EventFragment;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.Adapters.EventCardAdapter;
import com.ltrsoft.ltrjob.Classes.Event_class;
import com.ltrsoft.ltrjob.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    String url = "http://job.ltr-soft.com/Event/event_photo.php";
    // String url = "http://job.ltr-soft.com/Event/event_read.php";
    public EventCardDispaFragment(){}

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.eventcarddisplayfragment,container,false);
        Toast.makeText(getActivity(), "event card display", Toast.LENGTH_SHORT).show();

        // Initialize the RecyclerView
        recyclerView = v.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize imglist
        imglist = new ArrayList<>();


        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String id = jsonObject.getString("event_description");
                        String name = jsonObject.getString("event_name");
                        String guest = jsonObject.getString("event_guest");
                        String venue = jsonObject.getString("event_venue");
                        String date_time = jsonObject.getString("event_date_time");
                        String duration = jsonObject.getString("event_duration");
                        String path = jsonObject.getString("photo_path");
                        String imageurl = "https://institute.ltr-soft.com/event_photo/" + path;

                        //  Toast.makeText(getContext(), ""+url, Toast.LENGTH_SHORT).show();

                        String[] dateAndTime = date_time.split(" ");
                        date = dateAndTime[0];
                        time = dateAndTime[1];




                        //  modelImage = new Event_class(id, name, url, duration, guest, venue, date,time);

                        //  modelImage = new Event_class(eventname, event_description, url, event_guest, event_venue, event_date_time,event_duration, date,time);

                        modelImage = new Event_class(id, name, imageurl, duration, guest, venue, date,time);
                        imglist.add(modelImage);

                        // Toast.makeText(getContext(), ""+imglist, Toast.LENGTH_SHORT).show();
                    }
                    myAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);




        // Initialize the adapter
        myAdapter = new EventCardAdapter(imglist);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(myAdapter);


        return v;
    }
}
