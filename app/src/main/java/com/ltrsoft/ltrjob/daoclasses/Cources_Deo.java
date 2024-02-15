package com.ltrsoft.ltrjob.daoclasses;
import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.Adpter.CourseCardAdapter;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

import com.ltrsoft.ltrjob.pojoclass.Course_Class;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
public class Cources_Deo{

    String url = "https://job.ltr-soft.com/course_card.php";
    String Deleteurl="https://job.ltr-soft.com/Event/delete_event.php";
    String updateurl="https://job.ltr-soft.com/Event/event_update.php";
    String redid="https://job.ltr-soft.com/course_detail.php";

    final ArrayList<Course_Class> courcesArrayList = new ArrayList<>();

    public void fetchCources(final Context context, RecyclerView recyclerView, UserCallBack callBack) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String course_id, course_name, course_type, course_duration;
                        try {
                            JSONArray json = new JSONArray(response);
                            for (int i = 0; i < json.length(); i++) {
                                JSONObject jsonObject1 = json.getJSONObject(i);
                                course_id = jsonObject1.getString("course_id");
                                course_name = jsonObject1.getString("course_name");
                                course_duration = jsonObject1.getString("course_duration");
                              String  created_at=jsonObject1.getString("created_at");
                              //  course_type = "full course";
                                Course_Class coursesDataClass = new Course_Class(course_id, course_name, course_duration, null, null, null, null,created_at);
                                courcesArrayList.add(coursesDataClass);
                            }

                            // Set up RecyclerView here, after successfully fetching data
                            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                            CourseCardAdapter adapter = new CourseCardAdapter(courcesArrayList);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callBack.userError(error.toString());
                        Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(stringRequest);
    }



        public  void  getcorces( final Context context, RecyclerView recyclerView,String course_id, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String course_id, course_name, course_type, course_duration;

                        course_id = jsonObject.getString("course_id");
                        course_name = jsonObject.getString("course_name");
                        course_duration = jsonObject.getString("course_description");
                        String  created_at=jsonObject.getString("course_duration");
                        Course_Class coursesDataClass = new Course_Class(course_id, course_name, course_duration, null, null, null, null,created_at);
                        courcesArrayList.add(coursesDataClass);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(courcesArrayList);

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

                hashMap.put("course_id","course-1");

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public  void  getcorces1( final Context context,String course_id, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String course_id, course_name, course_type, course_duration;

                        course_id = jsonObject.getString("course_id");
                        course_name = jsonObject.getString("course_name");
                        course_duration = jsonObject.getString("course_description");
                        String  created_at=jsonObject.getString("course_duration");
                        Course_Class coursesDataClass = new Course_Class(course_id, course_name, course_duration, null, null, null, null,created_at);
                        courcesArrayList.add(coursesDataClass);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(courcesArrayList);

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

                hashMap.put("course_id","course-1");

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }






    public void Deletecorces(  String userid, Context context, UserCallBack callBack ){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, Deleteurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        callBack.userSuccess(response.toString());
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
                HashMap<String,String> map=new HashMap<>();
                map.put("event_id",userid.toString());
                return map;


            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }







    public void updatecources( String corceid, Context context, UserCallBack callBack ){

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

                Course_Class firstCourse = courcesArrayList.get(0);


//                hashMap.put("course_name", firstCourse.getCourseName());
//                hashMap.put("course_duration", firstCourse.getCourseDuration());

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
