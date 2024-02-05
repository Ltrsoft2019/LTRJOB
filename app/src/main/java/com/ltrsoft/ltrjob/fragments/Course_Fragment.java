package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.Course_Adapter;
import com.ltrsoft.ltrjob.Adpter.EventCardAdapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Cources_Deo;
import com.ltrsoft.ltrjob.daoclasses.EventCard;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

import com.ltrsoft.ltrjob.pojoclass.Course_Class;
import com.ltrsoft.ltrjob.pojoclass.Event_class;

import java.util.ArrayList;

public class Course_Fragment extends Fragment {
    RecyclerView recyclerView;
    private SearchView searchView;
    public Course_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_course, container, false);

        recyclerView=view.findViewById(R.id.recycleview);

        Cources_Deo eventCard=new Cources_Deo();
        eventCard.fetchCources(requireContext(), recyclerView, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Course_Class> list = (ArrayList<Course_Class>)object;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Course_Adapter adapter = new Course_Adapter(list);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);


            }
        @Override
        public void userError(String error) {
            Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();

        }
    });
        return view;
    }
}