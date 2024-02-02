package com.ltrsoft.ltrjob.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.CertificationAdapter;
import com.ltrsoft.ltrjob.Adpter.DashboardJobCardAdapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Certificationdeo;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.job;

import java.util.ArrayList;

public class CertificationFragment extends Fragment {

private RecyclerView recyclerView;
    public CertificationFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_certification, container, false);


        recyclerView=view.findViewById(R.id.recycleview);


        Certificationdeo jobDashboard = new Certificationdeo();

        jobDashboard.getuser(requireActivity(), recyclerView, new UserCallBack() {
            @Override
            public void userSuccess(Object object1) {
                ArrayList<Certification> list1 = (ArrayList<Certification>) object1;
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                CertificationAdapter adapter1 = new CertificationAdapter(list1);
                recyclerView.setLayoutManager(layoutManager1);
                recyclerView.setAdapter(adapter1);



            }

            @Override
            public void userError(String error) {
                // Handle error for the second RecyclerView, if needed
            }
        });




        return view;
    }
}