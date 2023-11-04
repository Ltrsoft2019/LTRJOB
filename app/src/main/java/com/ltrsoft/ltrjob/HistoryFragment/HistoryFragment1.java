package com.ltrsoft.ltrjob.HistoryFragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ltrsoft.ltrjob.R;
public class HistoryFragment1 extends Fragment {
    public HistoryFragment1() {}
    private Button ajobsbtn,course_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_history1, container, false);
        ajobsbtn = view.findViewById(R.id.btnjob);
        course_btn = view.findViewById(R.id.btncourse);


        loadFragment(new AppliedJobCardHistoryFragment(),1);
        int myColor = Color.argb(255,100,255,100);
        int mycolor2 = Color.argb(255, 118, 118, 188);
        ajobsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AppliedJobCardHistoryFragment(),0);

                ajobsbtn.setBackgroundTintList(ColorStateList.valueOf(myColor));
                course_btn.setBackgroundTintList(ColorStateList.valueOf(mycolor2));
            }
        });
        course_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AppliedCoursesCardHistroryFragment(),0);
                course_btn.setBackgroundTintList(ColorStateList.valueOf(myColor));
                ajobsbtn.setBackgroundTintList(ColorStateList.valueOf(mycolor2));
            }
        });
        return view;
    }

    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag==1){
            ft.add(R.id.jobslayout, fragment);
        }
        else if (flag==0){
            ft.replace(R.id.jobslayout,fragment);
        }
        ft.commit();
    }
}