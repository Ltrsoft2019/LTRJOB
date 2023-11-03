package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class ForgetOtpFragment extends Fragment {
    public ForgetOtpFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.forgetotpfragment,container,false);
        return v;
    }
}
