package com.ltrsoft.ltrjob.CompanyJobFragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

public class JobDeatilFragment extends Fragment {
    public JobDeatilFragment(){

    }
    public Button jobdetail,companydetail;
    public LinearLayout job_layout,company_layout;
    public TextView jobview_apply_date,jobview_position,jobview_company;
    public ImageView company_logo1;
    TextView job_desc,job_req_skill,job_eligible,job_location;
    TextView company_desc,company_location,company_contact;
    public Button apply_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.jobdetailfragment,container,false);
        Toast.makeText(getActivity(), " job detail", Toast.LENGTH_SHORT).show();
        apply_btn = v.findViewById(R.id.apply_btn);

        companydetail=v.findViewById(R.id.company_detail);
        jobdetail = v.findViewById(R.id.job_detail);
        job_layout = v.findViewById(R.id.job_layout);
        company_layout = v.findViewById(R.id.company_layout);

        company_logo1 = v.findViewById(R.id.company_logo);
        jobview_apply_date = v.findViewById(R.id.jobview_apply_date);
        jobview_position = v.findViewById(R.id.jobview_position);
        jobview_company = v.findViewById(R.id.jobview_company);

        job_desc = v.findViewById(R.id.jobview_desc);
        job_req_skill = v.findViewById(R.id.requrements);
        job_eligible = v.findViewById(R.id.jobview_criteria);
        job_location = v.findViewById(R.id.jobview_location);

        company_desc = v.findViewById(R.id.jobview_criteria);
        company_location = v.findViewById(R.id.jobview_criteria);
        company_contact = v.findViewById(R.id.jobview_criteria);

        int color1 = Color.parseColor("#FF000000");
        companydetail.setTextColor(color1);
        int color2 = Color.parseColor("#00D084");
        jobdetail.setTextColor(color2);

        companydetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companydetail.setTextColor(color2);
                jobdetail.setTextColor(color1);
                job_layout.setVisibility(View.GONE);
                company_layout.setVisibility(View.VISIBLE);
            }
        });
        jobdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companydetail.setTextColor(color1);
                jobdetail.setTextColor(color2);
                job_layout.setVisibility(View.VISIBLE);
                company_layout.setVisibility(View.GONE);
            }
        });

        Bundle bundle =getArguments();
        String job_category_id= bundle.getString("job_category_id");
        String job_position= bundle.getString("job_position");
        String company_name= bundle.getString("company_name");
        String company_logo= bundle.getString("company_logo");
        System.out.println("logo = "+company_logo);
        String created_at= bundle.getString("created_at");
        String job_description= bundle.getString("job_description");
        String job_start_date_to_apply= bundle.getString("job_start_date_to_apply");
        String job_criteria_to_apply= bundle.getString("job_criteria_to_apply");
        String job_end_date_to_apply= bundle.getString("job_end_date_to_apply");
        String job_website_to_apply= bundle.getString("job_website_to_apply");
        String company_phone= bundle.getString("company_phone");
        String company_domain= bundle.getString("company_domain");
        String company_hoaddress= bundle.getString("company_hoaddress");
        String city = bundle.getString("city_name");
        System.out.println("company hoa address"+company_hoaddress);

        String imgurl = "https://institute.ltr-soft.com/company_details/"+company_logo;
        Picasso.get().load(imgurl).into(company_logo1);
        jobview_apply_date.setText("End date to apply :\n"+job_end_date_to_apply);
        jobview_position.setText(job_position);

        job_desc.setText(job_description);
        job_location.setText(city);
        job_eligible.setText(job_criteria_to_apply);
        job_req_skill.setText("API,J2EE,Django");
        jobview_company.setText(company_name);

        company_desc.setText(company_name+"\n"+company_domain);
        job_location.setText(company_hoaddress);
        company_contact.setText(company_phone);


        apply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String applyurl = comapny_domain;
            String applyurl = "https://careers.wipro.com/state";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(applyurl)));
                startActivity(i);
            }
        });
        return v;
    }
}
