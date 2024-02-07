package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Resume;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.User;

import java.util.ArrayList;

public class ResumeFragment extends Fragment {

    // ... (rest of the code)
    Object []object = new Object[3];  // created object array
    ArrayList<Award> awards=new ArrayList<>();
    ArrayList<Certification>certifications=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        final TextView textViewResume = view.findViewById(R.id.textViewResume);
        final TextView textViewResume2 = view.findViewById(R.id.textViewResume2);
        final TextView textViewResume3 = view.findViewById(R.id.textViewResume3);

        Resume resume = new Resume();
        resume.getall( requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object obj) {

                object= (Object[]) obj;
                User user = (User) object[0];
                textViewResume.setText(user.getUser_fname());
                // set user details here

                awards = (ArrayList<Award>) object[1];
                for (int i = 0; i <awards.size() ; i++) {
                    Award award = awards.get(i);
                    textViewResume2.setText(award.getAward_name()+award.getAward_date_recieved());

                }

                certifications = (ArrayList<Certification>) object[2];
                for (int i = 0; i <certifications.size() ; i++) {
                   Certification certification = certifications.get(i);
                    textViewResume3.setText(certification.getCertification_title());
                }




            }
            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "errer"+error.toString(), Toast.LENGTH_SHORT).show();
                System.out.println("eror"+error.toString());
            }
        });


        return view;
    }
}
