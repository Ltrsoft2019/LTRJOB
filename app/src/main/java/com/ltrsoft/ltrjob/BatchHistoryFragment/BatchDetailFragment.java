package com.ltrsoft.ltrjob.BatchHistoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class BatchDetailFragment extends Fragment {
    public BatchDetailFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.batchdetailfragment,container,false);
        Toast.makeText(getActivity(), "batchdetailfragment", Toast.LENGTH_SHORT).show();
        return v;
    }
}
