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
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class AwardUpdate extends Fragment {

    EditText name, givenby, date, vanue,type;
    Button updateButton;

    public AwardUpdate() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_update, container, false);

        name = view.findViewById(R.id.editTextText4);
        givenby = view.findViewById(R.id.editTextText5);
        date = view.findViewById(R.id.editTextText6);
        vanue = view.findViewById(R.id.editTextText7);
        type=view.findViewById(R.id.editTextText8);

        updateButton = view.findViewById(R.id.button2);


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch values from EditText fields
                String awardTitle = name.getText().toString();
                String givenBy = givenby.getText().toString();
                String awardNumber = date.getText().toString();
                String awardDate = vanue.getText().toString();
                String atype=type.getText().toString();


                updateAward(awardTitle, givenBy, awardNumber, awardDate,atype);
            }
        });

        return view;
    }

    private void updateAward(String title, String givenBy, String number, String date, String atype) {

        Award_Deo awardDeo=new Award_Deo();
awardDeo.updateAward(title, givenBy, number, date, atype, requireContext(), new UserCallBack() {
    @Override
    public void userSuccess(Object object) {
        Toast.makeText(getContext(), "Award Updated Successfully"+object.toString(), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void userError(String error) {
           userError(error.toString());

    }
});{

        }

    }
}
