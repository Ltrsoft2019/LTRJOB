package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

public class JobDetail extends Fragment {

    private Button com,jobDis;
        public JobDetail(){
            // Required empty public constructor
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_detail, container, false);

        com = view.findViewById(R.id.com);
        jobDis = view.findViewById(R.id.jobDis);

        getFragmentManager().beginTransaction().add(R.id.frag, new Job_desc()).addToBackStack(null).commit();


        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frag, new Company_desc()).addToBackStack(null).commit();

            }
        });

        jobDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frag, new Job_desc()).addToBackStack(null).commit();

            }
        });


        // Retrieve arguments
//        Bundle args = getArguments();
//        if (args != null) {
//            String companyName = args.getString("company_name", "");
//            String companyEmail = args.getString("company_email", "");
//            String jobDescription = args.getString("job_description", "");
//            String companyPhone = args.getString("company_phone", "");
//            String jobPosition = args.getString("job_position", "");
//            String companyHoAddress = args.getString("company_hoaddress", "");
//            String jobCategoryName = args.getString("job_category_name", "");
//            String jobSalary = args.getString("job_salary", "");
//            String companyId = args.getString("company_id", "");
//            String companyLogo = args.getString("company_logo", "");

//            TextView companyNameTextView = view.findViewById(R.id.company_name_textview);
//            companyNameTextView.setText(companyName);
//
//            // If you want to load an image using Picasso, for example
//            ImageView companyLogoImageView = view.findViewById(R.id.company_logo_imageview);
//            String imgurl = "https://institute.ltr-soft.com/company_details/" + companyLogo;
//            Picasso.get().load(imgurl).into(companyLogoImageView);
//        }

        return view;
    }
}
