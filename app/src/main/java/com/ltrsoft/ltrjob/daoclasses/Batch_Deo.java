package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
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
import com.ltrsoft.ltrjob.Adpter.Batch_card_adapter;
import com.ltrsoft.ltrjob.Adpter.CourseCardAdapter;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.AwardCategory;
import com.ltrsoft.ltrjob.pojoclass.Batch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Batch_Deo {
    private static String URL="https://job.ltr-soft.com/batch/read_batch_id.php";
    private static String Create_URL="https://job.ltr-soft.com/enrollment/create_enrollment.php";
    private static String Update_URL="";
    private static String Delete_URL="";
    private static String Readone_URL="https://job.ltr-soft.com/batch/batch_by_id.php";
    Batch batch;
    ArrayList<Batch> list=new ArrayList<>();

    public void getoneBatch(Context context,String batch_id,UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST,Readone_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String batch_name = jsonObject.getString("batch_name");
                                String batch_time = jsonObject.getString("batch_time");
                                String batch_start_date = jsonObject.getString("batch_start_date");
                                String batch_end_date = jsonObject.getString("batch_end_date");
                                String one_time_fees = jsonObject.getString("one_time_fees");
//                                String fees_with_installmaent = jsonObject.getString("fees_with_installmaent");
                                String fees_with_installmaent = "jjjjjj";

                                batch =new Batch(batch_name,batch_time,batch_start_date,batch_end_date,one_time_fees,fees_with_installmaent);
                                list.add(batch);
                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(list);

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
                map.put("batch_id",batch_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void getBatch(String course_id, Context context, UserCallBack userCallBack){

        ArrayList<Batch>list1=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.POST,URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            System.out.println("Response= "+response.toString());

                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String batch_name = jsonObject.getString("batch_name");
                                String batch_time = jsonObject.getString("batch_time");
                                String batch_start_date = jsonObject.getString("batch_start_date");
                                String batch_end_date = jsonObject.getString("batch_end_date");
                                String one_time_fees = jsonObject.getString("one_time_fees");
                               // String fees_with_installmaent = jsonObject.getString("feesWithInstallmaent");
                                String fees_with_installmaent = "jjjj";

                                batch =new Batch(batch_name,batch_time,batch_start_date,batch_end_date,one_time_fees,fees_with_installmaent);
                                list1.add(batch);

                            }

//                            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//                            Batch_card_adapter adapter = new Batch_card_adapter(list1);
//                            recyclerView.setLayoutManager(layoutManager);
//                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);

                        }
                        userCallBack.userSuccess(list1);

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
                map.put("course_id",course_id);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }




    
    public void createBatch(Batch batch,String user_id,String batch_id, Context context, UserCallBack userCallBack){
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
                map.put("batch_id",batch.getBatch_id());
                map.put("user_id",batch.getUser_id());
                map.put("batch_name",batch.getBatch_name());
                map.put("batch_time",batch.getBatch_time());
                map.put("batch_start_date",batch.getBatch_start_date());
                map.put("batch_end_date",batch.getBatch_end_date());
                map.put("one_time_fees",batch.getOne_time_fees());
                map.put("fees_with_installmaent",batch.getFees_with_installmaent());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void upadateBatch(Batch batch,String user_id,String batch_id, Context context, UserCallBack userCallBack){
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

                map.put("batch_name",batch.getBatch_name());
                map.put("batch_time",batch.getBatch_time());
                map.put("batch_start_date",batch.getBatch_start_date());
                map.put("batch_end_date",batch.getBatch_end_date());
                map.put("one_time_fees",batch.getOne_time_fees());
                map.put("fees_with_installmaent",batch.getFees_with_installmaent());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void deleteBatch(Batch batch,String user_id,String batch_id, Context context, UserCallBack userCallBack){
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

                map.put("user_id",batch.getUser_id());
                map.put("batch_id",batch.getBatch_id());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void searchBatch(Batch batch,String user_id,String batch_id, Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST,URL,
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
                map.put("user_id",batch.getUser_id());
                map.put("batch_id",batch.getBatch_id());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
