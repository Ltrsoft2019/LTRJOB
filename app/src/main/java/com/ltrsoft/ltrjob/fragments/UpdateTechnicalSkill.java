package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.technical_skilldeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class UpdateTechnicalSkill extends Fragment {
    EditText technivcalname;
    Button button;

    public UpdateTechnicalSkill() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_technical_skill, container, false);

        technivcalname = view.findViewById(R.id.technicalkill);
        button = view.findViewById(R.id.update);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseId = null;
                if (getArguments() != null) {
                    courseId = getArguments().getString("course_id");
                }

                // Check if courseId is not null or empty
                if (courseId != null && !courseId.isEmpty()) {
                    String tname = technivcalname.getText().toString();
                    updateTechnicalSkill(tname, courseId);
                } else {
                    Toast.makeText(getContext(), "Invalid course ID", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void updateTechnicalSkill(String tname, String courseId) {
        technical_skilldeo technicalSkilldeo = new technical_skilldeo();
        technicalSkilldeo.updatetechnicalskill(tname, courseId, requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
