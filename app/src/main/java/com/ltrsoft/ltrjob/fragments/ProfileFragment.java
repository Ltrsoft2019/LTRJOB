package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.Adpter.AwardAdapter;
import com.ltrsoft.ltrjob.Adpter.CertificationAdapter;

import com.ltrsoft.ltrjob.Adpter.ProjectAdapter;
import com.ltrsoft.ltrjob.Adpter.QualificationAdpter;
import com.ltrsoft.ltrjob.Adpter.ResearchPaperAdapter;
import com.ltrsoft.ltrjob.Adpter.TechnicalSkillAdapter;
import com.ltrsoft.ltrjob.Adpter.WorkshopAdapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Award_Deo;
import com.ltrsoft.ltrjob.daoclasses.Certificationdeo;
import com.ltrsoft.ltrjob.daoclasses.Resume;
import com.ltrsoft.ltrjob.daoclasses.Workshop_Deo;
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.daoclasses.research_paperDeo;
import com.ltrsoft.ltrjob.daoclasses.technical_skilldeo;
import com.ltrsoft.ltrjob.daoclasses.user_projectDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.Project;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.pojoclass.Workshop;
import com.ltrsoft.ltrjob.utils.Screen_Size;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileFragment extends Fragment {
    private RecyclerView skills;
    private RecyclerView education;
    private RecyclerView certification;
    private RecyclerView project;
    private RecyclerView recognization;
    private RecyclerView reasearchpaperrecycle;
    private RecyclerView workshop;
    private ArrayList<HashMap<Integer,String >> maplist1;
    private ImageView back;
    TableLayout table;
    private TextView skill_txt,education_txt,project_txt,
            certification_txt,recognization_txt,rearchpapperreycle_txt,workshop_txt;

    int screenwidth;
    int screenheight;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        skills = view.findViewById(R.id.skill);
        education = view.findViewById(R.id.qualification);
        certification = view.findViewById(R.id.certification);
        project=view.findViewById(R.id.project1);
        recognization=view.findViewById(R.id.recognization);
        reasearchpaperrecycle =view.findViewById(R.id.rearchpapperreycleview);
        workshop=view.findViewById(R.id.workhoprecycle);

        skill_txt = view.findViewById(R.id.skill_txt);
        education_txt = view.findViewById(R.id.education_txt);
        project_txt = view.findViewById(R.id.project_txt);
        certification_txt = view.findViewById(R.id.certification_txt);
        recognization_txt = view.findViewById(R.id.recognization_txt);
        rearchpapperreycle_txt = view.findViewById(R.id.rearchpapperreycle_txt);
        workshop_txt = view.findViewById(R.id.workshop_txt);
        table= view.findViewById(R.id.table);
        back = view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                getFragmentManager().beginTransaction().replace(R.id.constraint,navigationDrawerFragment).commit();
            }
        });

        TextView name = view.findViewById(R.id.name);
        ImageView profile = view.findViewById(R.id.profile);
        Resume resume = new Resume();

        resume.getall(getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        Object[] objects = (Object[]) object;
                        Userclass user = (Userclass) objects[0];

//                String profile= user.getUser_photo();
//                String name = user.getUser_fname();

                        name.setText(user.getUser_fname());
                        String imgUrl = "https://institute.ltr-soft.com/company_details/" + user.getUser_photo();
                        Picasso.get().load(imgUrl).into(profile);

                    }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Errror"+error, Toast.LENGTH_SHORT).show();
            }
        });



        skills.setVisibility(View.INVISIBLE);
        education.setVisibility(View.INVISIBLE);
        project.setVisibility(View.INVISIBLE);
        certification.setVisibility(View.INVISIBLE);
        recognization.setVisibility(View.INVISIBLE);
        reasearchpaperrecycle.setVisibility(View.INVISIBLE);
        workshop.setVisibility(View.INVISIBLE);
        table.setVisibility(View.INVISIBLE);

        skill_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skills.setVisibility(skills.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
        education_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                education.setVisibility(education.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                table.setVisibility(table.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
        project_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                project.setVisibility(project.getVisibility()==View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
        certification_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                certification.setVisibility(certification.getVisibility()==View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
        recognization_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recognization.setVisibility(recognization.getVisibility()==View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
        rearchpapperreycle_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reasearchpaperrecycle.setVisibility(reasearchpaperrecycle.getVisibility()==View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
        workshop_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workshop.setVisibility(workshop.getVisibility()==View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });

        technical_skilldeo technicalSkilldeo = new technical_skilldeo();
        technicalSkilldeo.fatchtechnicalskill(requireContext(), skills, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Technical_Skill> list = (ArrayList<Technical_Skill>) object;
                GridLayoutManager gridLayout = new GridLayoutManager(getContext(),2);
                TechnicalSkillAdapter adapter = new TechnicalSkillAdapter(list);
                skills.setLayoutManager(gridLayout);
                skills.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });


        qualificationDeo technicalSkilldeo1 = new qualificationDeo();
        technicalSkilldeo1.fatchtqualification(requireContext(), education, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Qualification> list = (ArrayList<Qualification>) object;
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




        user_projectDeo certificationdeo1 = new user_projectDeo();
        certificationdeo1.getalluserproject(requireContext(), project, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Project> list = (ArrayList<Project>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                ProjectAdapter adapter = new ProjectAdapter(list);
                project.setLayoutManager(layoutManager);
                project.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });


        Award_Deo awardDeo = new Award_Deo();
        awardDeo.getalluserAward(requireContext(), recognization, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Award> list = (ArrayList<Award>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                AwardAdapter adapter = new AwardAdapter(list);
                recognization.setLayoutManager(layoutManager);
                recognization.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });




        research_paperDeo research_paperDeo = new research_paperDeo();
        research_paperDeo.getallusereachd(requireContext(), reasearchpaperrecycle, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Research_Paper> list = (ArrayList<Research_Paper>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                ResearchPaperAdapter adapter = new ResearchPaperAdapter(list);
                reasearchpaperrecycle.setLayoutManager(layoutManager);
                reasearchpaperrecycle.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });


        Workshop_Deo workshop_deo = new Workshop_Deo();
        workshop_deo.getalluserAward(requireContext(), workshop,new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Workshop> list = (ArrayList<Workshop>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                WorkshopAdapter adapter = new WorkshopAdapter(list);
                workshop.setLayoutManager(layoutManager);
                workshop.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
}
}
