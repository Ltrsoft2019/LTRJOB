package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.NewsClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class News {
   String DASHBOARD_IMG_URL="";
    public ArrayList<NewsClass> listofimg = new ArrayList<>();



    public void getall(Context context, UserCallBack userCallBack ) {


        JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.POST, DASHBOARD_IMG_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String img_path = jsonObject.getString("notification_photo_path");
                        System.out.println("path = " + img_path);
                        //listofimg.add(new DashboardImageClass(img_path));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                listofimg.add(new NewsClass("https://institute.ltr-soft.com/company_details/inputfiles/img1.jpeg"));
                listofimg.add(new NewsClass("https://institute.ltr-soft.com/company_details/inputfiles/img1.jpeg"));
                listofimg.add(new NewsClass("https://institute.ltr-soft.com/company_details/inputfiles/img1.jpeg"));
                listofimg.add(new NewsClass("https://institute.ltr-soft.com/company_details/inputfiles/img1.jpeg"));



            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "error = " + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest1);
        
    }
}
