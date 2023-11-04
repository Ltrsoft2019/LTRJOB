package com.ltrsoft.ltrjob.CoursesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class CourseCardDisplayFragment extends Fragment {
    public CourseCardDisplayFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.coursecarddisplayfragment,container,false);
        Toast.makeText(getActivity(), "course card", Toast.LENGTH_SHORT).show();

        return v;
    }
}
