package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Resume {
   String  USER_PROFILE_READ_URL="https://job.ltr-soft.com/resume_query.php";
    public void getall(Context context, UserCallBack userCallBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, USER_PROFILE_READ_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String user_fname = jsonObject.getString("user_fname");
                            userCallBack.userSuccess(user_fname);
//                            JSONArray jsonArray = new JSONArray(response);
//                            if (jsonArray.length() > 0) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(0);
//                                String user_fname = jsonObject.getString("user_fname");
//
//                                Toast.makeText(context, user_fname, Toast.LENGTH_SHORT).show();
//
//                                User user1 = new User(user_fname);                                 // Pass the user1 object to the success callback
//                                userCallBack.userSuccess(user1);
//                            } else {
//
//                                userCallBack.userError("No user data available");
//                            }
                        } catch (JSONException e) {
                            // Handle JSON parsing error
                            userCallBack.userError(e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                userCallBack.userError(error.toString());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("user_id", "user-17");
                return hashMap;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}

