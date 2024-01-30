package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course_Schedule_Deo {

    private static String URL="http://job.ltr-soft.com/course_detail.php";
    private static String Create_URL="";
    private static String Update_URL="";
    private static String Delete_URL="";
    private static String ReadAll_URL="";
    Course course;

    ArrayList <Course> list=new ArrayList<>();

    public void getAllCourse(Context context,UserCallBack userCallBack){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ReadAll_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray=new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String course_id = jsonObject.getString("course_id");
                        String course_name = jsonObject.getString("course_name");
                        String course_duration = jsonObject.getString("course_duration");
                        String course_description = jsonObject.getString("course_description");

                        course=new Course(course_name,course_duration,course_description);

                    }
                } catch (JSONException e) {
                    userCallBack.userError(e.toString());
                    throw new RuntimeException(e);
                }
                userCallBack.userSuccess(course);

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

                return map;
            }
        };

    }

    public void getUser(String course_id,Context context,UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String course_id = jsonObject.getString("course_id");
                                String course_name = jsonObject.getString("course_name");
                                String course_duration = jsonObject.getString("course_duration");
                                String course_description = jsonObject.getString("course_description");

                                course=new Course(course_name,course_duration,course_description);

                            }
                        } catch (JSONException e) {
                            userCallBack.userSuccess(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(course);

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
                map.put("course_id",course_id);
                return map;
            }
        };
    }

    public void createCourse(Course course, String course_id, Context context, UserCallBack userCallBack){
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

                map.put("course_name",course.getCourse_name());
                map.put("course_duration",course.getCourse_duration());
                map.put("course_description",course.getCourse_description());
                return map;
            }
        };
    }

    public void updateCourse(Course course,String course_id,Context context,UserCallBack userCallBack){
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
                map.put("course_name",course.getCourse_name());
                map.put("course_duration",course.getCourse_duration());
                map.put("course_description",course.getCourse_description());
                return map;
            }
        };
    }

    public void deleteCourse(Course course,String userid,Context context, UserCallBack userCallBack){
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
                HashMap <String,String>map=new HashMap<>();
                map.put("course_id",course.getCourse_id());
                return map;
            }
        };
    }

    public void searchCourse(Course course,String userid,Context context, UserCallBack userCallBack){
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
                HashMap <String,String>map=new HashMap<>();
                map.put("course_id",course.getCourse_id());
                return map;
            }
        };
    }
}
