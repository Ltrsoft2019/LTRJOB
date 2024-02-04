package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.daoclasses.City_Deo;
import com.ltrsoft.ltrjob.daoclasses.Country_Deo;
import com.ltrsoft.ltrjob.daoclasses.District_Deo;
import com.ltrsoft.ltrjob.daoclasses.Satedeo;
import com.ltrsoft.ltrjob.daoclasses.User_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.City;
import com.ltrsoft.ltrjob.pojoclass.Country;
import com.ltrsoft.ltrjob.pojoclass.District;
import com.ltrsoft.ltrjob.pojoclass.State;
import com.ltrsoft.ltrjob.pojoclass.User;
import com.ltrsoft.ltrjob.pojoclass.Userclass;
import com.ltrsoft.ltrjob.daoclasses.Registration;
import com.ltrsoft.ltrjob.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RegistrationFragment extends Fragment {
    public RegistrationFragment(){}

    private TextView sign;
    private EditText createfname, createlmname, createemail, usermobile, password1, conform_password1;

    Userclass userclass = new Userclass();

    private ArrayList<String> countrylist = new ArrayList<>();
    private ArrayList<String> statelist = new ArrayList<>();
    private ArrayList<String> districtlist = new ArrayList<>();
    private ArrayList<String> citylist = new ArrayList<>();
    ArrayAdapter adapter;
    private HashMap<Integer, String> hashMap = new HashMap<>();
    private HashMap<Integer, String> hashMapfostate = new HashMap<>();
    private HashMap<Integer, String> hashMapfodistrict = new HashMap<>();
    private HashMap<Integer, String> hashMapfocity = new HashMap<>();

    private Button register;
    private Spinner country, state, district, city;  // Added 'city' Spinner

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registrationfragment, container, false);
        createfname = v.findViewById(R.id.createfname);
        createlmname = v.findViewById(R.id.createlmname);
        createemail = v.findViewById(R.id.createemail);
        usermobile = v.findViewById(R.id.usermobile);
        password1 = v.findViewById(R.id.password1);
        conform_password1 = v.findViewById(R.id.conform_password1);
        register = v.findViewById(R.id.register);
        sign = v.findViewById(R.id.sign);


//        country = v.findViewById(R.id.countrySpinner);
//        state = v.findViewById(R.id.stateSpinner);
//        district = v.findViewById(R.id.districtSpinner);
//        city = v.findViewById(R.id.citySpinner);  // Added 'city' Spinner

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("10", "10", createfname.getText().toString(), createlmname.getText().toString(), createlmname.getText().toString(), createfname.getText().toString()
                        , createfname.getText().toString(), "", "", "", "", "", ""
                        , "", "", "", "", "", "", "", "", ""
                        , "");

                loadCountry();

                country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String countryid = hashMap.get(position);
                        loadState(countryid);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Handle nothing selected event
                    }
                });

                state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String stateid = hashMapfostate.get(position);
                        loaddistrict(stateid);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Handle nothing selected event
                    }
                });

                district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String districtid = hashMapfodistrict.get(position);
                        loadcity(districtid);
                    }

                    private void loadcity(String districtid) {

                        new Country_Deo().getAllCountry(getContext(), new UserCallBack() {
                            @Override
                            public void userSuccess(Object object) {
                                ArrayList<Country> list = (ArrayList<Country>) object;
                                for (int i = 0; i < list.size(); i++) {
                                    Country country1 = list.get(i);
                                    String country = country1.getCountry_name();
                                    countrylist.add(country);
                                    hashMap.put(i, country1.getCountry_id());
                                }
                                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line, countrylist);
                                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                country.setAdapter(adapter);
                            }

                            @Override
                            public void userError(String error) {
                                Toast.makeText(getActivity(), "error " + error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Handle nothing selected event
                    }
                });
            }

            // Implement the following methods according to your logic
            private void loadCountry() {
                new Country_Deo().getAllCountry(getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        ArrayList<Country> list = (ArrayList<Country>) object;
                        for (int i = 0; i < list.size(); i++) {
                            Country country1 = list.get(i);
                            String country = country1.getCountry_name();
                            countrylist.add(country);
                            hashMap.put(i, country1.getCountry_id());
                        }
                        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line, countrylist);
                        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        country.setAdapter(adapter);
                    }

                    @Override
                    public void userError(String error) {
                        Toast.makeText(getActivity(), "error " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void loadState(String countryid) {
                Satedeo satedeo = new Satedeo();
                satedeo.getallstate(countryid, getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        ArrayList<State> list = (ArrayList<State>) object;
                        ArrayList<String> li = new ArrayList<>();
                        for (int i = 0; i < list.size(); i++) {
                            State state1 = list.get(i);
                            String statename = state1.getState_name();
                            li.add(statename);
                            hashMapfostate.put(i, state1.getState_id());
                        }
                        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, li);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        state.setAdapter(adapter);
                    }

                    @Override
                    public void userError(String error) {

                    }
                });
            }

            private void loaddistrict(String stateid) {

                District_Deo districtDeo = new District_Deo();

                districtDeo.getAllDistrict(stateid, getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        ArrayList<District> list = (ArrayList<District>) object;
                        ArrayList<String> district_name = new ArrayList<>();
                        for (int i = 0; i < list.size(); i++) {
                            District district1 = list.get(i);
                            String districtname = district1.getDistrict_name();
                            district_name.add(districtname);
                            hashMapfodistrict.put(i, district1.getDistrict_id());
                        }
                        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, district_name);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        district.setAdapter(adapter);


                    }

                    @Override
                    public void userError(String error) {
                        Toast.makeText(getContext(), "error" + error, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        return v;
    }


    }
