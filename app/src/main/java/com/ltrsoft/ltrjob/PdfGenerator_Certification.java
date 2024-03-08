package com.ltrsoft.ltrjob;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator_Certification {
    private static final int PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int NOTIFICATION_ID = 100;

    public static void generatePdf(Context context, int layoutId, String certificationTitle) {
        if (checkPermission(context)) {
            // Create a new PDF document
            PdfDocument document = new PdfDocument();
            // Get the layout view
            View view = ((Activity) context).findViewById(layoutId);
            // Create a view tree observer to listen for when the layout has been measured
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // Remove the listener to avoid multiple calls
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    // Get the width and height of the layout
                    int width = view.getWidth();
                    int height = view.getHeight();
                    // Check if width and height are greater than 0
                    if (width > 0 && height > 0) {
                        // Create a page configuration with the layout dimensions
                        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(width, height, 1).create();
                        // Create a new page
                        PdfDocument.Page page = document.startPage(pageInfo);
                        // Get the canvas to draw on the page
                        Canvas canvas = page.getCanvas();
                        // Create a paint object
                        Paint paint = new Paint();
                        // Set the background color
                        paint.setColor(Color.WHITE);
                        // Draw the background
                        canvas.drawRect(0, 0, width, height, paint);
                        // Draw the layout on the canvas
                        view.draw(canvas);
                        // Finish the page
                        document.finishPage(page);


                        File pdfFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), certificationTitle.toString() + ".pdf");
                        try {
                            document.writeTo(new FileOutputStream(pdfFile));
                            Toast.makeText(context, "PDF saved to " + pdfFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();

                            // Create a notification channel (for Android Oreo and higher)
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                NotificationChannel channel = new NotificationChannel("pdf_download_channel", "PDF Download", NotificationManager.IMPORTANCE_DEFAULT);
                                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
                                notificationManager.createNotificationChannel(channel);
                            }

                            // Create an intent to open the PDF file
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", pdfFile);
                            intent.setDataAndType(uri, "application/pdf");
                            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                            // Create a pending intent
                            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                            // Build the notification
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "pdf_download_channel")
                                    .setSmallIcon(R.drawable.download)
                                    .setContentTitle("Certificate PDF Download")
                                    .setContentText("Certificate PDF has been generated")
                                    .setContentIntent(pendingIntent) // Set the pending intent
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                            // Notify
                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
                            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                return;
                            }
                            notificationManager.notify(NOTIFICATION_ID, builder.build());
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error saving PDF: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
// Close the document
                        document.close();

                    } else {
                        // Log an error if width or height are not greater than 0
                        Log.e("PDF Generation", "Width or height is not greater than 0");
                    }
                }
            });

}
    }

    private static boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Request permission
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE);
            return false;
        } else {
            return true;
        }
    }
}
