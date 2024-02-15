package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Batch_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Batch;

public class Course_Apply extends Fragment {
    String batch_id;
    public Course_Apply() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.course_apply, container, false);


        Bundle arg = getArguments();
        if (arg !=null){
            batch_id=arg.getString("batch_id");
        }

        Toast.makeText(getContext(), "batcj_id="+batch_id, Toast.LENGTH_SHORT).show();

        Batch batch=new Batch("batch-22","user-17","","","",
                "","","");

        Batch_Deo batchDeo = new Batch_Deo();
        batchDeo.createBatch(batch, "user-17", "batch-22", getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Toast.makeText(getContext(), ""+object.toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}