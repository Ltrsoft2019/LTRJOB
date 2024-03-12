package com.ltrsoft.ltrjob.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.daoclasses.Login;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Registration;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;


public class    LoginFragment extends Fragment {
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
                    Login login = new Login();
                    login.login(email, password, getContext(), new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {

                            getFragmentManager().beginTransaction().replace(R.id.container, new NavigationDrawerFragment()).addToBackStack(null).commit();

                            SharedPreferences preferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("isLoggedIn", true).apply(); // Set the flag to true

                        }

                        @Override
                        public void userError(String error) {
                            Toast.makeText(getContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                    loginButton.setVisibility(View.GONE);
                    bar.setVisibility(View.VISIBLE);

                } else {
                    loginEmail.setError("Please Enter Email");
                    loginPassword.setError("Please Enter Password");
                }


                Registration registration=new Registration();
                registration.geteuser(getContext(), "", new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {



                    }

                    @Override
                    public void userError(String error) {

                    }
                });
            }




        });


        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegistrationFragment registrationFragment =new RegistrationFragment();
                getFragmentManager().beginTransaction().replace(R.id.container,registrationFragment).addToBackStack(null).commit();


            }
        });


//        forgot.stOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ForgetPassword otpsend=new ForgetPassword();
//                getFragmentManager().beginTransaction().replace(R.id.constraint, otpsend).addToBackStack(null).commit();
//
//            }
//        });


        return v;
    }

}
