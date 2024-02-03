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
import com.ltrsoft.ltrjob.pojoclass.AwardCategory;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Award_Category_Deo {
    private static String URL="";
    private static String Create_URL="";
    private static String Update_URL="";
    private static String Delete_URL="";
    private static String ReadAll_URL="";
    AwardCategory awardCategory;
    ArrayList<AwardCategory>list=new ArrayList<>();

    public void getAllAwardC(Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray=new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String award_catogery_name = jsonObject.getString("award_catogery_name");

                        awardCategory =new AwardCategory(award_catogery_name);

                    }
                } catch (JSONException e) {
                    userCallBack.userError(e.toString());
                    throw new RuntimeException(e);
                }
                userCallBack.userSuccess(awardCategory);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void getAwardC(String award_catogery_id,Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String award_catogery_name = jsonObject.getString("award_catogery_name");

                                awardCategory =new AwardCategory(award_catogery_name);

                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(awardCategory);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("award_catogery_id",award_catogery_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void createAwardC(AwardCategory awardCategory,String award_catogery_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Create_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("award_catogery_name",awardCategory.getAward_catogery_name());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void updateAwardC(AwardCategory awardCategory,String award_catogery_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Update_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("award_catogery_name",awardCategory.getAward_catogery_name());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void deleteAwardC(AwardCategory awardCategory,String award_catogery_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Delete_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("award_catogery_id",awardCategory.getAward_catogery_id());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void searchAwardC(AwardCategory awardCategory,String award_catogery_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            userCallBack.userSuccess("success");
                        } else {
                            userCallBack.userError(response.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.userError(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("award_catogery_id",awardCategory.getAward_catogery_id());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


}
