package com.ltrsoft.ltrjob.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Qualification;

public class Profile_Edu_2 extends Fragment {

    private EditText school_name, percentage10th, degree_percentage;
    private EditText college_name, percentage12th, Institute_name;
    private Spinner select_degree;
    private NumberPicker select_10th_pass, passing_year_12th, passing_year_degree;
    private TextView passing_txt_10th, passing_txt_12th, passing_txt_degree, add1, add2;
    private Button save;

    private SharedPreferences sharedPreferences;

    public Profile_Edu_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile__edu_2, container, false);

        // Initialize SharedPreferences
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

        school_name = view.findViewById(R.id.school_name);
        percentage10th = view.findViewById(R.id.percentage10th);
        select_10th_pass = view.findViewById(R.id.passing_year);
        passing_txt_10th = view.findViewById(R.id.passing_txt);

        save = view.findViewById(R.id.save);
        add1 = view.findViewById(R.id.add1);
        add2 = view.findViewById(R.id.add2);

        // 12th standard qualifications fields
        college_name = view.findViewById(R.id.college_name);
        percentage12th = view.findViewById(R.id.percentage12th);
        passing_year_12th = view.findViewById(R.id.passing_year_12th);
        passing_txt_12th = view.findViewById(R.id.passing_txt_12th);

        // Degree qualifications fields
        Institute_name = view.findViewById(R.id.Institude_name);
        degree_percentage = view.findViewById(R.id.degree_percentage);
        passing_year_degree = view.findViewById(R.id.passing_year_degree);
        passing_txt_degree = view.findViewById(R.id.passing_txt_degree);
        select_degree = view.findViewById(R.id.select_degree);

        String[] degrees = {"BCA", "BCS", "BCom", "BSE"};

        // Create ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, degrees);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        select_degree.setAdapter(adapter);


        loadSavedData();

        int startYear = 2000;
        int endYear = 2050;

        // Populate NumberPicker with years
        String[] years = new String[endYear - startYear + 1];
        for (int i = 0; i < years.length; i++) {
            years[i] = String.valueOf(startYear + i);
        }
        select_10th_pass.setMinValue(0);
        select_10th_pass.setMaxValue(years.length - 1);
        select_10th_pass.setDisplayedValues(years);

        passing_year_12th.setMinValue(0);
        passing_year_12th.setMaxValue(years.length - 1);
        passing_year_12th.setDisplayedValues(years);

        passing_year_degree.setMinValue(0);
        passing_year_degree.setMaxValue(years.length - 1);
        passing_year_degree.setDisplayedValues(years);

        // Listener to get the selected year
        select_10th_pass.setOnValueChangedListener((picker, oldVal, newVal) -> {
            String selectedYear = years[newVal];
            // Use the selected year as needed
            passing_txt_10th.setText(selectedYear);
        });

        passing_year_12th.setOnValueChangedListener((picker1, oldVal1, newVal1) -> {
            String selectedYear1 = years[newVal1];
            // Use the selected year as needed
            passing_txt_12th.setText(selectedYear1);
        });

        passing_year_degree.setOnValueChangedListener((picker2, oldVal2, newVal2) -> {
            String selectedYear2 = years[newVal2];
            // Use the selected year as needed
            passing_txt_degree.setText(selectedYear2);
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.constraint, new Profile_3()).addToBackStack(null).commit();
                saveData();
            }
        });

        select_degree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDegree = (String) parent.getItemAtPosition(position);
                // Display a toast message with the selected degree name
                Toast.makeText(getContext(), "Selected Degree: " + selectedDegree, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void saveData() {
        // Save user-related data to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_id", "user-17"); // Replace with the actual user ID
        editor.putString("school_name", school_name.getText().toString());
        editor.putString("percentage10th", percentage10th.getText().toString());
        editor.putInt("select_10th_pass", select_10th_pass.getValue());
        editor.putString("passing_txt_10th", passing_txt_10th.getText().toString());
        // ... (save other data)
        editor.putString("college_name", college_name.getText().toString());
        editor.putString("percentage12th", percentage12th.getText().toString());
        editor.putInt("passing_year_12th", passing_year_12th.getValue());
        editor.putString("passing_txt_12th", passing_txt_12th.getText().toString());

        // Save Degree qualifications data
        editor.putString("Institute_name", Institute_name.getText().toString());
        editor.putString("degree_percentage", degree_percentage.getText().toString());
        editor.putInt("passing_year_degree", passing_year_degree.getValue());
        editor.putString("passing_txt_degree", passing_txt_degree.getText().toString());

        editor.apply();
    }

    private void loadSavedData() {
        // Load data from SharedPreferences and set it to corresponding fields
        school_name.setText(sharedPreferences.getString("school_name", ""));
        percentage10th.setText(sharedPreferences.getString("percentage10th", ""));
        select_10th_pass.setValue(sharedPreferences.getInt("select_10th_pass", 0));
        passing_txt_10th.setText(sharedPreferences.getString("passing_txt_10th", ""));


        // Load 12th standard qualifications data
        college_name.setText(sharedPreferences.getString("college_name", ""));
        percentage12th.setText(sharedPreferences.getString("percentage12th", ""));
        passing_year_12th.setValue(sharedPreferences.getInt("passing_year_12th",0));
        passing_txt_12th.setText(sharedPreferences.getString("passing_txt_12th", ""));

        // Load Degree qualifications data
        Institute_name.setText(sharedPreferences.getString("Institute_name", ""));
        degree_percentage.setText(sharedPreferences.getString("degree_percentage", ""));
        passing_year_degree.setValue(sharedPreferences.getInt("passing_year_degree", 0));
        passing_txt_degree.setText(sharedPreferences.getString("passing_txt_degree", ""));
    }
}
