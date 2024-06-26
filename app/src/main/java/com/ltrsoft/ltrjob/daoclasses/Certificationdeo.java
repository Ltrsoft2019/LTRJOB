package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Certification;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Certificationdeo {
    String certi = "http://job.ltr-soft.com/Certifications/certification_insert.php";
    String getall = "";

    String redid = "https://job.ltr-soft.com/Certifications/certification_read.php";

    String Deleteurl = "http://job.ltr-soft.com/Certifications/certification_update.php";

    String updateurl="http://job.ltr-soft.com/Certifications/certification_update.php";
    final ArrayList<Certification> certifications = new ArrayList<>();

    public void create(Certification certification, Context context, UserCallBack callBack, String userid) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, certi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
params.put("user_id",userid.toString());
                params.put("certification_title", certification.getCertification_title());
                params.put("certification_from", certification.getCertification_from());
                params.put("certification_year", certification.getCertification_year());
                params.put("certification_number", certification.getCertification_number());

                return params;

            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }






    public void getall(Certification certification, Context context, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, getall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String certification_id = jsonObject.getString("event_id");
                        String certification_title = jsonObject.getString("event_id");
                        String certification_year = jsonObject.getString("event_description");
                        String certification_from = jsonObject.getString("event_name");
                        String certification_number = jsonObject.getString("event_guest");

                        String path = jsonObject.getString("photo_path");
                        String imageurl = "https://job.ltr-soft.com/Certifications/" + path;


                        Certification certification1 = new Certification( certification_id, certification_title, certification_year, certification_from, certification_number);
                        certifications.add(certification1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(certifications);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }





    public void getuser(final Context context, RecyclerView recyclerView, UserCallBack callBack) {

//      String  userid="user-17";
        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);

                    for (int i = 0; i < json.length(); i++) {

                        JSONObject jsonObject = json.getJSONObject(i);
                        String certification_id = jsonObject.getString("created_at");
                        String certification_title = jsonObject.getString("certification_title");
                        String certification_year = jsonObject.getString("certification_year");
                        String certification_from = jsonObject.getString("certification_from");
                        String certification_number = jsonObject.getString("certification_number");
                        Certification certification1 = new Certification(certification_id, certification_title, certification_year, certification_from, certification_number);
                        certifications.add(certification1);

                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(certifications);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("user_id", "user-17");

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }





    public void delete(Context context, Certification certification) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Deleteurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
               // map.put("certification_id", certification.getCertificationId());
                return map;


            }


        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);

    }







    public  void updatecertification( String title, String givenBy,String  number, String date,Context context,UserCallBack callBack){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, updateurl,
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

                hashMap.put("user_id","user-17");
                hashMap.put("certification_id","certificate-30");


                hashMap.put("certification_title",title);
                hashMap.put("certification_from",givenBy);
                hashMap.put("certification_year",date);
                hashMap.put("certification_number",number);

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    }

