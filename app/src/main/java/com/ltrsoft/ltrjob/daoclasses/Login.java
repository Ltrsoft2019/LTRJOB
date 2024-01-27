package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.fragments.NavigationDrawerFragment;
import com.ltrsoft.ltrjob.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login {
    private static final String BASE_URL = "https://job.ltr-soft.com/login1.php";

    public  void loginuser(final Context context, FragmentManager fragmentManager, EditText loginEmail, EditText loginPassword, Button loginButton, ProgressBar bar){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("data = " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String msg = jsonObject.getString("Message");
                    if (msg.equals("100")) {
                        Toast.makeText(context.getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                        NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                        fragmentManager.beginTransaction().replace(R.id.constraint, navigationDrawerFragment).commit();
                        bar.setVisibility(View.GONE);
                        loginButton.setVisibility(View.VISIBLE);
                        SharedPreferences pref = context.getSharedPreferences("login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("flag", true)
                                .apply();

//                        // Sending Fragment
                        JSONObject userData = jsonObject.getJSONObject("0");
                        String user_id = userData.getString("user_id");


                    } else if (msg.equals("200")) {
                        Toast.makeText(context, "Invalid Password", Toast.LENGTH_LONG).show();
                        bar.setVisibility(View.GONE);
                        loginButton.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(context, "Student Not Found Please Create New Account", Toast.LENGTH_LONG).show();
                        bar.setVisibility(View.GONE);
                        loginButton.setVisibility(View.VISIBLE);

                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "error = " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                Userclass userclass=new Userclass();

                map.put("email", userclass.setUser_email(loginEmail.getText().toString()));
                map.put("password", userclass.setUser_password(loginPassword.getText().toString()));



                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);






    }

}
