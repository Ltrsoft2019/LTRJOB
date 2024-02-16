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
import com.ltrsoft.ltrjob.pojoclass.Award;
import com.ltrsoft.ltrjob.pojoclass.Country;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import com.ltrsoft.ltrjob.pojoclass.Workshop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Workshop_Deo {

    private static String ReadAll_URL="https://job.ltr-soft.com/Workshop/user_workshop.php";
    private static String Create_URL="";
    private static String Update_URL="";
    private static String Delete_URL="";
   // private static String ReadAll_URL="";

    public void getalluserAward(final Context context, RecyclerView recyclerView, UserCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, ReadAll_URL, new Response.Listener<String>() {
            final ArrayList<Workshop> workshopArrayList = new ArrayList<>();

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {


                        JSONObject jsonObject = json.getJSONObject(i);
                        String workshop_name = jsonObject.getString("workshop_name");
                        String workshop_venue = jsonObject.getString("workshop_venue");
                        String workshop_level = jsonObject.getString("workshop_level");
                        String workshop_type_name = jsonObject.getString("workshop_type_name");
                       // String awardlevelname = jsonObject.getString("award_level_name");

                        Toast.makeText(context, "" + workshop_name.toString(), Toast.LENGTH_SHORT).show();

                        Workshop award1 = new Workshop(workshop_name, workshop_venue, workshop_level, workshop_type_name);
                        workshopArrayList.add(award1);

                    }
                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(workshopArrayList);
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


    public void getWorkshop(String workshop_id,Context context, UserCallBack userCallBack){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Update_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String workshop_name = jsonObject.getString("workshop_name");
                                String workshop_venue = jsonObject.getString("workshop_venue");
                                String workshop_level = jsonObject.getString("workshop_level");
                                String workshop_date = jsonObject.getString("workshop_date");

                                Workshop workshop =new Workshop(workshop_name,workshop_venue,workshop_level,workshop_date);

                            }
                        } catch (JSONException e) {
                            userCallBack.userError(e.toString());
                            throw new RuntimeException(e);
                        }
                        userCallBack.userSuccess(context);

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

               // map.put("workshop_id",Workshop());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void createWorkshop(Workshop workshop,String workshop_id,Context context, UserCallBack userCallBack){
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

                map.put("workshop_name",workshop.getWorkshop_name());
                map.put("workshop_venue",workshop.getWorkshop_venue());
                map.put("workshop_level",workshop.getWorkshop_level());
                map.put("workshop_date",workshop.getWorkshop_date());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateWorkshop(Workshop workshop,String workshop_id,Context context, UserCallBack userCallBack){
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

                map.put("workshop_name",workshop.getWorkshop_name());
                map.put("workshop_venue",workshop.getWorkshop_venue());
                map.put("workshop_level",workshop.getWorkshop_level());
                map.put("workshop_date",workshop.getWorkshop_date());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void deleteWorkshop(Workshop workshop,String workshop_id,Context context, UserCallBack userCallBack){
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

                map.put("workshop_id",workshop.getWorkshop_id());


                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
