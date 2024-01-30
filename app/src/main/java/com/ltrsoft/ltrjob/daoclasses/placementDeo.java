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
import com.ltrsoft.ltrjob.pojoclass.Mini_Project;
import com.ltrsoft.ltrjob.pojoclass.Placement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class placementDeo {

    String create="";
    String fach="";

    String fatchall="";

    String  update="";

    String  delete="";
    public  void createplacement(Placement placement, UserCallBack callBack, Context context, String userid, String date_placed, String placemet_role, String placement_package, String placed_through_ltr)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, create,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("Message");
                            if (msg.equals("100")) {
                                callBack.userSuccess(msg);

                            } else if (msg=="200") {
                                callBack.userError("created");

                            } else if (msg=="300") {
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
        }){
            @Nullable
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("placemet_role", placement.getPlacemet_role());
                params.put("date_placed", placement.getDate_placed());
                params.put(" placement_package",placement.getPlacement_package());
                params.put("placed_through_ltr",placement.getPlaced_through_ltr());

                params.put("job_id",String.valueOf(placement.getJob_id()));
                params.put("user_id",String.valueOf(placement.getUser_id()));


                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void fatchpplement( Placement placement ,String userid,Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, fach,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);


                                String date_placed = jsonObject.getString("date_placed");
                                String placemet_role = jsonObject.getString("date_placed");
                                String placement_package = jsonObject.getString("placement_package");
                                String placed_through_ltr = jsonObject.getString("placed_through_ltr");


                                Placement placement1=new Placement(date_placed,placemet_role,placement_package,placed_through_ltr);





                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("User_id",String.valueOf(placement.getUser_id()));
                hashMap.put("job_id",String.valueOf(placement.getJob_id()));
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }



    public void getall(final Context context ,Placement placement, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String date_placed = jsonObject.getString("date_placed");
                        String placemet_role = jsonObject.getString("date_placed");
                        String placement_package = jsonObject.getString("placement_package");
                        String placed_through_ltr = jsonObject.getString("placed_through_ltr");

                        Placement placement=new Placement(date_placed,placemet_role,placement_package,placed_through_ltr);



                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(placement);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                callBack.userError(error.toString());
            }
        }){


        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }



    public void updateplecemt(Placement placement, String userid, Context context, UserCallBack callBack){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, update,
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

                hashMap.put("placemet_role", placement.getPlacemet_role());
                hashMap.put("date_placed", placement.getDate_placed());
                hashMap.put(" placement_package",placement.getPlacement_package());
                hashMap.put("placed_through_ltr",placement.getPlaced_through_ltr());

                hashMap.put("job_id",String.valueOf(placement.getJob_id()));
                hashMap.put("user_id",String.valueOf(placement.getUser_id()));

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void deleteproject(Placement  placement,String userid,Context context,UserCallBack callBack){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, delete,
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
                HashMap<String,String>map=new HashMap<>();
                map.put("User_id",String.valueOf(placement.getUser_id()));
                map.put("job_id",String.valueOf(placement.getJob_id()));
                map.put("placement_id",String.valueOf(placement.getPlacement_id()));



                return map;
            }
        };
    }








}
