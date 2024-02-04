package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Feedback_Deo;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Feedback;

public class FeedbacFragment extends Fragment {
    private EditText editText1, editText2;
    private Spinner spinner;

    public FeedbacFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedbac, container, false);

        editText1 = view.findViewById(R.id.editTextText2);
        editText2 = view.findViewById(R.id.editTextText3);

        spinner = view.findViewById(R.id.spinner);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from UI elements
                String sub = editText1.getText().toString();
                String des = editText2.getText().toString();
                String selectedSpinnerItem = spinner.getSelectedItem().toString();


                Feedback_Deo feedbackDeo = new Feedback_Deo();


                feedbackDeo.feedback(des, sub, selectedSpinnerItem, getContext(), new UserCallBack() {
                    @Override
                    public void userSuccess(Object response) {

                    }

                    @Override
                    public void userError(String error) {

                    }
                });

                // Call the fetchFeedbackCategoryNames method
                feedbackDeo.fetchFeedbackCategoryNames(getContext());

                ArrayAdapter<String> nameAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
                nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(nameAdapter);
            }
        });

        return view;
    }
}
