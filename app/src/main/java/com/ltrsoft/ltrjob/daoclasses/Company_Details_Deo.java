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
import com.ltrsoft.ltrjob.pojoclass.Account_Detail;
import com.ltrsoft.ltrjob.pojoclass.Company_Details;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Company_Details_Deo {

    private static String URL="http://job.ltr-soft.com/company_detail.php";
    private static String Create_URL="";
    private static String Update_URL="";
    private static String Delete_URL="";
    private static String ReadAll_URL="";

    Company_Details company_details;

    ArrayList<Company_Details> list=new ArrayList<>();


    public void getAllDetail(Context context, UserCallBack userCallBack){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String company_name = jsonObject.getString("company_name");
                                String company_logo = jsonObject.getString("company_logo");
                                String company_email = jsonObject.getString("company_email");
                                String company_phone = jsonObject.getString("company_phone");
                                String company_domain = jsonObject.getString("company_domain");
                                String company_hoaddress = jsonObject.getString("company_hoaddress");
                                String company_hocity = jsonObject.getString("company_hocity");
                                String company_hodistrict = jsonObject.getString("company_hodistrict");
                                String company_hostate = jsonObject.getString("company_hostate");
                                String company_hocountry = jsonObject.getString("company_hocountry");

                                company_details=new Company_Details(company_name,company_logo,company_email,company_phone,company_domain,
                                        company_hoaddress,company_hocity,company_hodistrict,company_hostate,company_hocountry );



                            }

                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(company_details);
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
    }

    public void getDetail(String company_id,Context context, UserCallBack userCallBack){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String company_name = jsonObject.getString("company_name");
                                String company_logo = jsonObject.getString("company_logo");
                                String company_email = jsonObject.getString("company_email");
                                String company_phone = jsonObject.getString("company_phone");
                                String company_domain = jsonObject.getString("company_domain");
                                String company_hoaddress = jsonObject.getString("company_hoaddress");
                                String company_hocity = jsonObject.getString("company_hocity");
                                String company_hodistrict = jsonObject.getString("company_hodistrict");
                                String company_hostate = jsonObject.getString("company_hostate");
                                String company_hocountry = jsonObject.getString("company_hocountry");

                                company_details=new Company_Details(company_name,company_logo,company_email,company_phone,company_domain,
                                        company_hoaddress,company_hocity,company_hodistrict,company_hostate,company_hocountry );

                            }

                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(company_details);
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
                map.put("company_id",company_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void createDetail(Company_Details company_details,Context context,UserCallBack userCallBack){
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

                map.put("company_name",company_details.getCompany_name());
                map.put("company_logo",company_details.getCompany_logo());
                map.put("company_email",company_details.getCompany_email());
                map.put("company_phone",company_details.getCompany_phone());
                map.put("company_domain",company_details.getCompany_domain());
                map.put("company_hoaddress",company_details.getCompany_hoaddress());
                map.put("company_hocity",company_details.getCompany_hocity());
                map.put("company_hodistrict",company_details.getCompany_hodistrict());
                map.put("company_hostate",company_details.getCompany_hostate());
                map.put("company_hocountry",company_details.getCompany_hocountry());

                return map;
            }
        };
    }

    public void updateDetail(Company_Details company_details,String company_id,Context context,UserCallBack userCallBack){
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

                map.put("company_name",company_details.getCompany_name());
                map.put("company_logo",company_details.getCompany_logo());
                map.put("company_email",company_details.getCompany_email());
                map.put("company_phone",company_details.getCompany_phone());
                map.put("company_domain",company_details.getCompany_domain());
                map.put("company_hoaddress",company_details.getCompany_hoaddress());
                map.put("company_hocity",company_details.getCompany_hocity());
                map.put("company_hodistrict",company_details.getCompany_hodistrict());
                map.put("company_hostate",company_details.getCompany_hostate());
                map.put("company_hocountry",company_details.getCompany_hocountry());

                return map;
            }
        };
    }

    public void deleteDetail(Company_Details company_details,String company_id,Context context,UserCallBack userCallBack){
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

                map.put("company_id",company_details.getCompany_id());

                return map;
            }
        };
    }

    public void searchDetail(Company_Details company_details,String company_id,Context context,UserCallBack userCallBack){
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

                map.put("company_id",company_details.getCompany_id());

                return map;
            }
        };
    }


}
