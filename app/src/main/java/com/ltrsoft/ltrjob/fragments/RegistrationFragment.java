package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R; // Add your correct R class import
import com.ltrsoft.ltrjob.daoclasses.Registration;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

public class RegistrationFragment extends Fragment {

    private EditText createfname, createlmname, createemail, usermobile, password1, conform_password1;
    String userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registrationfragment, container, false);

        initializeViews(v);

        Button registerButton = v.findViewById(R.id.register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String fname = createfname.getText().toString();
                    String lname = createlmname.getText().toString();
                    String mobile = usermobile.getText().toString();
                    String email = createemail.getText().toString();
                    String password = password1.getText().toString();

                    // Create an instance of Registration and call userRegistration
                    Registration registration = new Registration();
                    registration.userRegistration(fname, lname, email, password, mobile, new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {
                            // Handle successful user registration
                            getFragmentManager().beginTransaction()
                                    .replace(R.id.constraint, new NavigationDrawerFragment())
                                    .addToBackStack(null)
                                    .commit();

                            Registration registration1=new Registration();
                            registration1.geteuserid(getContext(), "", new UserCallBack() {
                                @Override
                                public void userSuccess(Object object) {
                                    userId = (String) object;

                                }

                                @Override
                                public void userError(String error) {
                                    Toast.makeText(getContext(), "Error="+error, Toast.LENGTH_SHORT).show();
                                }
                            });


                        }

                        @Override
                        public void userError(String error) {
                            // Handle registration error, show a Toast with the error message
                            Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return v;
    }

    private void initializeViews(View v) {
        createfname = v.findViewById(R.id.createfname);
        createlmname = v.findViewById(R.id.createlmname);
        createemail = v.findViewById(R.id.createemail);
        usermobile = v.findViewById(R.id.usermobile);
        password1 = v.findViewById(R.id.password1);
        conform_password1 = v.findViewById(R.id.conform_password1);
    }

    private boolean validateInputs() {

        String fname = createfname.getText().toString().trim();
        String lname = createlmname.getText().toString().trim();
        String mobile = usermobile.getText().toString().trim();
        String email = createemail.getText().toString().trim();
        String password = password1.getText().toString().trim();
        String confirmPassword = conform_password1.getText().toString().trim();

        if (fname.isEmpty()) {
            createfname.setError("Enter First Name");
            return false;
        }

        if (lname.isEmpty()) {
            createlmname.setError("Enter Last Name");
            return false;
        }

        if (email.isEmpty()) {
            createemail.setError("Enter Email");
            return false;
        }

        if (mobile.isEmpty()) {
            usermobile.setError("Enter Mobile Number");
            return false;
        } else if (mobile.length() != 10) {
            usermobile.setError("Please enter a valid phone number");
            return false;
        }

        if (password.isEmpty()) {
            password1.setError("Enter Password");
            return false;
        } else if (password.length() < 8) {
            password1.setError("Password must be at least 8 characters");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            conform_password1.setError("Passwords do not match");
            return false;
        }
        return false;
    }
}
