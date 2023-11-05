package com.ltrsoft.ltrjob.CoursesFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.DashboardFragment;
import com.ltrsoft.ltrjob.R;

public class Course_congratulation_page extends Fragment {

    public TextView home_page;
    public Button view_courses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
    View view=inflater.inflate(R.layout.fragment_course_congratulation_page,container,false);
    home_page=view.findViewById(R.id.home_page);
    view_courses=view.findViewById(R.id.view_courses);
        view_courses.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager=getParentFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new CourseCardDisplayFragment());
            fragmentTransaction.commit();
            fragmentTransaction.addToBackStack(null);
        }
    });
        home_page.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
               FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,new DashboardFragment());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            Toast.makeText(getContext(), "Welcome to the home page", Toast.LENGTH_SHORT).show();
        }
    });


        return view;
}

}