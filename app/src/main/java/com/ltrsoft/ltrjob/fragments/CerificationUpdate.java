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
import com.ltrsoft.ltrjob.daoclasses.Certificationdeo;

import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class CerificationUpdate extends Fragment {

    EditText e1, e2, e3, e4;
    Button updateButton;

    public CerificationUpdate() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cerification_update, container, false);

        e1 = view.findViewById(R.id.cttitle);
        e2 = view.findViewById(R.id.givenby);
        e3 = view.findViewById(R.id.number);
        e4 = view.findViewById(R.id.cdate);
        updateButton = view.findViewById(R.id.Updatecertification);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch values from EditText fields
                String certificationTitle = e1.getText().toString();
                String givenBy = e2.getText().toString();
                String certificationNumber = e3.getText().toString();
                String certificationDate = e4.getText().toString();

                // Call the method to update certification
                updateCertification(certificationTitle, givenBy, certificationNumber, certificationDate);
            }
        });

        return view;
    }

    private void updateCertification(String title, String givenBy, String number, String date) {
        Certificationdeo certificationDeo = new Certificationdeo();
        certificationDeo.updatecertification(title, givenBy, number, date, requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Toast.makeText(getContext(), "Certification Updated Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

}

