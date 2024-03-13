package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.job;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class JobHistoryDetail extends Fragment {
    private TextView company_name,job_type,job_role;
    private TextView location,eligible,skill,desc;
    private TextView contact_email,contact,com_location,com_desc;
    private ImageView company_logo;
    private job job;
    private String companyId;
    ArrayList<job>list;
    ArrayList<job> experiences1;
    AppCompatButton appCompatButton;


    public JobHistoryDetail() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_job_history_detail, container, false);

        company_logo = view.findViewById(R.id.company_logo);
        job_type = view.findViewById(R.id.job_type);
        company_name = view.findViewById(R.id.company_name);
        job_role = view.findViewById(R.id.job_role);


        desc = view.findViewById(R.id.desc);
        eligible = view.findViewById(R.id.eligible);
        skill = view.findViewById(R.id.skill);
        location = view.findViewById(R.id.location);

        com_desc = view.findViewById(R.id.com_desc);
        contact_email = view.findViewById(R.id.contact_email);
        contact = view.findViewById(R.id.contact);
        com_location = view.findViewById(R.id.com_location);


        Bundle args = getArguments();
        if (args != null) {
            String companyName = args.getString("company_name", "");
            String companyEmail = args.getString("company_email", "");
            String jobDescription = args.getString("job_description", "");
            String companyPhone = args.getString("company_phone", "");
            String jobPosition = args.getString("job_position", "");
            String companyHoAddress = args.getString("company_hoaddress", "");
            String jobCategoryName = args.getString("job_category_name", "");
            String jobSalary = args.getString("job_salary", "");
            companyId = args.getString("company_id", "");
            String companyLogo = args.getString("company_logo", "");

            company_name.setText(companyName);
            job_role.setText(jobPosition);
            job_type.setText(jobCategoryName);

//            // If you want to load an image using Picasso, for example
            String imgurl = "https://institute.ltr-soft.com/company_details/"+companyLogo;
            Picasso.get().load(imgurl).into(company_logo);
        }



        JobDashboard jobDashboard = new JobDashboard();

        jobDashboard.geteuser(getContext(), companyId, new UserCallBack() {
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

                    com_desc.setText(job1.getJob_description());
                    contact.setText(job1.getCompany_phone());
                    com_location.setText(job1.getCompany_hoaddress());
                    contact_email.setText(job1.getCompany_email());

                }
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "error "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}