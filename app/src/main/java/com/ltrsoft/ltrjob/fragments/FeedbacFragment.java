package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Feedback_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;

import java.util.List;

public class FeedbacFragment extends Fragment {
    private EditText feedback_desc, subject;
    private RatingBar rating;
    private Spinner categery_spinner;

    public FeedbacFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedbac, container, false);

        feedback_desc = view.findViewById(R.id.feedback_desc);
        subject = view.findViewById(R.id.subject);
        rating = view.findViewById(R.id.rating);
        categery_spinner = view.findViewById(R.id.categery_spinner);
        Button submit = view.findViewById(R.id.submit);

        Feedback_Deo feedbackDeo = new Feedback_Deo();

        feedbackDeo.fetchFeedbackCategoryNames(requireContext(), new UserCallBack() {
            @Override
            public void userSuccess(Object object) {
                List<String> feedbackCategories = (List<String>) object;

                ArrayAdapter<String> nameAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, feedbackCategories);
                nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                categery_spinner.setAdapter(nameAdapter);
            }

            @Override
            public void userError(String error) {
                // Handle error
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from UI elements
                String sub = feedback_desc.getText().toString();
                String des = subject.getText().toString();

                // Check if the spinner has items
                if (categery_spinner.getCount() > 0) {
                    String selectedSpinnerItem = categery_spinner.getSelectedItem().toString();

                    feedbackDeo.feedback(des, sub, selectedSpinnerItem, getContext(), new UserCallBack() {
                        @Override
                        public void userSuccess(Object response) {
                            // Handle success
                        }

                        @Override
                        public void userError(String error) {
                            // Handle error
                        }
                    });
                } else {

                }
            }
        });

        return view;
    }
}
