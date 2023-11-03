package com.ltrsoft.ltrjob.BatchHistoryFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class BatchCardDisplayFragment extends Fragment {
    public BatchCardDisplayFragment(){    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.batchcarddisplayfragment,container,false);
        return v;
    }
}
