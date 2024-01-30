package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Mini_Project;
import com.ltrsoft.ltrjob.pojoclass.Notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NotificationDeo {
    String create="";
    String fach="";
    String update="";
    String delete="";

    public  void createnotification(Mini_Project miniProject, UserCallBack callBack, Context context, String mini_project_title, String mini_project_start_date, String mini_project_end_date, String mini_project_topic, String mini_project_technologies_used, String mini_project_problem_statement, String mini_project_test_cases, String user_id)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, create,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("Message");
                            if (msg.equals("100")) {
                                callBack.userSuccess(msg);

                            } else if (msg=="200") {
                                callBack.userError("created");

                            } else if (msg=="300") {
                                callBack.userError("created Failed");
                            }
                        } catch (JSONException e) {
                            callBack.userError(e.toString());
                            throw new RuntimeException(e);

                        }

//
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("mini_project_title", mini_project_title);
                params.put("mini_project_start_date", mini_project_start_date);
                params.put(" mini_project_end_date",mini_project_end_date);
                params.put("mini_project_topic",mini_project_topic);
                params.put("mini_project_technologies_used",mini_project_technologies_used);
                params.put("mini_project_problem_statement",mini_project_problem_statement);
                params.put("mini_project_test_cases",mini_project_test_cases);
                params.put("user_id",user_id);

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }







//    public void fatchnotification(Notification notification , String userid, Context context,UserCallBack callBack) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, fach,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//
//                                String mini_project_title = jsonObject.getString("mini_project_title");
//                                String mini_project_start_date = jsonObject.getString("mini_project_start_date");
//                                String mini_project_end_date = jsonObject.getString("mini_project_end_date");
//                                String mini_project_topic = jsonObject.getString("mini_project_topic");
//                                String mini_project_technologies_used = jsonObject.getString("mini_project_technologies_used");
//                                String  mini_project_problem_statement=jsonObject.getString("mini_project_problem_statement");
//                                String mini_project_test_cases=jsonObject.getString("mini_project_test_cases");
//
//                                Mini_Project miniProject = new Mini_Project(mini_project_title, mini_project_start_date, mini_project_end_date, mini_project_topic, mini_project_technologies_used);
//
//
//                            }
//                        } catch (JSONException e) {
//
//                            throw new RuntimeException(e);
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//
//            }
//        }) {
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> hashMap = new HashMap<>();
//                hashMap.put("User_id",String.valueOf(miniProject1.getUser_id()));
//                return hashMap;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        requestQueue.add(stringRequest);
//
//    }

    public void updateNotification(Mini_Project miniProject, String userid, Context context, UserCallBack callBack){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, update,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {

                            callBack.userSuccess("success");
                        } else {
                            callBack.userError(response.toString());
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();

                hashMap.put("User_id",String.valueOf(miniProject.getUser_id()));
                hashMap.put("mini_project_title",miniProject.getMini_project_title());
                hashMap.put("mini_project_start_date",miniProject.getMini_project_start_date());
                hashMap.put("mini_project_end_date",miniProject.getMini_project_end_date());
                hashMap.put("mini_project_topic",miniProject.getMini_project_topic());
                hashMap.put("mini_project_problem_statement",miniProject.getMini_project_problem_statement());
                hashMap.put("mini_project_test_cases",miniProject.getMini_project_test_cases());


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void deletnotification( Mini_Project miniProject,String userid,Context context,UserCallBack callBack){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, delete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("User_id",String.valueOf(miniProject.getUser_id()));



                return map;
            }
        };
    }





}
