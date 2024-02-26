package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Award_Deo;
import com.ltrsoft.ltrjob.daoclasses.user_projectDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class ProjectUpdate extends Fragment {
private EditText projectname,startdate,enddate,technology,description,categery;
Button button;
    public ProjectUpdate() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_project_update, container, false);
       projectname=view.findViewById(R.id.pname);
       startdate=view.findViewById(R.id.sdate);
       enddate=view.findViewById(R.id.edate);
       technology=view.findViewById(R.id.technology);
       description=view.findViewById(R.id.des);
       categery=view.findViewById(R.id.categery);
       button=view.findViewById(R.id.updateproject);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               user_projectDeo awardDeo=new user_projectDeo();
               awardDeo.updateusertechnicalskill(projectname.toString(), startdate.toString(), enddate.toString(), categery.toString(), description.toString(),technology.toString(), requireContext(), new UserCallBack() {
                   @Override
                   public void userSuccess(Object object) {
                       Toast.makeText(getContext(), "Project Updated Successfully"+object.toString(), Toast.LENGTH_SHORT).show();


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