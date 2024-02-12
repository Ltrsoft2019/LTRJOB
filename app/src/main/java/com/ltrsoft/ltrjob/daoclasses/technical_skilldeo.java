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
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.ltrsoft.ltrjob.pojoclass.Status;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class technical_skilldeo {


    String fatchall = "";
    String create = "";
    String redid = "https://job.ltr-soft.com/Technical_skill/user_id_technical_skill.php";
    String update = "";
    String delete = "";
    final ArrayList<Technical_Skill> technicallist = new ArrayList<>();


    public void create(Technical_Skill technicalSkill, UserCallBack callBack, Context context) {
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
                params.put("technical_skill_name", technicalSkill.getTechnical_skill_name());



                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public  void  fatchtechnicalskill( final Context context , RecyclerView recyclerView, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String technical_skill_name = jsonObject.getString("technical_skill_name");

                        Technical_Skill technicalSkill = new Technical_Skill(technical_skill_name);
                       // Toast.makeText(context, "your name"+technical_skill_name.toString(), Toast.LENGTH_SHORT).show();
                        technicallist.add(technicalSkill);
//                        Toast.makeText(context, ""+technicallist.toString(), Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(technicallist);

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


                hashMap.put("user_id","user-17");

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }











    public void getalltechnicalskill(final Context context, Technical_Skill technicalSkill, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String technical_skill_name = jsonObject.getString("technical_skill_name");

                        Technical_Skill salaryDetails1 = new Technical_Skill(technical_skill_name);

                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(technicalSkill);
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




    public void updatetechnicalskill(Technical_Skill technicalSkill, String technicalid
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

                hashMap.put("technical_skill_name", technicalSkill.getTechnical_skill_name());
                hashMap.put("technical_skill_id", technicalid.toString());


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void deletetechnicalskill(Technical_Skill technicalSkill, String technical_skill_id, Context context, UserCallBack callBack) {


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
                map.put("state_id", technical_skill_id.toString());


                return map;
            }
        };

    }


















}
