package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.qualificationDeo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Qualification;

public class Profile_Edu_2 extends Fragment {

    private EditText school_name, percentage10th,degree_percentage;
    private EditText college_name,percentage12th,Institude_name;
    private NumberPicker select_10th_pass,passing_year_12th,passing_year_degree;
    private TextView passing_txt_10th,passing_txt_12th,passing_txt_degree,add1,add2;
    private Button save;


    public Profile_Edu_2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile__edu_2, container, false);

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
        Institude_name = view.findViewById(R.id.Institude_name);
        degree_percentage = view.findViewById(R.id.degree_percentage);
        passing_year_degree = view.findViewById(R.id.passing_year_degree);
        passing_txt_degree = view.findViewById(R.id.passing_txt_degree);


        int startYear = 2000;
        int endYear = 2024;

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

                    getFragmentManager().beginTransaction().replace(R.id.container, new Profile_3()).addToBackStack(null).commit();

                    qualificationDeo q = new qualificationDeo();
                    qualificationDeo q1 = new qualificationDeo();
                    qualificationDeo q2 = new qualificationDeo();

                    Qualification qualification = new Qualification("", "", "qua_level-3",
                            school_name.getText().toString(), passing_txt_10th.getText().toString(), percentage10th.getText().toString());

                    Qualification qualification1 = new Qualification("","","qua_level-4",
                            college_name.getText().toString(),passing_txt_12th.getText().toString(),percentage12th.getText().toString());

                    Qualification qualification2 = new Qualification("","","qua_level-5",
                            Institude_name.getText().toString(), passing_txt_degree.getText().toString(),degree_percentage.getText().toString());

                    q.create(qualification, requireContext(), "user-17", new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {
                            Toast.makeText(getContext(), "10th" + object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void userError(String error) {
                            Toast.makeText(getContext(), "10th" + error, Toast.LENGTH_SHORT).show();
                        }
                    });

                    q1.create(qualification1, requireContext(), "user-17", new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {
                            Toast.makeText(getContext(), "12th" + object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void userError(String error) {
                            Toast.makeText(getContext(), "12th" + error, Toast.LENGTH_SHORT).show();
                        }
                    });

                    q2.create(qualification2, requireContext(), "user-17", new UserCallBack() {
                        @Override
                        public void userSuccess(Object object) {
                            Toast.makeText(getContext(), "Degree" + object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void userError(String error) {
                            Toast.makeText(getContext(), "Degree" + error, Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            });





        return view;
    }

}