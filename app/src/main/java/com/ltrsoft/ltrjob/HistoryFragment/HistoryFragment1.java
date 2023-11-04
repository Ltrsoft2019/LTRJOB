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

        getFragmentManager().beginTransaction().replace(R.id.jobslayout, new AppliedJobCardHistoryFragment()).addToBackStack(null).commit();

        int color1 = Color.parseColor("#00D084");
        ajobsbtn.setTextColor(color1);
        int color2 = Color.parseColor("#FF000000");
        course_btn.setTextColor(color2);
        ajobsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color1 = Color.parseColor("#00D084");
                ajobsbtn.setTextColor(color1);
                int color2 = Color.parseColor("#FF000000");
                course_btn.setTextColor(color2);
                getFragmentManager().beginTransaction().replace(R.id.jobslayout, new AppliedJobCardHistoryFragment()).addToBackStack(null).commit();
            }
        });
        course_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color1 = Color.parseColor("#FF000000");
                ajobsbtn.setTextColor(color1);
                int color2 = Color.parseColor("#00D084");
                course_btn.setTextColor(color2);
                getFragmentManager().beginTransaction().replace(R.id.jobslayout, new AppliedCoursesCardHistroryFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }


}