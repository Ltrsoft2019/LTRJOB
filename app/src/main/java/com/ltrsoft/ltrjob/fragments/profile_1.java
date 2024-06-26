package com.ltrsoft.ltrjob.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.City_Deo;
import com.ltrsoft.ltrjob.daoclasses.Country_Deo;
import com.ltrsoft.ltrjob.daoclasses.District_Deo;
import com.ltrsoft.ltrjob.daoclasses.Registration;
import com.ltrsoft.ltrjob.daoclasses.Satedeo;
import com.ltrsoft.ltrjob.daoclasses.User_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.City;
import com.ltrsoft.ltrjob.pojoclass.Country;
import com.ltrsoft.ltrjob.pojoclass.District;
import com.ltrsoft.ltrjob.pojoclass.State;
import com.ltrsoft.ltrjob.pojoclass.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class profile_1 extends Fragment {

    private EditText name,email,phone,address,dob,adhar,link_id,git_id;
    private TextView protxt;
    private Spinner country,state,district,city,maritalS;
    private Button submit;
    private RadioGroup gender;
    private RadioButton male,female;
    private Calendar calendar;
    private ProgressBar probar;
    private ArrayList <String >countrylist= new ArrayList<>();
    private ArrayList <String >statelist= new ArrayList<>();
    private ArrayList <String> districtlist = new ArrayList<>();
    private ArrayList <String> citylist = new ArrayList<>();
    ArrayAdapter adapter;
    private HashMap<Integer,String>hashMap=new HashMap<>();
    private HashMap<Integer,String>hashMapfostate=new HashMap<>();
    private HashMap<Integer,String>hashMapfodistrict=new HashMap<>();
    private HashMap<Integer,String>hashMapfocity=new HashMap<>();

    String[] maritalStatusOptions = {"Single", "Married", "Divorced", "Widowed"};

    String selectedMaritalStatus;
    private String storedName, storedEmail, storedPhone, storedAddress, storedDob,
            storedAdhar, storedLinkId, storedGitId, selectedGender, selectedCountry,
            selectedState, selectedDistrict, selectedCity;

    private static final String PREF_NAME = "MyPrefs";
    private static final String PREF_SELECTED_MARITAL_STATUS = "selectedMaritalStatus";
    private static final String PREF_NAME_FIELD = "nameField";
    private static final String PREF_EMAIL_FIELD = "emailField";
    private static final String PREF_PHONE_FIELD = "phoneField";
    private static final String PREF_ADDRESS_FIELD = "addressField";
    private static final String PREF_DOB_FIELD = "dobField";
    private static final String PREF_ADHAR_FIELD = "adharField";
    private static final String PREF_LINK_ID_FIELD = "linkIdField";
    private static final String PREF_GIT_ID_FIELD = "gitIdField";
    private static final String PREF_SELECTED_GENDER = "selectedGender";
    private static final String PREF_SELECTED_COUNTRY = "selectedCountry";
    private static final String PREF_SELECTED_STATE = "selectedState";
    private static final String PREF_SELECTED_DISTRICT = "selectedDistrict";
    private static final String PREF_SELECTED_CITY = "selectedCity";


    public profile_1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.profile_1, container, false);

        name=view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        dob = view.findViewById(R.id.dob);
        adhar = view.findViewById(R.id.adhar);
        country = view.findViewById(R.id.country);
        state = view.findViewById(R.id.state);
        district = view.findViewById(R.id.district);
        city = view.findViewById(R.id.city);
        submit = view.findViewById(R.id.save);
        calendar = Calendar.getInstance();
        gender = view.findViewById(R.id.gender);
        male = view.findViewById(R.id.male);
        female = view.findViewById(R.id.female);
        link_id = view.findViewById(R.id.link_id);
        git_id = view.findViewById(R.id.git_id);
        maritalS = view.findViewById(R.id.ms);
        probar = view.findViewById(R.id.probar);
        protxt = view.findViewById(R.id.protxt);





        SharedPreferences prefs = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        storedName = prefs.getString(PREF_NAME_FIELD, "");
        storedEmail = prefs.getString(PREF_EMAIL_FIELD, "");
        storedPhone = prefs.getString(PREF_PHONE_FIELD, "");
        storedAddress = prefs.getString(PREF_ADDRESS_FIELD, "");
        storedDob = prefs.getString(PREF_DOB_FIELD, "");
        storedAdhar = prefs.getString(PREF_ADHAR_FIELD, "");
        storedLinkId = prefs.getString(PREF_LINK_ID_FIELD, "");
        storedGitId = prefs.getString(PREF_GIT_ID_FIELD, "");
        selectedGender = prefs.getString(PREF_SELECTED_GENDER, "");
        selectedMaritalStatus = prefs.getString(PREF_SELECTED_MARITAL_STATUS, "");
        selectedCountry = prefs.getString(PREF_SELECTED_COUNTRY, "");
        selectedState = prefs.getString(PREF_SELECTED_STATE, "");
        selectedDistrict = prefs.getString(PREF_SELECTED_DISTRICT, "");
        selectedCity = prefs.getString(PREF_SELECTED_CITY, "");

        // Set the retrieved data to the corresponding fields
        name.setText(storedName);
        email.setText(storedEmail);
        phone.setText(storedPhone);
        address.setText(storedAddress);
        dob.setText(storedDob);
        adhar.setText(storedAdhar);
        link_id.setText(storedLinkId);
        git_id.setText(storedGitId);

        // Set the retrieved data to the corresponding spinners
        setSpinnerSelection(maritalS, maritalStatusOptions, selectedMaritalStatus);
        setSpinnerSelection(country, countrylist.toArray(new String[0]), selectedCountry);
        setSpinnerSelection(state, statelist.toArray(new String[0]), selectedState);
        setSpinnerSelection(district, districtlist.toArray(new String[0]), selectedDistrict);
        setSpinnerSelection(city, citylist.toArray(new String[0]), selectedCity);

        // Set the retrieved data to the corresponding radio buttons
        if (selectedGender.equals("Male")) {
            male.setChecked(true);
        } else if (selectedGender.equals("Female")) {
            female.setChecked(true);
        }


        setFieldListeners();

        ArrayAdapter<String> maritalAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, maritalStatusOptions);
        maritalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maritalS.setAdapter(maritalAdapter);

        loadCountry();
        maritalS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 selectedMaritalStatus = maritalStatusOptions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });



        User_Deo userDeo=new User_Deo();
        loadCountry();
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countryid = hashMap.get(position);
                loadState(countryid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String stateid = hashMap.get(position);
                loaddistrict(stateid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String districtid = hashMap.get(position);
                loadcity(districtid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Set the selected date in the dob EditText
                                dob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGender = "";
                int selectedId = gender.getCheckedRadioButtonId();
                if (selectedId == male.getId()) {
                    selectedGender = "Male";
                } else if (selectedId == female.getId()) {
                    selectedGender = "Female";
                }
               User user =new User("",name.toString(),name.toString(),name.toString(),email.toString(),phone.toString(),"",gender.toString(),dob.toString(),"",address.toString(),selectedCity.toString(),selectedDistrict.toString(),selectedState.toString(),selectedCountry.toString(),"",adhar.toString(),"",link_id.toString(),git_id.toString(),"","","",selectedMaritalStatus);


                Registration registration = new Registration();
                registration.geteuserid(getContext(), "", new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        if (object instanceof String) {
                            String userId = (String) object;
                            Toast.makeText(getContext(), "User ID: " + userId, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Failed to fetch user ID", Toast.LENGTH_SHORT).show();
                        }
                    }
                    

                    @Override
                    public void userError(String error) {
                        // Handle error
                        Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
                    }
                });

             //   User user = new User("", name.getText().toString(), selectedGender, "", email.getText().toString(),
//                        phone.getText().toString(), phone.toString(), gender.toString(), dob.getText().toString(), "", address.getText().toString(),
//                        selectedCity.toString(), selectedDistrict.toString(), selectedState, selectedCountry, "", adhar.getText().toString(), "",
//                        link_id.toString(), "", "", "", "",selectedMaritalStatus);


                Toast.makeText(getContext(), ""+selectedMaritalStatus, Toast.LENGTH_SHORT).show();
                userDeo.createUser(user, getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object object) {
                        Toast.makeText(getActivity(), "" + object, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void userError(String error) {
                        Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
                    }
                });


                SharedPreferences.Editor editor = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
                editor.putString(PREF_NAME_FIELD, name.getText().toString());
                editor.putString(PREF_EMAIL_FIELD, email.getText().toString());
                editor.putString(PREF_PHONE_FIELD, phone.getText().toString());
                editor.putString(PREF_ADDRESS_FIELD, address.getText().toString());
                editor.putString(PREF_DOB_FIELD, dob.getText().toString());
                editor.putString(PREF_ADHAR_FIELD, adhar.getText().toString());
                editor.putString(PREF_LINK_ID_FIELD, link_id.getText().toString());
                editor.putString(PREF_GIT_ID_FIELD, git_id.getText().toString());


                editor.putString(PREF_SELECTED_MARITAL_STATUS, selectedMaritalStatus);
                editor.putString(PREF_SELECTED_GENDER, selectedGender);
                editor.putString(PREF_SELECTED_COUNTRY, selectedCountry);
                editor.putString(PREF_SELECTED_STATE, selectedState);
                editor.putString(PREF_SELECTED_DISTRICT, selectedDistrict);
                editor.putString(PREF_SELECTED_CITY, selectedCity);

                editor.apply();



                getFragmentManager().beginTransaction().replace(R.id.constraint, new Profile_Edu_2()).addToBackStack(null).commit();

            }
        });

        return view;
    }

    private void setSpinnerSelection(Spinner spinner, String[] options, String selectedValue) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) spinner.getAdapter();
        if (adapter != null) {
            int position = adapter.getPosition(selectedValue);
            if (position >= 0) {
                spinner.setSelection(position);
            } else {

                // You can set a default selection or handle it based on your requirements
                spinner.setSelection(0);  // Set the default selection to the first item
            }
        }


}




    private void setFieldListeners() {

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateProgressBar();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateProgressBar();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Add similar listeners for other fields...

        // Spinner listeners
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateProgressBar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

        private void updateProgressBar() {
            // Initialize totalFields as the number of editable fields in the form
            double totalFields = countEditableFields();

            double filledFields = 0; // Initialize filled fields counter

            // Check each field if it's filled
            if (!name.getText().toString().isEmpty()) filledFields++;
            if (!email.getText().toString().isEmpty()) filledFields++;
            if (!phone.getText().toString().isEmpty()) filledFields++;
            if (!address.getText().toString().isEmpty()) filledFields++;
            if (!dob.getText().toString().isEmpty()) filledFields++;
            if (!adhar.getText().toString().isEmpty()) filledFields++;
            // Repeat this for all fields in your form

            // Calculate percentage
            String percentage = String.valueOf((int) ((filledFields / totalFields) * 100));

            // Set the percentage on the progress bar
            protxt.setText(percentage);
        }

        private int countEditableFields() {
            int count = 0;


            if (name.isEnabled()) count++;
            if (email.isEnabled()) count++;
            if (phone.isEnabled()) count++;
            if (address.isEnabled()) count++;
            if (dob.isSelected()) count++;
            if (adhar.isEnabled()) count++;
            if (maritalS.isEnabled()) count++;
            if(link_id.isEnabled()) count++;
            if(git_id.isEnabled()) count++;
            // Repeat this for all editable fields in your form

            return count;
        }


    private void loadcity(String districtid) {
        City_Deo cityDeo=new City_Deo();

        cityDeo.getAllCity(districtid, getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<City> list= (ArrayList<City>) object;
                Toast.makeText(getActivity(), "success="+list.size(), Toast.LENGTH_SHORT).show();
                ArrayList<String>city_name= new ArrayList<>();

                for (int i = 0; i < list.size(); i++) {
                    City city1=list.get(i);
                    String cityname = city1.getCity_name();
                    city_name.add(cityname);
                    hashMapfocity.put(i,city1.getCity_id());
                }
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,city_name);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                city.setAdapter(adapter);

            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "error"+error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loaddistrict(String stateid) {

        District_Deo districtDeo=new District_Deo();

        districtDeo.getAllDistrict(stateid, getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<District>list= (ArrayList<District>) object;
                ArrayList<String>district_name=new ArrayList<>();
                for (int i = 0; i < list.size() ; i++) {
                    District district1=list.get(i);
                    String districtname = district1.getDistrict_name();
                    district_name.add(districtname);
                    hashMapfodistrict.put(i,district1.getDistrict_id());
                }
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,district_name);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                district.setAdapter(adapter);


            }

            @Override
            public void userError(String error) {
                Toast.makeText(getContext(), "error"+error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadState(String countryid) {
        Satedeo satedeo = new Satedeo();
        satedeo.getallstate(countryid, getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
            ArrayList<State>list = (ArrayList<State>) object;
            ArrayList<String>li = new ArrayList<>();
                for (int i = 0; i <list.size() ; i++) {
                    State state1 = list.get(i);
                    String statename = state1.getState_name();
                    li.add(statename);
                    hashMapfostate.put(i,state1.getState_id());
                }
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,li);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                state.setAdapter(adapter);
            }

            @Override
            public void userError(String error) {

            }
        });
    }
    private void loadCountry() {
        new Country_Deo().getAllCountry(getContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                ArrayList<Country>list= (ArrayList<Country>) object;
                for (int i = 0; i < list.size() ; i++) {
                    Country country1=list.get(i);
                    String country = country1.getCountry_name();
                    countrylist.add(country);
                    hashMap.put(i,country1.getCountry_id());
                }
                adapter = new ArrayAdapter(getContext() , android.R.layout.simple_dropdown_item_1line,countrylist);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                country.setAdapter(adapter);
            }
            @Override
            public void userError(String error) {

                Toast.makeText(getActivity(), "error "+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}