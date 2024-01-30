package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Mini_Project;
import com.ltrsoft.ltrjob.pojoclass.Mini_Project_User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Miniprojectuser {

    String fach="";
    public void fatchproject(Mini_Project_User miniprojectuser , String userid, Context context, UserCallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, fach,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);


                                String mini_project_title = jsonObject.getString("mini_project_title");
                                String mini_project_start_date = jsonObject.getString("mini_project_start_date");
                                String mini_project_end_date = jsonObject.getString("mini_project_end_date");
                                String mini_project_topic = jsonObject.getString("mini_project_topic");
                                String mini_project_technologies_used = jsonObject.getString("mini_project_technologies_used");


                                Mini_Project miniProject = new Mini_Project(mini_project_title, mini_project_start_date, mini_project_end_date, mini_project_topic, mini_project_technologies_used);


                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
callBack.userError(error.toString());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("User_id",String.valueOf(miniprojectuser.getUser_id()));
                hashMap.put("mini_project_user_id",String.valueOf(miniprojectuser.getMini_project_user_id()));
                hashMap.put("mini_project_id",String.valueOf(miniprojectuser.getMini_project_id()));
                hashMap.put("status_id",String.valueOf(miniprojectuser.getStatus_id()));

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }







}
