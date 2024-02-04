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
import com.ltrsoft.ltrjob.pojoclass.User;

public class ResumeFragment extends Fragment {

    // ... (rest of the code)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        final TextView textViewResume = view.findViewById(R.id.textViewResume);

        Resume resume = new Resume();
        resume.getall( requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object obj) {
                String resumeData = (String) obj;
                textViewResume.setText(resumeData);
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
