package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.User;
import com.ltrsoft.ltrjob.pojoclass.job;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import kotlinx.coroutines.Job;

public class Job_desc extends Fragment {
    private TextView location,eligible,skill,desc;
    private  static String company_id;
    public Job_desc() {
        // Required empty public constructor
    }
    ArrayList<job> experiences1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.job_desc, container, false);

        location = view.findViewById(R.id.location);
        eligible = view.findViewById(R.id.eligible);
        skill = view.findViewById(R.id.skill);
        desc = view.findViewById(R.id.desc);

        Bundle args = getArguments();

        if (args != null) {
             company_id = args.getString("company_id","");

            JobDashboard jobDashboard = new JobDashboard();

            jobDashboard.geteuser(getContext(), company_id, new UserCallBack() {
                @Override
                public void userSuccess(Object obj) {
                experiences1= (ArrayList<job>) obj;
                    Toast.makeText(getContext(), "size = "+experiences1.size(), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i <experiences1.size() ; i++) {
                        job job1 = experiences1.get(i);
                        desc.setText(job1.getJob_description());
                        eligible.setText(job1.getJob_category_name());
                        location.setText(job1.getCompany_hoaddress());
                        skill.setText(job1.getJob_position());

                    }
                }

                @Override
                public void userError(String error) {
                    Toast.makeText(getContext(), "error "+error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }




        return view;
    }
}