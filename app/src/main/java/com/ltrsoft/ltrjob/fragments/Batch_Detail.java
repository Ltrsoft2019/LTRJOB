package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.Batch_card_adapter;
import com.ltrsoft.ltrjob.Adpter.Course_Adapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Batch_Deo;
import com.ltrsoft.ltrjob.daoclasses.Cources_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Batch;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;

import java.util.ArrayList;

public class Batch_Detail extends Fragment {
        private RecyclerView recyclerView;
    String course_id;
    public Batch_Detail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.batch__detail, container, false);
        recyclerView = view.findViewById(R.id.recycle);

        Bundle args = getArguments();
        if (args != null) {
             course_id = args.getString("course_id");
            Toast.makeText(getContext(), ""+course_id.toString(), Toast.LENGTH_SHORT).show();
        }

        Batch_Deo batchDeo=new Batch_Deo();
        batchDeo.getBatch(course_id, getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Batch>list= (ArrayList<Batch>) object;
                Toast.makeText(getContext(), "size "+list.size(), Toast.LENGTH_SHORT).show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Batch_card_adapter adapter = new Batch_card_adapter(list);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);


//                AppCompatActivity activity=(AppCompatActivity)view.getContext();
//        Bundle args1 = new Bundle();
//        Toast.makeText(activity, "id"+course_id, Toast.LENGTH_SHORT).show();
//        args.putString("course_id", course_id);
//
//        CourseDetailFragment courseDetailFragment=new CourseDetailFragment();
//                courseDetailFragment.setArguments(args);
//
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,courseDetailFragment).addToBackStack(null).commit();
//
//
//
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "errror"+error, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}