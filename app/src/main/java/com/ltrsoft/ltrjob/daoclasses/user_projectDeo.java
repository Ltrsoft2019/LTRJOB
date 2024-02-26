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
import com.ltrsoft.ltrjob.pojoclass.Project;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Transaction_Mode;
import com.ltrsoft.ltrjob.pojoclass.User_Interpersonal_Skills;
import com.ltrsoft.ltrjob.pojoclass.User_Project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class user_projectDeo {

    String fatchuser = "https://job.ltr-soft.com/project/read_user_project.php";
    String create = "";
    String fach = "https://andromot.ltr-soft.com/public/user_pump_status/r_user_p_status.php";
    String update = "https://job.ltr-soft.com/project/update_project.php";
    String delete = "";

    public void create(User_Project userProject, String user_id,String project_id, UserCallBack callBack, Context context) {
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
                params.put("project_id",project_id.toString() );
                params.put("user_id",user_id.toString());




                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void fetchUserproject(User_Project userProject, String user_project_id, String user_id, String project_id,Context context) {
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
                params.put("user_project_id", user_project_id);
                params.put("user_id", "user-17");
                params.put("project_id",project_id.toString());


                // Add additional parameters if needed

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }







    public void getalluserproject(final Context context, RecyclerView recyclerView, UserCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchuser, new Response.Listener<String>() {
            final ArrayList<Project> projectArrayList = new ArrayList<>();

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String name = jsonObject.getString("user_fname");
                        String email = jsonObject.getString("user_email");
                        String projectname = jsonObject.getString("project_name");
                        String project_description = jsonObject.getString("project_description");
                        String startDate = jsonObject.getString("project_start_date");
                        String endDate = jsonObject.getString("project_end_date");
                        String technology = jsonObject.getString("project_technologies");

                        Project project = new Project(name, email, endDate, projectname, project_description, startDate, endDate, technology);
                        projectArrayList.add(project);
                    }
                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(projectArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.userError(error.toString());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("user_id", "user-17");
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);

    }









    public void updateusertechnicalskill(  String pname,String sdate,String edate,String categery,String description,String technology
            , Context context, UserCallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, update,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {
                            Toast.makeText(context, ""+response.toString(), Toast.LENGTH_SHORT).show();
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

                hashMap.put("user_id","user-17");
                hashMap.put("project_id","project-1" );

                hashMap.put("project_technologie",technology);
                hashMap.put("project_category",categery);
                hashMap.put("project_description",description);
                hashMap.put("start_dat",sdate);
                hashMap.put("end_date",edate);





                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }









    public void deleteuserlnaguge(User_Project userProject , String user_project_id, Context context, UserCallBack callBack) {


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
                map.put("user_interpersonal_skill_id", user_project_id.toString());


                return map;
            }
        };

    }











}
