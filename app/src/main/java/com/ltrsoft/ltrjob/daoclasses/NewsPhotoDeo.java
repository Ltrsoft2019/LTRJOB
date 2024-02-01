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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.News_Category;
import com.ltrsoft.ltrjob.pojoclass.News_Photo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsPhotoDeo {

    String create="";
    String DASHBOARD_IMG_URL="https://job.ltr-soft.com/news/read_news.php";
    String update="";
    String delete="";

    public  void createphoto(News_Photo newsPhoto, UserCallBack callBack, Context context, String news_photo_id, String news_id,String news_photo_path)
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
                params.put("news_id",String.valueOf(newsPhoto.getNews_id()));
//                params.put("news_photo_id",String.valueOf(newsPhoto.getNews_photo_id()));
                params.put("news_photo_path",newsPhoto.getNews_photo_path());

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void fatchphoto(final Context context, RecyclerView recyclerView, UserCallBack callBack) {
        JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.POST, DASHBOARD_IMG_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Clear the list before adding new items
                List<News_Photo> newsPhotosList = new ArrayList<>();

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String Photo_path = jsonObject.getString("news_photo_path");
                        //  String img="https://job.ltr-soft.com/news/"+Photo_path;



                        String imageurl = "https://institute.ltr-soft.com/news_photo/" + Photo_path;

                        Toast.makeText(context, ""+imageurl, Toast.LENGTH_SHORT).show();
                          News_Photo newsPhoto1 = new News_Photo(imageurl);
                        newsPhotosList.add(newsPhoto1);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }


                if (callBack != null) {
                    callBack.userSuccess(newsPhotosList);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                if (callBack != null) {
                    callBack.userError(error.toString());
                } else {
                    Toast.makeText(context, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest1);
    }

    public void updateproject(News_Photo newsPhoto, Context context, UserCallBack callBack){
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

             //   hashMap.put("news_photo_id",String.valueOf(newsPhoto.getNews_photo_path()));
                hashMap.put("news_id",String.valueOf(newsPhoto.getNews_id()));


                hashMap.put("news_photo_path",newsPhoto.getNews_photo_path());
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void deleteproject( News_Photo newsPhoto,String userid,Context context,UserCallBack callBack){


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
              //  map.put("news_photo_id",String.valueOf(newsPhoto.getNews_photo_id()));
                map.put("news_id",String.valueOf(newsPhoto.getNews_id()));


                return map;
            }
        };
    }




}
