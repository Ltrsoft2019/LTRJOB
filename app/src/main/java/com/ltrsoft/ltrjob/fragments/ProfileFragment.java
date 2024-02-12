package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.CertificationAdapter;

import com.ltrsoft.ltrjob.Adpter.ProjectAdapter;
import com.ltrsoft.ltrjob.Adpter.QualificationAdpter;
import com.ltrsoft.ltrjob.Adpter.TechnicalSkillAdapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Award_Deo;
import com.ltrsoft.ltrjob.daoclasses.Certificationdeo;
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.daoclasses.technical_skilldeo;
import com.ltrsoft.ltrjob.daoclasses.user_projectDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.Project;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private RecyclerView skills, education, certification,project,recognization;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
       recognization=view.findViewById(R.id.recognization);
        skills = view.findViewById(R.id.skill);
        education = view.findViewById(R.id.qualification);
        certification = view.findViewById(R.id.project);
        project=view.findViewById(R.id.project1);


        technical_skilldeo technicalSkilldeo = new technical_skilldeo();
        technicalSkilldeo.fatchtechnicalskill(requireContext(), skills, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Technical_Skill> list = (ArrayList<Technical_Skill>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                TechnicalSkillAdapter adapter = new TechnicalSkillAdapter(list);
                skills.setLayoutManager(layoutManager);
                skills.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });


        qualificationDeo qualificationDeo = new qualificationDeo();
        qualificationDeo.fatchtqualification(requireContext(), education, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Qualification> list = (ArrayList<Qualification>) object;
                Toast.makeText(getContext(), "skill " + list.size(), Toast.LENGTH_SHORT).show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                QualificationAdpter adapter = new QualificationAdpter(list);
                education.setLayoutManager(layoutManager);
                education.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {


                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });



        Certificationdeo certificationdeo = new Certificationdeo();
        certificationdeo.getuser(requireContext(), certification, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Certification> list = (ArrayList<Certification>) object;
                Toast.makeText(getContext(), "certification " + list.size(), Toast.LENGTH_SHORT).show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                CertificationAdapter adapter = new CertificationAdapter(list);
                certification.setLayoutManager(layoutManager);
                certification.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });





        user_projectDeo userProjectDeo = new user_projectDeo();
        userProjectDeo.getalluserproject(requireContext(), project, new UserCallBack() {


            public void userSuccess(Object object) {
                ArrayList<Project> projectArrayList = (ArrayList<Project>) object;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                ProjectAdapter adapter = new ProjectAdapter(projectArrayList);
                project.setLayoutManager(layoutManager);
                project.setAdapter(adapter);

            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });




        Award_Deo awardDeo = new Award_Deo();
        awardDeo.getalluserAward(requireContext(), recognization,new UserCallBack() {
            public void userSuccess(Object object) {
                ArrayList<Award> awards = (ArrayList<Award>) object;

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                ProjectAdapter adapter = new ProjectAdapter(awards);
                recognization.setLayoutManager(layoutManager);
                recognization.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}