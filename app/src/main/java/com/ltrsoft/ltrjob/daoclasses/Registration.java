package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
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
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

import java.util.HashMap;
import java.util.Map;

public class Registration {

    private static final String BASE_URL = "hhttps://job.ltr-soft.com/User_Detail/user_insert.php";
    private FragmentManager fragmentManager;
    private Context context;

    public Registration(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public Registration() {

    }

    public void userRegistration(final String fname, final String lname, final String email,
                                 final String mobile, final String password, UserCallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, "Registration Successful", Toast.LENGTH_LONG).show();
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
                map.put("fname", fname);
                map.put("lname", lname);
                map.put("sm", mobile);
                map.put("email", email);
                map.put("pass", password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    private void gologin() {
        LoginFragment loginFragment = new LoginFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.constraint, loginFragment)
                .addToBackStack(null)
                .commit();
    }
}
