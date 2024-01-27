package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

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
    private static String USERCREATEURL = "https://job.ltr-soft.com/registration.php";
    public StringBuilder success = new StringBuilder();
    public User user;
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

public void getUser(String userid,Context context){

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

//                            user=new User( user_id,user_fname,user_mname,user_lname,user_email,user_smobile,
//                                user_pmobile,user_gender,user_DOB,user_photo,user_address,user_city,user_district,
//                                user_state,user_country,user_collegename,user_adhar,user_pan, user_linkedin_id,
//                                user_github_id,user_username,user_carier_objective,user_marital_status,"");


                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

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

public void createUser(User user,Context context , UserCallBack callBack){
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
                map.put("user_fname",user.getUser_fname());
                map.put("user_mname",user.getUser_mname());
                map.put("user_lname",user.getUser_lname());
//                map.put("",String.valueOf(user.getUser_email()));
//                map.put("",String.valueOf(user.getUser_password()));
//                map.put("",String.valueOf(user.getUser_address()));
//                map.put("",String.valueOf(user.getUser_smobile()));
              return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
}

public void updateUser(User user,Context context,UserCallBack userCallBack){

}

}


