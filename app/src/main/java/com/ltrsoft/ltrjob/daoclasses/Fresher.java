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
import com.ltrsoft.ltrjob.pojoclass.companyDashboard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fresher {


        String url = "http://job.ltr-soft.com/Event/event_photo.php";
        String Deleteurl="https://job.ltr-soft.com/Event/delete_event.php";
        String updateurl="https://job.ltr-soft.com/Event/event_update.php";
        String redid="https://job.ltr-soft.com/Event/read_by_id.php";


        final ArrayList<companyDashboard> companyDashboards = new ArrayList<>();




        public void fetchjobData(final Context context , RecyclerView recyclerView, UserCallBack
        callBack) {




        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String company_name = jsonObject.getString("event_description");
                        String company_email = jsonObject.getString("event_guest");
                        String company_phone = jsonObject.getString("event_venue");
                        String date_time = jsonObject.getString("event_date_time");
                        String company_domain = jsonObject.getString("event_duration");

                        String company_hocity=jsonObject.getString("company_hocity");
                        String company_hodistrict=jsonObject.getString("company_hodistrict");
                        String company_hocountry=jsonObject.getString("company_hocountry");


                        String company_logo = jsonObject.getString("photo_path");
                        String imageurl = "https://institute.ltr-soft.com/event_photo/" + company_logo;


                        companyDashboard c  = new companyDashboard(company_name,company_logo,company_email,company_phone,company_domain,company_hocity,company_hodistrict,company_hocountry);

                        companyDashboards.add(c);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(companyDashboards);
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







        public  void  getcompany(  String companyid, Context context, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String company_name = jsonObject.getString("event_description");
                        String company_email = jsonObject.getString("event_guest");
                        String company_phone = jsonObject.getString("event_venue");
                        String date_time = jsonObject.getString("event_date_time");
                        String company_domain = jsonObject.getString("event_duration");

                        String company_hocity=jsonObject.getString("company_hocity");
                        String company_hodistrict=jsonObject.getString("company_hodistrict");
                        String company_hocountry=jsonObject.getString("company_hocountry");


                        String company_logo = jsonObject.getString("photo_path");
                        String imageurl = "https://institute.ltr-soft.com/event_photo/" + company_logo;


                        companyDashboard c  = new companyDashboard(company_name,company_logo,company_email,company_phone,company_domain,company_hocity,company_hodistrict,company_hocountry);

                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(companyDashboards);

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

                // Add parameters here, for example, if you want to fetch data for event ID 123
                hashMap.put("event_id", companyid.toString());

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }







        public void Deletecompany(  String companyid, Context context, UserCallBack callBack ){


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
                map.put("event_id",companyid.toString());
                return map;


            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }







        public void updateevent( companyDashboard companyDashboard1, String comanyid, Context context, UserCallBack callBack ){

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

                hashMap.put("event_id",comanyid.toString());

                hashMap.put("company_name",companyDashboard1.getCompany_name());
                hashMap.put("company_logo",companyDashboard1.getCompany_logo());
                hashMap.put("company_phone",companyDashboard1.getCompany_phone());
                hashMap.put("company_email",companyDashboard1.getCompany_email());
                hashMap.put("company_domain",companyDashboard1.getCompany_domain());
                hashMap.put("company_hocity",companyDashboard1.getCompany_hocity());
                hashMap.put("company_hocountry",companyDashboard1.getCompany_hocountry());
                hashMap.put("company_hodistrict",companyDashboard1.getCompany_hodistrict());

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    }

