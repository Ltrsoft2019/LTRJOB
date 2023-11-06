package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ltrsoft.ltrjob.Classes.Userclass;
import com.ltrsoft.ltrjob.R;


public class Otpsend extends Fragment {

    private Button sendotp;

    private EditText otpnumber;
    private Button sendopt;
    private Userclass userclass=new Userclass();

    private ProgressBar progressBar;
    private static final String BASE_URL = "https://job.ltr-soft.com/User_Detail/mobile_check.php";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_otpsend, container, false);
            sendotp=v.findViewById(R.id.sendotp);
        otpnumber=v.findViewById(R.id.otpnumber);
        sendopt=v.findViewById(R.id.sendotp);
        progressBar=v.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
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