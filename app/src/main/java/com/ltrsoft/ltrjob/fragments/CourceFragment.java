package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.CourseCardAdapter;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Cources_Deo;

import com.ltrsoft.ltrjob.interfaces.UserCallBack;

import com.ltrsoft.ltrjob.pojoclass.Course_Class;


import java.util.ArrayList;


public class CourceFragment extends Fragment {

    private ImageView back;

    public CourceFragment() {

    }

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cource, container, false);

        recyclerView = view.findViewById(R.id.fragment_recycler_courses);
        back = view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                getFragmentManager().beginTransaction().replace(R.id.container1,dashboardFragment).commit();
            }
        });

        Cources_Deo  eventCard = new Cources_Deo();
        eventCard.fetchCources(requireContext(), recyclerView, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Course_Class> list = (ArrayList<Course_Class>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                CourseCardAdapter adapter = new CourseCardAdapter(list);
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