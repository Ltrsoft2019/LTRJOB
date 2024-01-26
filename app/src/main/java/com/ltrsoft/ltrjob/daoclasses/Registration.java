package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;


import androidx.fragment.app.FragmentManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.fragments.LoginFragment;
import com.ltrsoft.ltrjob.R;

import java.util.HashMap;
import java.util.Map;

public class Registration {

    private static final String BASE_URL = "https://job.ltr-soft.com/registration.php";
    private FragmentManager fragmentManager;
    private Context context;
    private EditText createfname, createlmname, createemail, usermobile, password1, conform_password1;

//    public Registration(Context context, FragmentManager fragmentManager, EditText createfname, EditText createlmname, EditText createemail, EditText usermobile, EditText password1, EditText conform_password1) {
//        this.context = context;
//        this.createfname = createfname;
//        this.createlmname = createlmname;
//        this.createemail = createemail;
//        this.usermobile = usermobile;
//        this.password1 = password1;
//        this.conform_password1 = conform_password1;
//    }

    public void userRegistration() {
        if (validateInput()) {
            sendData();
        }
    }

    private boolean validateInput() {
        if (createfname.getText().toString().trim().isEmpty()) {
            createfname.setError("Enter First Name");
            return false;
        } else {
            createfname.setError(null);
        }

        if (createlmname.getText().toString().trim().isEmpty()) {
            createlmname.setError("Enter Last Name");
            return false;
        } else {
            createlmname.setError(null);
        }

        if (createemail.getText().toString().trim().isEmpty()) {
            createemail.setError("Enter Email");
            return false;
        } else {
            createemail.setError(null);
        }

        if (usermobile.getText().toString().trim().isEmpty()) {
            usermobile.setError("Enter Mobile Number");
            return false;
        } else {
            usermobile.setError(null);
        }

        if (password1.getText().toString().trim().isEmpty()) {
            password1.setError("Enter Password");
            return false;
        } else {
            password1.setError(null);
        }

        if (conform_password1.getText().toString().trim().isEmpty()) {
            conform_password1.setError("Enter Confirm Password");
            return false;
        } else {
            conform_password1.setError(null);
        }

        String mobileNo = usermobile.getText().toString();
        if (mobileNo.length() != 10) {
            Toast.makeText(context, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
            return false;
        }

        String password = password1.getText().toString();
        String confirmPassword = conform_password1.getText().toString();
        if (password.length() < 8 || !password.equals(confirmPassword)) {
            Toast.makeText(context, "Password must be at least 8 characters and match", Toast.LENGTH_SHORT).show();
            password1.setText("");
            conform_password1.setText("");
            return false;
        }

        return true;
    }

    private void sendData() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, "Registration Successful", Toast.LENGTH_LONG).show();
                        clearInputFields();
                        gologin();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("fname", createfname.getText().toString());
                map.put("lname", createlmname.getText().toString());
                map.put("sm", usermobile.getText().toString());
                map.put("email", createemail.getText().toString());
                map.put("pass", password1.getText().toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void clearInputFields() {
        createfname.setText("");
        createlmname.setText("");
        createemail.setText("");
        usermobile.setText("");
        password1.setText("");
        conform_password1.setText("");
    }

    private void gologin() {
        LoginFragment loginFragment = new LoginFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.constraint, loginFragment)
                .addToBackStack(null)
                .commit();

    }
}
