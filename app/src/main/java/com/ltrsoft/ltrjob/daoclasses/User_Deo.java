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
import com.ltrsoft.ltrjob.pojoclass.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class User_Deo {
    public String LOGINURL = "https://rj.ltr-soft.com/public/police_api/login/user_login.php";
    public String response = "";
    public String USER_PROFILE_READ_URL = "";
    public String URL = "";
    public String UpdateUrl="https://job.ltr-soft.com/User_Detail/user_update.php";
    private static String USERCREATEURL = "https://job.ltr-soft.com/User_Detail/user_insert.php";


    public StringBuilder success = new StringBuilder();
    public User user;
    String userid;
    //give create update login delete getuser

    public StringBuilder getSuccess() {
        return success;
    }
    public void setSuccess(StringBuilder success) {
        this.success = success;
    }

    public void loginUser(String email, String password, Context context, UserCallBack callBack) {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, LOGINURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("Message");
                            if (msg.equals("100")) {
                                callBack.userSuccess(msg);

                            } else if (msg=="200") {
                                callBack.userError("User Not FOund");

                            } else if (msg=="300") {
                                callBack.userError("Login Failed");
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
                params.put("email", email);
                params.put("password", password);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

public void getUser(String userid,Context context,UserCallBack callBack){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, USER_PROFILE_READ_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String user_id=jsonObject.getString("user_id");
                                String user_fname = jsonObject.getString("user_fname");
                                String user_mname = jsonObject.getString("user_mname");
                                String user_lname = jsonObject.getString("user_lname");
                                String user_email= jsonObject.getString("user_email");
                                String user_smobile=jsonObject.getString("user_smobile");
                                String user_pmobile= jsonObject.getString("user_pmobile");
                                String user_gender= jsonObject.getString("user_gender");
                                String user_DOB=jsonObject.getString("user_DOB");
                                String user_photo= jsonObject.getString("user_photo");
                                String user_address = jsonObject.getString("user_address");
                                String user_city = jsonObject.getString("user_city");
                                String user_district = jsonObject.getString("user_district");
                                String user_state = jsonObject.getString("user_state");
                                String user_country = jsonObject.getString("user_country");
                                String user_collegename= jsonObject.getString("user_collegename");
                                String user_adhar = jsonObject.getString("user_adhar");
                                String user_pan =jsonObject.getString("user_pan");
                                String user_linkedin_id =jsonObject.getString("user_linkedin_id");
                                String user_github_id = jsonObject.getString("user_github_id");
                                String user_username = jsonObject.getString("user_username");
                                String user_carier_objective =jsonObject.getString("user_carier_objective");
                                String user_marital_status = jsonObject.getString("user_marital_status");

                            user=new User( user_fname,user_mname,user_lname,user_email,user_smobile,
                                user_pmobile,user_gender,user_DOB,user_photo,user_address,user_city,user_district,
                                user_state,user_country,user_collegename,user_adhar,user_pan, user_linkedin_id,
                                user_github_id,user_username,user_carier_objective,user_marital_status,user_carier_objective);
                            }
                        } catch (JSONException e) {
                            callBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        callBack.userSuccess(user);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("user_id", userid);
                return hashMap;
            }
        };
    RequestQueue requestQueue= Volley.newRequestQueue(context);
    requestQueue.add(stringRequest);
//    return user;
}

public void createUser(String fname,String lname,String email,String mobile,String pass,Context context , UserCallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, USERCREATEURL, new Response.Listener<String>() {
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
                HashMap <String , String>map= new HashMap<>();
                map.put("user_fname",fname);
                map.put("user_mname",lname);
                map.put("user_email",email);
                map.put("user_smobile ",mobile);
                map.put("user_password",pass);

              return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
}

public void updateUser(User user,String userid,Context context,UserCallBack callBack){
    StringRequest stringRequest= new StringRequest(Request.Method.POST, UpdateUrl,
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
            hashMap.put("user_id",userid);
            hashMap.put("user_fname",user.getUser_lname());
//            hashMap.put("user_mname",user.getUser_mname());
//            hashMap.put("user_lname",user.getUser_lname());
            hashMap.put("user_email",user.getUser_email());
            hashMap.put("user_smobile",user.getUser_smobile());
//            hashMap.put("user_pmobile",user.getUser_pmobile());
            hashMap.put("user_gender",user.getUser_gender());
            hashMap.put("user_DOB",user.getUser_DOB());
//            hashMap.put("user_photo",user.getUser_photo());
            hashMap.put("user_address",user.getUser_address());
//
//            hashMap.put("user_city",user.getUser_city());
//            hashMap.put("user_district",user.getUser_district());
//            hashMap.put("user_state",user.getUser_state());
//            hashMap.put("user_country",user.getUser_country());
//            hashMap.put("user_collegename",user.getUser_collegename());
            hashMap.put("user_adhar",user.getUser_adhar());
//            hashMap.put("user_pan",user.getUser_pan());
//            hashMap.put("user_linkedin_id",user.getUser_linkedin_id());
//            hashMap.put("user_github_id",user.getUser_github_id());
//            hashMap.put("user_username",user.getUser_username());
//            hashMap.put("user_password",user.getUser_password());
//            hashMap.put("user_carier_objective",user.getUser_carier_objective());
//            hashMap.put("user_marital_status",user.getUser_marital_status());

            return hashMap;
        }
    };
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    requestQueue.add(stringRequest);
}

public void deleteUser(User user,String userid,Context context,UserCallBack callBack){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL,
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
                map.put("User_id",user.getUser_id());
                return map;
            }
        };
}



}


