package com.ltrsoft.ltrjob.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.CourseCardHistoryAdapter;

import com.ltrsoft.ltrjob.Adpter.JobHistoryAdapter;
import com.ltrsoft.ltrjob.R;

import com.ltrsoft.ltrjob.daoclasses.Cources_Deo;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;
import com.ltrsoft.ltrjob.pojoclass.job;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    Button job, course;
    RecyclerView recyclerView;

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        job = view.findViewById(R.id.jobheostry);
        course = view.findViewById(R.id.corceheostry);
        recyclerView = view.findViewById(R.id.jobhesotry);

        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobDashboard jobDashboard = new JobDashboard();
                jobDashboard.geteuser(requireContext(), recyclerView, new UserCallBack() {

                    @Override
                    public void userSuccess(Object object1) {
                        Toast.makeText(getContext(), "in success", Toast.LENGTH_SHORT).show();
                        ArrayList<job> list1 = (ArrayList<job>) object1;
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                        JobHistoryAdapter adapter1 = new JobHistoryAdapter(list1);
                        recyclerView.setLayoutManager(layoutManager1);
                        recyclerView.setAdapter(adapter1);
                    }

                    @Override
                    public void userError(String error) {
                        Toast.makeText(getContext(), "error " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cources_Deo courses = new Cources_Deo();
                courses.getcorces(requireContext() , recyclerView, new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        ArrayList<Course_Class> courseList = (ArrayList<Course_Class>) object;
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        CourseCardHistoryAdapter adapter = new CourseCardHistoryAdapter(courseList);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void userError(String error) {
                        Toast.makeText(getContext(), "error " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
