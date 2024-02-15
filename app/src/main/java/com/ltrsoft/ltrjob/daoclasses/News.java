package com.ltrsoft.ltrjob.daoclasses;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.NewsClass;
import com.ltrsoft.ltrjob.pojoclass.job;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class News {
   String url="https://job.ltr-soft.com/news/read_news.php";
    public ArrayList<NewsClass> listofimg = new ArrayList<>();




    public void getall(final Context context , RecyclerView recyclerView, UserCallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String news_title = jsonObject.getString("news_title");
                        String news_description = jsonObject.getString("news_description");
                        String news_date = jsonObject.getString("news_date");
                        String news_resource = jsonObject.getString("news_resource");
                        String news_photo_path = jsonObject.getString("news_photo_path");

                        Toast.makeText(context, ""+news_date.toString(), Toast.LENGTH_SHORT).show();
                        NewsClass j=new NewsClass(news_title,news_description,news_date,news_resource,news_photo_path);

                        //  Job experience  = new Job(imageurl,experience_company_name,experiance_start_date,experiance_end_date,experiance_payment,experiance_technology,experiance_project_name,experiance_position);

                        listofimg.add(j);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(listofimg);
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

}
