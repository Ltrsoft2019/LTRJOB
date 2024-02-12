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
import com.ltrsoft.ltrjob.pojoclass.job;

import java.util.ArrayList;

public class Company_desc extends Fragment {
private TextView desc,location,contact,contact_email;
    ArrayList<job> experiences1;

    public Company_desc() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.company_desc, container, false);

        desc=view.findViewById(R.id.desc);
        location = view.findViewById(R.id.location);
        contact = view.findViewById(R.id.contact);
        contact_email = view.findViewById(R.id.contact_email);


        Bundle args = getArguments();

        if (args != null) {
            String company_id = args.getString("JObClas","");

            JobDashboard jobDashboard = new JobDashboard();

            jobDashboard.geteuser(getContext(), company_id, new UserCallBack() {
                @Override
                public void userSuccess(Object obj) {
                    experiences1= (ArrayList<job>) obj;
                    Toast.makeText(getContext(), "size = "+experiences1.size(), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i <experiences1.size() ; i++) {
                        job job1 = experiences1.get(i);
                        desc.setText(job1.getJob_description());
                        contact.setText(job1.getCompany_phone());
                        location.setText(job1.getCompany_hoaddress());
                        contact_email.setText(job1.getCompany_email());

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