package com.ltrsoft.ltrjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.ltrsoft.ltrjob.R;

public class ExamCardDispalyFragment extends Fragment {

    public ExamCardDispalyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exam_card_dispaly, container, false);


        WebView webView = view.findViewById(R.id.webview);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl("https://institute.ltr-soft.com/exam_platform");

        return view;
    }
}
