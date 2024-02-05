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

import com.ltrsoft.ltrjob.R;  // Import your R class if it's not already imported
import com.ltrsoft.ltrjob.daoclasses.User_Deo;  // Replace with the actual package for User_Deo
import com.ltrsoft.ltrjob.interfaces.UserCallBack;  // Replace with the actual package for UserCallBack

public class RegistrationFragment extends Fragment {

    private EditText createfname, createlmname, createemail, usermobile, password1, conform_password1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registrationfragment, container, false);

        createfname = v.findViewById(R.id.createfname);
        createlmname = v.findViewById(R.id.createlmname);
        createemail = v.findViewById(R.id.createemail);
        usermobile = v.findViewById(R.id.usermobile);
        password1 = v.findViewById(R.id.password1);
        conform_password1 = v.findViewById(R.id.conform_password1);

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

                    User_Deo userDeo = new User_Deo();

                    userDeo.createUser(fname, lname, email, password, mobile, requireContext(), new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {

                            getFragmentManager().beginTransaction()
                                    .replace(R.id.constraint, new NavigationDrawerFragment())
                                    .addToBackStack(null)
                                    .commit();
                        }

                        @Override
                        public void userError(String error) {
                            // Handle error, show a Toast with the error message
                            Toast.makeText(getContext(), "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return v;
    }

    private boolean validateInputs() {
        if (createfname.getText().toString().trim().isEmpty()) {
            createfname.setError("Enter First Name");
            return false;
        }

        if (createlmname.getText().toString().trim().isEmpty()) {
            createlmname.setError("Enter Last Name");
            return false;
        }

        if (createemail.getText().toString().trim().isEmpty()) {
            createemail.setError("Enter Email");
            return false;
        }

        if (usermobile.getText().toString().trim().isEmpty()) {
            usermobile.setError("Enter Mobile Number");
            return false;
        }

        if (password1.getText().toString().trim().isEmpty()) {
            password1.setError("Enter Password");
            return false;
        }

        if (conform_password1.getText().toString().trim().isEmpty()) {
            conform_password1.setError("Confirm Password");
            return false;
        }
        return true;
    }
}