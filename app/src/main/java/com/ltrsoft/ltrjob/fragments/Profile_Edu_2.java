package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Qualification;

public class Profile_Edu_2 extends Fragment {

    private EditText school_name,percentage10th,select_board;
    private Spinner select_10th_pass;
    private Button save;


    public Profile_Edu_2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile__edu_2, container, false);

        school_name=view.findViewById(R.id.school_name);
        percentage10th=view.findViewById(R.id.percentage10th);
        select_board = view.findViewById(R.id.select_10th_board);
        save= view.findViewById(R.id.save);
        


                return view;
    }
}