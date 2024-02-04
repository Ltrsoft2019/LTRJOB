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
import com.ltrsoft.ltrjob.pojoclass.Event_class;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventCard {
    String url = "http://job.ltr-soft.com/Event/event_photo.php";
   String Deleteurl="https://job.ltr-soft.com/Event/delete_event.php";
   String updateurl="https://job.ltr-soft.com/Event/event_update.php";
   String redid="https://job.ltr-soft.com/Event/read_by_id.php";


    final ArrayList<Event_class> imglist = new ArrayList<>();




    public void fetchEventData(final Context context , RecyclerView recyclerView, UserCallBack callBack) {

       /// recyclerView.setLayoutManager(new LinearLayoutManager(context));



        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String description = jsonObject.getString("event_description");
                        String name = jsonObject.getString("event_name");
                        String guest = jsonObject.getString("event_guest");
                        String venue = jsonObject.getString("event_venue");
                        String date_time = jsonObject.getString("event_date_time");
                        String duration = jsonObject.getString("event_duration");
                        String photo_path = jsonObject.getString("photo_path");

                        String imageurl = "https://institute.ltr-soft.com/event_photo/" + photo_path;




                        String[] dateAndTime = date_time.split(" ");
                        String date = dateAndTime[0];
                        String time = dateAndTime[1];

                        Event_class eventClass = new Event_class(name,"",description,guest,venue
                        ,date_time,duration,imageurl,description,"");
//
                        imglist.add(eventClass);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(imglist);
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







    public  void  getevent( final Context context , RecyclerView recyclerView, UserCallBack callBack) {

        StringRequest request = new StringRequest(Request.Method.POST, redid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String description = jsonObject.getString("event_description");
                        String name = jsonObject.getString("event_name");
                        String guest = jsonObject.getString("event_guest");
                        String venue = jsonObject.getString("event_venue");
                        String date_time = jsonObject.getString("event_date_time");
                        String duration = jsonObject.getString("event_duration");
                        String photo_path = jsonObject.getString("photo_path");

                        String imageurl = "https://institute.ltr-soft.com/event_photo/" + photo_path;
                        String[] dateAndTime = date_time.split(" ");
                        String date = dateAndTime[0];
                        String time = dateAndTime[1];

                        Event_class eventClass = new Event_class(name,"",description,guest,venue,date_time,duration,imageurl,description,"");
//
                        imglist.add(eventClass);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(imglist);

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


                hashMap.put("event_id","event-1");

                return hashMap;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }







    public void DeleteEvent( Event_class eventClass, String eventid, Context context, UserCallBack callBack ){


        StringRequest stringRequest= new StringRequest(Request.Method.POST, Deleteurl,
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
                HashMap<String,String> map=new HashMap<>();
                map.put("event_id",eventClass.getEventid());
                return map;


            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }







    public void updateevent(  Event_class eventClass, String eventid, Context context, UserCallBack callBack ){

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

hashMap.put("event_id",eventid.toString());
                hashMap.put("event_name",eventClass.getEvent_name());
                hashMap.put("user_mname",eventClass.getEvent_description());
                hashMap.put("event_guest",eventClass.getEvent_guest());
                hashMap.put("event_venue",eventClass.getEvent_venue());
                hashMap.put("event_date_time",eventClass.getEvent_date_time());
                hashMap.put("event_duration",eventClass.getEvent_duration());
                hashMap.put("event_type_id",eventClass.getEvent_type_name());

                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
