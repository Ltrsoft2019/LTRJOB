package com.ltrsoft.ltrjob.LoginRegistrationOprationFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class ForgetOtpFragment extends Fragment {
    public ForgetOtpFragment(){}
    private Button verify_otp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.forgetotpfragment,container,false);
        verify_otp=v.findViewById(R.id.verify_otp);

        verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               PasswordChangeFragment passwordChangeFragment=new PasswordChangeFragment();
                getFragmentManager().beginTransaction().replace(R.id.constraint,passwordChangeFragment
                ).addToBackStack(null).commit();
            }
        });

        return v;
    }
}
