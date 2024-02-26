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
import com.ltrsoft.ltrjob.daoclasses.research_paperDeo;
import com.ltrsoft.ltrjob.daoclasses.user_projectDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class ReasearchUpdate extends Fragment {
EditText name,Hindex,Iidex,Cition,Author1,Author2,Author3,Author4,Author5,Author6,Publish,isbnumber,Location,StartDate,EndDate,Valumeedition,Doi,Post_Date;
Button button;
    public ReasearchUpdate() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_reasearch_update, container, false);

name=view.findViewById(R.id.rname);
Hindex=view.findViewById(R.id.hindex);
Iidex=view.findViewById(R.id.iindex);
Cition=view.findViewById(R.id.cition);
Author1=view.findViewById(R.id.a1);
Author2=view.findViewById(R.id.a2);
Author3=view.findViewById(R.id.a3);
Author4=view.findViewById(R.id.a4);
Author5=view.findViewById(R.id.a5);
Author6=view.findViewById(R.id.a6);
Publish=view.findViewById(R.id.publish);
isbnumber=view.findViewById(R.id.isbno);
Location=view.findViewById(R.id.location);
StartDate=view.findViewById(R.id.sdate);
EndDate=view.findViewById(R.id.enddate);
Valumeedition=view.findViewById(R.id.vlaueedit);
Doi=view.findViewById(R.id.doi);
Post_Date=view.findViewById(R.id.date);

button=view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                research_paperDeo awardDeo = new research_paperDeo();
                awardDeo.updatereasrchpaper(
                        name.toString(),
                        Hindex.toString(),
                        Iidex.toString(),
                        Author1.toString(),
                        Author2.toString(),
                        Author3.toString(),
                        Author4.toString(),
                        Author5.toString(),
                        Author6.toString(),
                        Publish.toString(),
                        isbnumber.toString(),
                        Location.toString(),
                        StartDate.toString(),
                        EndDate.toString(),
                        Valumeedition.toString(),
                        Doi.toString(),
                        Post_Date.toString(),
                        "",
                        requireContext(),
                        new UserCallBack() {
                            @Override
                            public void userSuccess(Object object) {
                                Toast.makeText(getContext(), "Research Updated Successfully" , Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void userError(String error) {
                                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        });











        return view;
    }
}