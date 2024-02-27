package com.ltrsoft.ltrjob.fragments;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
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

import com.ltrsoft.ltrjob.Adpter.ResumeAwardAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumeCertificationAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumePatentAdapter;
import com.ltrsoft.ltrjob.Adpter.ResumeResearch_Paper_Adapter;
import com.ltrsoft.ltrjob.Adpter.ResumeWorkshop_Adapter;
import com.ltrsoft.ltrjob.Adpter.Resume_Skill_Adapter;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Resume;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.Patent;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.pojoclass.Workshop;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ResumeFragment extends Fragment {

    private TextView education, work_exp, resumedetails, address, email, number, profession, name, git_hub, link_id;
    private ImageView download, profileimg;
    private RecyclerView recyclerViewCertifications, award_title,patents_recycler,Research_paper_recycler,workshop_recycler,skill_recycler;
    private ArrayList<Certification> certifications;
    private ArrayList<Award> awards;
    private ArrayList<Patent> patents;
    private ArrayList<Research_Paper> research_paper;
    private ArrayList<Workshop> workshops;
    private ArrayList<Technical_Skill> skills;
    private Resume resume;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 10;
    private static final String FILE_NAME = "RResume.png";
    private static final int NOTIFICATION_ID = 100;
    private static final String TAG = "ResumeFragment";
    Object[] objects2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        education = view.findViewById(R.id.education);
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

                String imgUrl = "https://institute.ltr-soft.com/company_details/" + user.getUser_photo();
                Picasso.get().load(imgUrl).into(profileimg);

                certifications = (ArrayList<Certification>) objects[2];
                ResumeCertificationAdapter certificationAdapter = new ResumeCertificationAdapter(getContext(), certifications);
                recyclerViewCertifications.setAdapter(certificationAdapter);

                awards = (ArrayList<Award>) objects[1];
                ResumeAwardAdapter awardAdapter = new ResumeAwardAdapter(getContext(), awards);
                award_title.setAdapter(awardAdapter);

                patents = (ArrayList<Patent>) objects[3];
                ResumePatentAdapter patentAdapter = new ResumePatentAdapter(getContext(), patents);
                patents_recycler.setAdapter(patentAdapter);

                research_paper= (ArrayList<Research_Paper>) objects[4];
                ResumeResearch_Paper_Adapter resumeResearchPaper = new ResumeResearch_Paper_Adapter(getContext(), research_paper);
                Research_paper_recycler.setAdapter(resumeResearchPaper);
            }
            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });

        resume.getall2(getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Object[] objects = (Object[]) object;
                workshops = (ArrayList<Workshop>) objects[1];
                Toast.makeText(getContext(), "size "+workshops.size(), Toast.LENGTH_SHORT).show();
                ResumeWorkshop_Adapter workshopAdapter = new ResumeWorkshop_Adapter(getContext(),workshops);
                workshop_recycler.setAdapter(workshopAdapter);

//                 skills= (ArrayList<Technical_Skill>) objects[2];
//                Resume_Skill_Adapter resumeSkillAdapter = new Resume_Skill_Adapter(getContext(),skills);
//                skill_recycler.setAdapter(resumeSkillAdapter);




            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "error2"+error, Toast.LENGTH_SHORT).show();
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureLayoutAndDownload();
            }
        });

        return view;
    }

    private void captureLayoutAndDownload() {
        View rootView = getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        Bitmap bitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        rootView.draw(canvas);
        saveBitmapAsPng(bitmap);
        showDownloadNotification();
    }

    private void saveBitmapAsPng(Bitmap bitmap) {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), FILE_NAME);
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                outputStream.flush();
                outputStream.close();
                Log.d(TAG, "File saved successfully: " + file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "Error saving file: " + e.getMessage());
            }
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE);
        }
    }

    private void showDownloadNotification() {
        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "resume_download_channel")
                .setSmallIcon(R.drawable.download)
                .setContentTitle("Resume Download")
                .setContentText("Resume downloaded successfully")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Resume Download Channel";
            String description = "Channel for resume download notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("resume_download_channel", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = requireContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                captureLayoutAndDownload();
            } else {
                Toast.makeText(getContext(), "Permission denied. Cannot download resume.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
