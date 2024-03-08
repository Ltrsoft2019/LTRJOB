package com.ltrsoft.ltrjob.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.ltrjob.PdfGenerator;
import com.ltrsoft.ltrjob.PdfGenerator_Certification;
import com.ltrsoft.ltrjob.R;

public class Certification_download extends Fragment {
    private TextView date, title, name;
    private Button download;
    private static final int PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int NOTIFICATION_ID = 100;

    String certificationTitle;

    public Certification_download() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_certification_download, container, false);
        name = view.findViewById(R.id.name);
        title = view.findViewById(R.id.title);
        date = view.findViewById(R.id.date);
        download = view.findViewById(R.id.download);


        Bundle bundle = getArguments();
        if (bundle != null) {
             certificationTitle = bundle.getString("certification_title");
            String certificationDate = bundle.getString("certification_date");
            String certificationName = bundle.getString("certification_name");

            title.setText(certificationTitle);
            date.setText(certificationDate);
            name.setText(certificationName);
        }

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission(getContext())) {
                    generatePdf();
                }
            }
        });
        return view;
    }

    private boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                generatePdf();
            } else {
                Toast.makeText(getContext(), "Permission denied, cannot generate PDF.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void generatePdf() {
        // Your PDF generation code here
        PdfGenerator_Certification.generatePdf(getContext(), R.id.certification_layout,certificationTitle.toString()); // Example call to the PdfGenerator class

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("pdf_download_channel", "PDF Download", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "pdf_download_channel")
//                .setSmallIcon(R.drawable.download)
//                .setContentTitle("Certificate PDF Download")
//                .setContentText("Certificate PDF has been genreted")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
//        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}
