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
import com.ltrsoft.ltrjob.pojoclass.Country;
import com.ltrsoft.ltrjob.pojoclass.Institute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Institute_Deo {

    private static String URL="";
    private static String Create_URL="";
    private static String Update_URL="";
    private static String Delete_URL="";
    private static String ReadAll_URL="";
    Institute institute;
    ArrayList<Institute> list=new ArrayList<>();

    public void getAllCountry(Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String institute_name = jsonObject.getString("institute_name");
                                String institute_logo = jsonObject.getString("institute_logo");
                                String institute_founded_in = jsonObject.getString("institute_founded_in");
                                String institute_founder = jsonObject.getString("institute_name");
                                String institute_address = jsonObject.getString("institute_name");
                                String institute_contact = jsonObject.getString("institute_contact");
                                String institute_website = jsonObject.getString("institute_website");
                                String institute_email = jsonObject.getString("institute_email");
                                String institute_description = jsonObject.getString("institute_description");
                                String instiyute_vission = jsonObject.getString("instiyute_vission");
                                String institute_mission = jsonObject.getString("institute_mission");
                                String institute_director_msg = jsonObject.getString("institute_director_msg");



                                institute =new Institute(institute_name,institute_logo,institute_founded_in,institute_founder,
                                        institute_address,institute_contact,institute_website,institute_email,institute_description,
                                        instiyute_vission,institute_mission,institute_director_msg );

                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(context);

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

    public void getCountry(String institute_id,Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String institute_name = jsonObject.getString("institute_name");
                                String institute_logo = jsonObject.getString("institute_logo");
                                String institute_founded_in = jsonObject.getString("institute_founded_in");
                                String institute_founder = jsonObject.getString("institute_name");
                                String institute_address = jsonObject.getString("institute_name");
                                String institute_contact = jsonObject.getString("institute_contact");
                                String institute_website = jsonObject.getString("institute_website");
                                String institute_email = jsonObject.getString("institute_email");
                                String institute_description = jsonObject.getString("institute_description");
                                String instiyute_vission = jsonObject.getString("instiyute_vission");
                                String institute_mission = jsonObject.getString("institute_mission");
                                String institute_director_msg = jsonObject.getString("institute_director_msg");



                                institute =new Institute(institute_name,institute_logo,institute_founded_in,institute_founder,
                                        institute_address,institute_contact,institute_website,institute_email,institute_description,
                                        instiyute_vission,institute_mission,institute_director_msg );

                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(context);

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
                map.put("institute_id",institute_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void createInstitute(Institute institute,String institute_id,Context context, UserCallBack userCallBack){
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

                map.put("institute_name",institute.getInstitute_name());
                map.put("institute_logo",institute.getInstitute_logo());
                map.put("institute_founded_in",institute.getInstitute_founded_in());
                map.put("institute_founder",institute.getInstitute_founder());
                map.put("institute_address",institute.getInstitute_address());
                map.put("institute_contact",institute.getInstitute_contact());
                map.put("institute_website",institute.getInstitute_website());
                map.put("institute_email",institute.getInstitute_email());
                map.put("institute_description",institute.getInstitute_description());
                map.put("instiyute_vission",institute.getInstiyute_vission());
                map.put("institute_mission",institute.getInstitute_mission());
                map.put("institute_director_msg",institute.getInstitute_director_msg());


                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateInstitute(Institute institute,String institute_id,Context context, UserCallBack userCallBack){
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

                map.put("institute_name",institute.getInstitute_name());
                map.put("institute_logo",institute.getInstitute_logo());
                map.put("institute_founded_in",institute.getInstitute_founded_in());
                map.put("institute_founder",institute.getInstitute_founder());
                map.put("institute_address",institute.getInstitute_address());
                map.put("institute_contact",institute.getInstitute_contact());
                map.put("institute_website",institute.getInstitute_website());
                map.put("institute_email",institute.getInstitute_email());
                map.put("institute_description",institute.getInstitute_description());
                map.put("instiyute_vission",institute.getInstiyute_vission());
                map.put("institute_mission",institute.getInstitute_mission());
                map.put("institute_director_msg",institute.getInstitute_director_msg());


                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void deleteInstitute(Institute institute,String institute_id,Context context, UserCallBack userCallBack){
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

                map.put("institute_id",institute.getInstitute_id());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void searchInstitute(Institute institute,String institute_id,Context context, UserCallBack userCallBack){
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

                map.put("institute_id",institute.getInstitute_id());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
