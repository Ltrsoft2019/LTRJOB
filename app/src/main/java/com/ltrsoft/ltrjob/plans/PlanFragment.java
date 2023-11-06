package com.ltrsoft.ltrjob.plans;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.ltrjob.Adapters.PlanAdapter;
import com.ltrsoft.ltrjob.Classes.PlanClass;
import com.ltrsoft.ltrjob.R;

import java.util.ArrayList;

public class PlanFragment extends Fragment {
    public PlanFragment() {
        // Required empty public constructor
    }
    public RecyclerView planrecycler;
    public PlanAdapter adapter;
    public ArrayList <PlanClass> listofplan = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_fragment, container, false);
        planrecycler = view.findViewById(R.id.plan_recycler);
        listofplan.add(new PlanClass("100 Rs per Month","" +
                "1.  you can Access All course","Basic"));
        listofplan.add(new PlanClass("250 Rs per Month","1.  you can Access All course \n2.  You can practice Exam","Medium"));
        listofplan.add(new PlanClass("440 Rs per Month","1.  you can Access All course \n2.  You can practice Exam \n3.  No Adds\n4.  You can Attend Any Event and Compettion ","Premium"));

        adapter = new PlanAdapter(listofplan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        planrecycler.setLayoutManager(layoutManager);
        planrecycler.setAdapter(adapter);

        return view;
    }
}