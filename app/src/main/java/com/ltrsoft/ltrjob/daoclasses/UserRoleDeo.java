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
import com.ltrsoft.ltrjob.pojoclass.User_Project_Task;
import com.ltrsoft.ltrjob.pojoclass.User_Role;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserRoleDeo {
    String fatchall = "";
    String create = "";
    String fach = "";
    String update = "";
    String delete = "";

    public void create(User_Role userRole, String user_id, String role_id, UserCallBack callBack, Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, create,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("Message");
                            if (msg.equals("100")) {
                                callBack.userSuccess(msg);

                            } else if (msg == "200") {
                                callBack.userError("created");

                            } else if (msg == "300") {
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
        }) {
            @Nullable
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("role_id",role_id.toString() );
                params.put("user_id",user_id.toString());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void fetchuserrole(User_Role userRole, String user_id, String role_id, String user_role_id,Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, fach,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);



                                // Do something with the fetched data, e.g., notify UI or update model
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("user_role_id", user_role_id.toString());
                params.put("user_id", user_id.toString());
                params.put("role_id",role_id.toString());


                // Add additional parameters if needed

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void getalluserrole(final Context context, User_Role  userRole, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);

                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(userRole);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                callBack.userError(error.toString());
            }
        }) {


        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }


    public void updateuserprojecttask(User_Role userRole, String role_id,String user_id,String user_role_id
            , Context context, UserCallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, update,
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
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("user_role_id",user_role_id.toString());
                hashMap.put("user_id", user_id.toString());
                hashMap.put("role_id",role_id.toString());


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }




    public void deleteuserrole(User_Role userRole , String user_role_id, Context context, UserCallBack callBack) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, delete,
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
                map.put("user_role_id", user_role_id.toString());


                return map;
            }
        };

    }






}
