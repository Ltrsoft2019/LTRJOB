package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Company_Details_Deo;
import com.ltrsoft.ltrjob.daoclasses.JobDashboard;
import com.ltrsoft.ltrjob.daoclasses.user_projectDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Company_Details;
import com.ltrsoft.ltrjob.pojoclass.job;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class  JobDetail extends Fragment {
    private TextView company_name,job_type,job_role;
    private TextView location,eligible,skill,desc;
    private TextView contact_email,contact,com_location,com_desc;
    private ImageView company_logo;
    private job job;
    private String companyId;
    ArrayList<job>list;
    ArrayList<job> experiences1;
    AppCompatButton appCompatButton;

    public JobDetail(){
            // Required empty public constructor
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_detail, container, false);

//        com = view.findViewById(R.id.com);
//        jobDis = view.findViewById(R.id.jobDis);
        company_logo = view.findViewById(R.id.company_logo);
        job_type = view.findViewById(R.id.job_type);
        company_name = view.findViewById(R.id.company_name);
        job_role = view.findViewById(R.id.job_role);
        appCompatButton=view.findViewById(R.id.submitt);

        desc = view.findViewById(R.id.desc);
        eligible = view.findViewById(R.id.eligible);
        skill = view.findViewById(R.id.skill);
        location = view.findViewById(R.id.location);

        com_desc = view.findViewById(R.id.com_desc);
        contact_email = view.findViewById(R.id.contact_email);
        contact = view.findViewById(R.id.contact);
        com_location = view.findViewById(R.id.com_location);






//        getFragmentManager().beginTransaction().add(R.id.frag, new Job_desc()).commit();

//        Bundle bundle = getArguments();
//        if (!bundle.isEmpty()){
//            cmpid = bundle.getString("company_id");
//            System.out.println("compid = "+cmpid);
//            JobDashboard jobDashboard = new JobDashboard();
//            jobDashboard.geteuser(getContext(), cmpid, new UserCallBack() {
//                @Override
//                public void userSuccess(Object object) {
//                    list = (ArrayList<job>) object;
//                     job = list.get(0);
//
//                     company_name.setText(job.getCompany_name());
//                     job_type.setText(job.getJob_category_name());
//                     job_role.setText(job.getJob_position());
//
//                }
//
//                @Override
//                public void userError(String error) {
//
//                }
//            });
//        }





//        com.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Company_desc companyDesc = new Company_desc();
//                Bundle bundle1 = new Bundle();
//                bundle1.putString("company_id", job.getCompany_id());
//                companyDesc.setArguments(bundle1);
////                getFragmentManager().beginTransaction().replace(R.id.frag,companyDesc).commit();
//
//            }
//        });
//
//        jobDis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Job_desc job_desc  = new Job_desc();
//                Bundle bundle2 = new Bundle();
//                bundle2.putString("JObClass", job.getCompany_id());
//                job_desc.setArguments(bundle2);
////                getFragmentManager().beginTransaction().replace(R.id.frag, job_desc).commit();
//
//            }
//        });

//         Retrieve arguments
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

            appCompatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    JobDashboard awardDeo=new JobDashboard();
                    awardDeo.create( requireContext(), new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {
                            Toast.makeText(getContext(), "job applied  Successfully"+object.toString(), Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void userError(String error) {
                            userError(error.toString());

                        }
                    });

                }
            });

        return view;
    }
}
