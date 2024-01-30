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

import com.ltrsoft.ltrjob.pojoclass.Research_Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class research_categoryDeo {


    String fatchall="";
    String create="";
    String fach="";
    String update="";
    String delete="";

    public  void create(Research_Category researchCategory, UserCallBack callBack, Context context)
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
                params.put("research_category_name",researchCategory.getResearch_category_name());


                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void fatchreasrch( Research_Category researchCategory,String rearschcategoery,Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, fach,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);


                                int research_category_id = Integer.parseInt(jsonObject.getString("research_category_id"));
                                String research_category_name = jsonObject.getString("research_category_name");

                                Research_Category referenceBooks1 = new Research_Category(research_category_id, research_category_name);

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
                hashMap.put("research_category_id", rearschcategoery.toString());
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void getallreasaarch(final Context context , Research_Category researchCategory, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        int research_category_id = Integer.parseInt(jsonObject.getString("research_category_id"));
                        String research_category_name = jsonObject.getString("research_category_name");

                        Research_Category referenceBooks1 = new Research_Category(research_category_id, research_category_name);

                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(researchCategory);
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


    public void updatereasrch(Research_Category researchCategory, String research_category_id
            , Context context, UserCallBack callBack){
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

                hashMap.put("reference_book_id",research_category_id.toString());
                hashMap.put("research_category_name",researchCategory.getResearch_category_name());


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void deleterearsh( Research_Category researchCategory,String reasrchid,Context context,UserCallBack callBack){


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
                map.put("research_category_id",reasrchid.toString());



                return map;
            }
        };
    }


}
