package com.ltrsoft.ltrjob.CompanyJobFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class CompanyDetailFragment extends Fragment {
    public CompanyDetailFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.companydetailfragment,container,false);
        Toast.makeText(getActivity(), "comp[any Detail", Toast.LENGTH_SHORT).show();

        return v;
    }
}
