package com.ltrsoft.ltrjob.EventFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class EventDetailFragment extends Fragment {
    public EventDetailFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.eventdetailfragment,container,false);
        Toast.makeText(getActivity(), "event  detail", Toast.LENGTH_SHORT).show();

        return v;
    }
}
