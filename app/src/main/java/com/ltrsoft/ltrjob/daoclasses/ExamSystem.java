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
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.ltrsoft.ltrjob.pojoclass.Exam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExamSystem {
    final ArrayList<Exam> exams = new ArrayList<>();

    // Assuming you have a correct URL for your API
    private static final String EXAM_GET_ALL_URL = "https://your-api-endpoint.com/exams/getall";
    String getresult = "";
    String Deleteurl="";

    public void examgetall(final Context context, RecyclerView recyclerView, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, EXAM_GET_ALL_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);

                        String id = jsonObject.getString("exam_name");
                        String exam_name = jsonObject.getString("exam_name");

                        String exam_id = jsonObject.getString("exam_name");
                        String total_marks = jsonObject.getString("total_marks");
                        String exam_start_date = jsonObject.getString("exam_start_date");
                        String exam_time = jsonObject.getString("exam_time");
                        String exam_description = jsonObject.getString("exam_description");
                        String passing_marks = jsonObject.getString("passing_marks");

                        Exam exam = new Exam(Integer.parseInt(id), Integer.parseInt(exam_id), exam_name, total_marks, exam_start_date, exam_time, exam_description, passing_marks);

                        exams.add(exam);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(exams);
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


    public void getuserexam(Exam exam, String examid, Context context, UserCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, getresult, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String total_marks = jsonObject.getString("total_marks");


                        Exam modelImage = new Exam(total_marks);

                        exams.add(modelImage);
                    }
                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(exams);
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

                hashMap.put("exam_id", examid);

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }


    public void updatuesr(Exam eventClass, String userid, Context context, UserCallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getresult, new Response.Listener<String>() {
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
                callBack.userError("error");
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("exam_id", userid);




                return hashMap;


            }

        };
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);
    }



    public void deleteexam(Exam exam, String examid, Context context, UserCallBack callBack ){

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
                map.put("event_id",examid.toString());
                return map;



            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    }


