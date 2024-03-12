package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

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
import com.ltrsoft.ltrjob.pojoclass.Experience;
import com.ltrsoft.ltrjob.pojoclass.job;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kotlinx.coroutines.Job;

public class JobDashboard {
    String url = "https://job.ltr-soft.com/job/read_job.php";
    String Deleteurl="https://job.ltr-soft.com/Event/delete_event.php";
    String updateurl="https://job.ltr-soft.com/Event/event_update.php";
    String redid="https://job.ltr-soft.com/user_job_history_read.php";
    String create ="http://job.ltr-soft.com/user_job_history_insert.php";
    final ArrayList<job> experiences = new ArrayList<>();

    public void getall(final Context context , RecyclerView recyclerView, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String company_name = jsonObject.getString("company_name");
                        String company_email = jsonObject.getString("company_email");
                        String job_description = jsonObject.getString("job_description");
                        String company_phone = jsonObject.getString("company_phone");
                        String company_hoaddress=jsonObject.getString("company_hoaddress");
                        String job_category_name=jsonObject.getString("job_category_name");
                        String job_salary=jsonObject.getString("job_salary");
                        String job_position=jsonObject.getString("job_position");
                        String company_id=jsonObject.getString("company_id");
                        String company_logo = jsonObject.getString("company_logo");

                      job j=new job(company_name,company_email,job_description,company_phone,job_position,company_hoaddress,job_category_name,job_salary,company_id,company_logo);

                      //  Job experience  = new Job(imageurl,experience_company_name,experiance_start_date,experiance_end_date,experiance_payment,experiance_technology,experiance_project_name,experiance_position);

                        experiences.add(j);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(experiences);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                callBack.userError(error.toString());
            }
        }){

        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public  void  geteuser(  Context context, String company_id, UserCallBack callBack) {
        final ArrayList<job> experiences1 = new ArrayList<>();

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);

                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String company_name = jsonObject.getString("company_name");
                        String company_email = jsonObject.getString("company_email");
                        String job_description = jsonObject.getString("job_description");
                        String company_phone = jsonObject.getString("company_phone");
                        String company_hoaddress=jsonObject.getString("company_hoaddress");
//                        String job_category_name=jsonObject.getString("job_category_name");
                        String job_category_name="jo";
                        String job_salary=jsonObject.getString("job_salary");
                        String job_position=jsonObject.getString("job_position");
                        String company_id=jsonObject.getString("company_id");
                        String company_logo = jsonObject.getString("company_logo");


                        job certification1 = new job(company_name,company_email,job_description,company_phone,
                                job_position,company_hoaddress,job_category_name,job_salary,company_id,company_logo);

                        experiences1.add(certification1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(experiences1);

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



    public void Deleteexp(  String expid, Context context, UserCallBack callBack ){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, Deleteurl,
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
                HashMap<String,String> map=new HashMap<>();
                map.put("event_id",expid.toString());
                return map;


            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }







    public void updateexp( Experience experience, String expid, Context context, UserCallBack callBack ){

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

                hashMap.put("event_id",expid.toString());

                hashMap.put("company_name",experience.getExperience_company_name());
                hashMap.put("company_logo",experience.getExperiance_technology());
                hashMap.put("company_phone",experience.getExperiance_payment());
                hashMap.put("company_email",experience.getExperiance_position());
                hashMap.put("company_domain",experience.getExperiance_project_name());
                hashMap.put("company_hocity",experience.getExperiance_end_date());
                hashMap.put("company_hocountry",experience.getExperiance_end_date());

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void create( Context context, UserCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, create, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Save user session upon successful login
                //   saveUserSession(context, email, pass);
                callBack.userSuccess(response.toString());
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
                HashMap<String, String> map = new HashMap<>();
                map.put("job_id", "job-1");
                map.put("user_id", "user-17");
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }






}
