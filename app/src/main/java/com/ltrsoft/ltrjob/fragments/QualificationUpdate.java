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
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.daoclasses.technical_skilldeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class QualificationUpdate extends Fragment {
    EditText cname, per, year;
    Button button;

    public QualificationUpdate() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qualificatyion, container, false);
        cname = view.findViewById(R.id.cname);
        per = view.findViewById(R.id.percentage);
        year = view.findViewById(R.id.yearpassing);
        button = view.findViewById(R.id.updatequlificatio);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String collegename = cname.getText().toString();
                String percentage = per.getText().toString();
                String years = year.getText().toString();

                if (!collegename.isEmpty() && !percentage.isEmpty() && !years.isEmpty()) {
                    // Call the method to update qualification
                    updateQualification(collegename, percentage, years);
                } else {
                    Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void updateQualification(String cname, String cgp, String passingy) {
        qualificationDeo qualificationDeo = new qualificationDeo();
        qualificationDeo.updatequlification(cname, cgp, passingy, requireContext(), new UserCallBack() {
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
