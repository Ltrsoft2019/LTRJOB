package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ltrsoft.ltrjob.R;


public class Otpsend extends Fragment {

    private Button sendotp;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_otpsend, container, false);
            sendotp=v.findViewById(R.id.sendotp);
            sendotp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   ForgetOtpFragment forgetOtpFragment=new ForgetOtpFragment();
                    getFragmentManager().beginTransaction().replace(R.id.constraint, forgetOtpFragment
                    ).addToBackStack(null).commit();

                }
            });
        return v;
    }
}