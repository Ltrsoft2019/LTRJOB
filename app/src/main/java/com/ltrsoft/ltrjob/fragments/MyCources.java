package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.Course_Adapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Cources_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;

import java.util.ArrayList;


public class MyCources extends Fragment {

    public RecyclerView recyclview;
    public MyCources() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_cources, container, false);

        recyclview=view.findViewById(R.id.recycle);

        Cources_Deo eventCard=new Cources_Deo();
        eventCard.fetchCources(requireContext(), recyclview, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Course_Class> list = (ArrayList<Course_Class>)object;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Course_Adapter adapter = new Course_Adapter(list);
                recyclview.setLayoutManager(layoutManager);
                recyclview.setAdapter(adapter);


            }
            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();

            }
        });




        return view;
    }
}