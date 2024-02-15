package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.ltrjob.Adpter.DashboardJobCardAdapter;

import com.ltrsoft.ltrjob.Adpter.NewAdpter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.daoclasses.News;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.NewsClass;
import com.ltrsoft.ltrjob.pojoclass.job;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;

    public NewsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news2, container, false);

        recyclerView = view.findViewById(R.id.recycleview1);
        News jobDashboard = new News();

        jobDashboard.getall(requireContext(), recyclerView, new UserCallBack() {
            @Override
            public void userSuccess(Object object1) {
                ArrayList<NewsClass> yourJobList = (ArrayList<NewsClass>) object1;
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                NewAdpter adapter1 = new NewAdpter(yourJobList);
                recyclerView.setLayoutManager(layoutManager1);
                recyclerView.setAdapter(adapter1);


            }

            @Override
            public void userError(String error) {

            }
        });
        return view;
    }
}