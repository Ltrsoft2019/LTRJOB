package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.daoclasses.Login;
import com.ltrsoft.ltrjob.R;


public class LoginFragment extends Fragment {
    public LoginFragment() {

    }

    private TextView forgot, createaccount, spinnertxt, document;
    private Button loginButton;
    private EditText loginEmail, loginPassword;
    private ProgressBar bar;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loginfragment, container, false);

        loginEmail = v.findViewById(R.id.loginEmail);
        loginPassword = v.findViewById(R.id.loginPassword);
        loginButton = v.findViewById(R.id.loginButton);
        bar = v.findViewById(R.id.progressBar);
        forgot = v.findViewById(R.id.forgot);
        createaccount = v.findViewById(R.id.create_new_account);
        bar.setVisibility(View.GONE);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    Login login=new Login();
                    login.loginuser(requireContext(), getParentFragmentManager(), loginEmail, loginPassword, loginButton, bar);
                    loginButton.setVisibility(View.GONE);
                    bar.setVisibility(View.VISIBLE);

                } else {
                    loginEmail.setError("Please Enter Email");
                    loginPassword.setError("Please Enter Password");
                }

            }
        });


        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegistrationFragment registrationFragment =new RegistrationFragment();
                getFragmentManager().beginTransaction().replace(R.id.constraint, registrationFragment).addToBackStack(null).commit();


            }

        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Otpsend otpsend=new Otpsend();
//                getFragmentManager().beginTransaction().replace(R.id.constraint, otpsend).addToBackStack(null).commit();

            }
        });



        return v;
    }

}