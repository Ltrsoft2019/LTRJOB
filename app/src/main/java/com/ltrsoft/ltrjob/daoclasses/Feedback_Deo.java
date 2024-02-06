package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
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
import com.ltrsoft.ltrjob.pojoclass.Feedback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feedback_Deo {

    private static String URL="https://job.ltr-soft.com/feedback/feedback_cat_read.php";
    private static String Create_URL="https://job.ltr-soft.com/feedback/feedback_insert.php";
    private static String Update_URL="https://job.ltr-soft.com/feedback/feedback_user_read.php";
    private static String Delete_URL="https://job.ltr-soft.com/feedback/feedback_user_read.php";

    private static String ReadAll_URL="https://job.ltr-soft.com/feedback/feedback_user_read.php";
    String user_id;
    Feedback feedback;

    public ArrayList<Feedback>list=new ArrayList<>();

    public void getAllFeedback(Context context,UserCallBack userCallBack){

        StringRequest stringRequest= new StringRequest(Request.Method.POST, ReadAll_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String feedback_description= jsonObject.getString("feedback_description");

                                feedback=new Feedback(feedback_description);
                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(feedback);
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
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }

    public void getFeedback(String user_id, Context context){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String feedback_description= jsonObject.getString("feedback_description");

                                Feedback feedback=new Feedback(feedback_description);
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
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("user_id",user_id);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void createFeedback(Feedback feedback, String user_id,Context context, UserCallBack userCallBack){
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
                map.put("feedback_description",feedback.getFeedback_description());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void updateFeedback(Feedback feedback, String user_id,Context context, UserCallBack userCallBack){
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
                map.put("feedback_description",feedback.getFeedback_description());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void deleteFeedback(String user_id, Context context){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, Delete_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String feedback_description= jsonObject.getString("feedback_description");

                                Feedback feedback=new Feedback(feedback_description);
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
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("user_id",user_id);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void searchFeedback(Feedback feedback, String user_id,Context context, UserCallBack userCallBack){
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
                map.put("user_id",feedback.getUser_id());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void feedback(String des,String sub,String cname, Context context, UserCallBack userCallBack) {
        String insertUrl = "https://job.ltr-soft.com/feedback/feedback_insert.php";
        StringRequest insertRequest = new StringRequest(Request.Method.POST, insertUrl,
                response -> {
                    Log.d("Insert Response", response);
                    userCallBack.userSuccess(response);
                },
                error -> {
                    Log.e("Volley Error", "Error: " + error.getMessage());
                    Toast.makeText(context, "Error inserting data", Toast.LENGTH_SHORT).show();
                    userCallBack.userError(error.toString());
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", "user-17");
                params.put("feedback_subject",sub);
                params.put("feedback_description",des);
                params.put("feedback_category_name",cname);
                params.put("feedback_category_id","feedback_cat-1");
                // Add other parameters
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(insertRequest);
    }

    public void fetchFeedbackCategoryNames(Context context, UserCallBack callBack) {
        String url = "https://job.ltr-soft.com/feedback/feedback_read.php";

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Server Response", response);

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            List<String> feedbackCategories = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.getString("feedback_category_name");
                                feedbackCategories.add(name);
                            }

                            // Handle your feedbackCategories data as needed
                            callBack.userSuccess(feedbackCategories);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                            callBack.userError("Error parsing JSON");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Error", "Error: " + error.getMessage());
                        Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show();
                        callBack.userError("Error fetching data");
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
}
