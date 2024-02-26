package com.ltrsoft.ltrjob;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ltrsoft.ltrjob.daoclasses.Workshop_Deo;
import com.ltrsoft.ltrjob.daoclasses.user_projectDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;


public class WorkshopUpdate extends Fragment {

private EditText wname ,wvanue,wlevel,wdate;
Button button;

    public WorkshopUpdate() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_workshop_update, container, false);
wname=view.findViewById(R.id.name);
wvanue=view.findViewById(R.id.vanue);
wlevel=view.findViewById(R.id.workshoplevel);
wdate=view.findViewById(R.id.date);
button=view.findViewById(R.id.updateworkshop);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Workshop_Deo awardDeo=new Workshop_Deo();
        awardDeo.updateWorkshop(wname.toString(), wvanue.toString(), wlevel.toString(), wdate.toString(), requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                Toast.makeText(getContext(), "workshop Updated Successfully"+object.toString(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void userError(String error) {
                userError(error.toString());

            }
        });


    }
});






        return view;
    }
}