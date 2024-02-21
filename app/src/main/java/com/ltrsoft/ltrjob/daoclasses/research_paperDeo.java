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
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class research_paperDeo {



    String fatchall="";
    String create="";
    String fatchuser="https://job.ltr-soft.com/Research_Paper/user_research_paper.php";
    String update="http://job.ltr-soft.com/Awards_Recognization/award_Recog_categary.php";
    String delete="";

    public  void create(Research_Paper researchPaper, String research_category_id, String research_discipline_i,UserCallBack callBack, Context context)
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
                params.put("research_topic_name",researchPaper.getResearch_topic_name());


                params.put("research_discipline_id",research_discipline_i.toString());


                params.put("research_citation",researchPaper.getResearch_citation());
                params.put("research_author_1",researchPaper.getResearch_author_1());
                params.put("research_author_2",researchPaper.getResearch_author_2());
                params.put("research_author_3",researchPaper.getResearch_author_3());
                params.put("research_author_4",researchPaper.getResearch_author_4());
                params.put("research_author_5",researchPaper.getResearch_author_5());
                params.put("research_author_6",researchPaper.getResearch_author_6());

                params.put("research_category_id",research_category_id.toString());

                params.put("Published_in",researchPaper.getPublished_in());
                params.put("ISBN_no",researchPaper.getISBN_no());
                params.put("Location",researchPaper.getLocation());
                params.put("Pages_start",researchPaper.getPages_start());
                params.put("Pages_end",researchPaper.getPages_end());
                params.put("volume/ edition",researchPaper.getVolumeedition());
                params.put("DOI",researchPaper.getDOI());
                params.put("date",researchPaper.getDate());
                params.put("research_paper_published_in_journal",researchPaper.getResearch_paper_published_in_journal());




                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }









    public void getallusereachd(final Context context, RecyclerView recyclerView, UserCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, fatchuser, new Response.Listener<String>() {
            final ArrayList<Research_Paper> awardArrayList = new ArrayList<>();

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {


                        JSONObject jsonObject = json.getJSONObject(i);
                        String research_topic_name = jsonObject.getString("research_topic_name");
                        String research_citation = jsonObject.getString("research_citation");
                        String research_author_1 = jsonObject.getString("research_author_1");
                      //  String Published_in = jsonObject.getString("award_category_name");

                      //  String awardlevelname = jsonObject.getString("award_level_name");


                        Research_Paper researchPaper = new Research_Paper(research_topic_name, research_citation, research_author_1);

                        awardArrayList.add(researchPaper);

                    }
                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(awardArrayList);
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










    public void getallreasaarchpaper(final Context context , RecyclerView recyclerView, UserCallBack
            callBack) {
        final ArrayList<Research_Paper> researchPaper = new ArrayList<>();

        StringRequest request = new StringRequest(Request.Method.POST, fatchall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray json = new JSONArray(response);
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject jsonObject = json.getJSONObject(i);
                        String research_topic_name=jsonObject.getString("research_topic_name");
                        String research_discipline_id=jsonObject.getString("research_discipline_id");
                        String research_citation =jsonObject.getString("research_citation");
                        String research_author_1=jsonObject.getString("research_author_1");
                        String  research_author_2=jsonObject.getString("research_author_2");
                        String sresearch_author_3=jsonObject.getString("research_author_3");
                        String  research_author_4=jsonObject.getString("research_author_4");
                        String research_author_5=jsonObject.getString("research_author_5");
                        String  research_author_6=jsonObject.getString("research_author_6");
                        String Published_in =jsonObject.getString("Published_in");
                        String  ISBN_no=jsonObject.getString("ISBN_no");
                        String Location=jsonObject.getString("Location");
                        String  Pages_start=jsonObject.getString("Pages_start");
                        String Pages_end =jsonObject.getString("Pages_end");
                        String volumeedition=jsonObject.getString("volume/ edition");
                        String DOI=jsonObject.getString("DOI");
                        String  date=jsonObject.getString("date");
                        String  research_paper_published_in_journal=jsonObject.getString("research_paper_published_in_journal");



                        Research_Paper researchPaper = new Research_Paper(research_topic_name, research_discipline_id, research_citation,
                                research_author_1, research_author_2, sresearch_author_3,
                                research_author_4, research_author_5, research_author_6,
                                Published_in, ISBN_no, Location, Pages_start,
                                Pages_end, volumeedition, DOI, date,
                                research_paper_published_in_journal);


                        //  miniProject.add(miniProject1);
                    }

                } catch (JSONException e) {
                    callBack.userError(e.toString());
                    e.printStackTrace();
                }
                callBack.userSuccess(researchPaper);
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






    public void updatereasrchpaper(String name, String givenby, String vanue,String date,String type
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

                hashMap.put("user_id","user-17");


                hashMap.put("award_category_id","award_cat-1");
                hashMap.put("award_level_id","award_level-1");



                hashMap.put("award_name",name);
                hashMap.put("award_given_by",givenby);
                hashMap.put("award_venue",vanue);
                hashMap.put("award_date_recieved",date);
                hashMap.put("award_type_name",type);


                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }








    public void deleterearshpaper( Research_Paper researchPaper,String research_paper_id,Context context,UserCallBack callBack){


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
                map.put("research_category_id",research_paper_id.toString());



                return map;
            }
        };
    }






}
