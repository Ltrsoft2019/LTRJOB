package com.ltrsoft.ltrjob.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.Adpter.QualificationAdpter;
import com.ltrsoft.ltrjob.Adpter.ResearchPaperAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumeAwardAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumeCertificationAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumePatentAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumeResearch_Paper_Adapter;
import com.ltrsoft.ltrjob.Adpter.ResumeWorkshop_Adapter;
import com.ltrsoft.ltrjob.Adpter.TechnicalSkillAdapter;
import com.ltrsoft.ltrjob.PdfGenerator;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Resume;
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.daoclasses.research_paperDeo;
import com.ltrsoft.ltrjob.daoclasses.technical_skilldeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.Patent;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.pojoclass.Workshop;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ResumeFragment extends Fragment {

    private TextView education, work_exp, resumedetails, address, email, number, profession, name, git_hub, link_id;
    private ImageView download, profileimg, back;
    private RecyclerView recyclerViewCertifications, award_title, patents_recycler, Research_paper_recycler, workshop_recycler, skill_recycler, qualificationRecyclerView;
    private ArrayList<Certification> certifications;
    private ArrayList<Award> awards;
    private ArrayList<Patent> patents;
    private ArrayList<Research_Paper> research_paper;
    private ArrayList<HashMap<Integer, String>> maplist;
    private ArrayList<Workshop> workshops;
    private ArrayList<Technical_Skill> skills;
    private Resume resume;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 10;
    private static final String FILE_NAME = "RResume.png";
    private static final int NOTIFICATION_ID = 100;
    private static final String TAG = "ResumeFragment";
    Object[] objects2;
    private static final int PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    String nametxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        education = view.findViewById(R.id.qulification_txt);
        work_exp = view.findViewById(R.id.work_exp);
        resumedetails = view.findViewById(R.id.resumedetails);
        address = view.findViewById(R.id.address);
        email = view.findViewById(R.id.email);
        number = view.findViewById(R.id.no);
        name = view.findViewById(R.id.name);
        profileimg = view.findViewById(R.id.profileimg);
        download = view.findViewById(R.id.download);
        git_hub = view.findViewById(R.id.git_hub);
        link_id = view.findViewById(R.id.link_id);
        recyclerViewCertifications = view.findViewById(R.id.cer_title);
        award_title = view.findViewById(R.id.award_title);
        patents_recycler = view.findViewById(R.id.patents_recycler);
        Research_paper_recycler = view.findViewById(R.id.Research_paper_recycler);
        workshop_recycler = view.findViewById(R.id.workshop_recycler);
        skill_recycler = view.findViewById(R.id.skill_recycler);
        qualificationRecyclerView = view.findViewById(R.id.qualificationRecyclerView);
        back = view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                getFragmentManager().beginTransaction().replace(R.id.container1, dashboardFragment).commit();
            }
        });


        certifications = new ArrayList<>();
        awards = new ArrayList<>();
        research_paper = new ArrayList<>();
        workshops = new ArrayList<>();
        resume = new Resume();

        recyclerViewCertifications.setLayoutManager(new LinearLayoutManager(getContext()));
        award_title.setLayoutManager(new LinearLayoutManager(getContext()));
        patents_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        Research_paper_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        workshop_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        skill_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        qualificationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        resume.getall(requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object obj) {
                Object[] objects = (Object[]) obj;
                Userclass user = (Userclass) objects[0];

                name.setText(user.getUser_fname());
                email.setText(user.getUser_email());
                number.setText(user.getUser_smobile());
                address.setText(user.getUser_address());
                git_hub.setText(user.getUser_github_id());
                link_id.setText(user.getUser_linkedin_id());
                resumedetails.setText(user.getUser_carier_objective());

                 nametxt=user.getUser_fname();

                String imgUrl = "https://institute.ltr-soft.com/company_details/" + user.getUser_photo();
                Picasso.get().load(imgUrl).into(profileimg);

                certifications = (ArrayList<Certification>) objects[2];
                ResumeCertificationAdapter certificationAdapter = new ResumeCertificationAdapter(getContext(), certifications);
                recyclerViewCertifications.setAdapter(certificationAdapter);


                awards = (ArrayList<Award>) objects[1];
                if (awards != null) {
                    if (awards.size() != 0) {
                        Log.d("type", String.valueOf(objects[1].getClass()));
                        ResumeAwardAdapter awardAdapter = new ResumeAwardAdapter(getContext(), awards);
                        award_title.setAdapter(awardAdapter);
                    }
                } else {
                    // Handle the case where awards is null
                    Log.e("Error", "ArrayList<Award> is null");
                }

                patents = (ArrayList<Patent>) objects[3];
                ResumePatentAdapter patentAdapter = new ResumePatentAdapter(getContext(), patents);
                patents_recycler.setAdapter(patentAdapter);

            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });

        research_paperDeo research_paperDeo = new research_paperDeo();
        research_paperDeo.getallusereachd(requireContext(), Research_paper_recycler, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Research_Paper> list = (ArrayList<Research_Paper>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                ResumeResearch_Paper_Adapter adapter = new ResumeResearch_Paper_Adapter(list);
                Research_paper_recycler.setLayoutManager(layoutManager);
                Research_paper_recycler.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        resume.getall2(getContext(), Research_paper_recycler, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Object[] objects = (Object[]) object;
                workshops = (ArrayList<Workshop>) objects[1];
                Toast.makeText(getContext(), "size " + workshops.size(), Toast.LENGTH_SHORT).show();
                ResumeWorkshop_Adapter workshopAdapter = new ResumeWorkshop_Adapter(getContext(), workshops);
                workshop_recycler.setAdapter(workshopAdapter);

//                 skills= (ArrayList<Technical_Skill>) objects[2];
//                Resume_Skill_Adapter resumeSkillAdapter = new Resume_Skill_Adapter(getContext(),skills);
//                skill_recycler.setAdapter(resumeSkillAdapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "error2" + error, Toast.LENGTH_SHORT).show();
            }
        });

        technical_skilldeo technicalSkilldeo = new technical_skilldeo();
        technicalSkilldeo.fatchtechnicalskill(requireContext(), skill_recycler, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Technical_Skill> list = (ArrayList<Technical_Skill>) object;
                LinearLayoutManager gridLayout = new LinearLayoutManager(getContext());
                TechnicalSkillAdapter adapter = new TechnicalSkillAdapter(list);
                skill_recycler.setLayoutManager(gridLayout);
                skill_recycler.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });

        qualificationDeo qualificationdeo = new qualificationDeo();
        qualificationdeo.fatchtqualification(requireContext(), qualificationRecyclerView, new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Qualification> list = (ArrayList<Qualification>) object;
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                QualificationAdpter adapter = new QualificationAdpter(list);
//                qualificationRecyclerView.setLayoutManager(layoutManager);
                qualificationRecyclerView.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission(getContext())) {
                    generatePdf();
                }
            }
        });

        return view;
    }

    private boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                generatePdf();
            } else {
                Toast.makeText(getContext(), "Permission denied, cannot generate PDF.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void generatePdf() {
        // Your PDF generation code here
//        PdfGenerator.generatePdf(this, R.id.layout); // Example call to the PdfGenerator class
        PdfGenerator.generatePdf(getContext(), R.id.resume_layout2,nametxt);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("pdf_download_channel", "PDF Download", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "pdf_download_channel")
//                .setSmallIcon(R.drawable.download)
//                .setContentTitle("Resume PDF Download")
//                .setContentText("Resume PDF has been generated")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
//        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}


