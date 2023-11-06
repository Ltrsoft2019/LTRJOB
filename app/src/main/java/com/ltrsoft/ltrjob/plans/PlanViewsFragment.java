package com.ltrsoft.ltrjob.plans;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;

public class PlanViewsFragment extends Fragment {
    public PlanViewsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_views_fragment, container, false);
        Toast.makeText(getContext(), "This is Plan View Fragment", Toast.LENGTH_SHORT).show();
        return view;
    }
}