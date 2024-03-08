package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.CerificationUpdate;
import com.ltrsoft.ltrjob.fragments.Certification_download;
import com.ltrsoft.ltrjob.fragments.QualificationUpdate;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CertificationAdapter extends RecyclerView.Adapter<CertificationAdapter.ViewHolder> {

    private List<Certification> certificationList;

    public CertificationAdapter(List<Certification> certificationList) {
        this.certificationList = certificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.certification_item_layout, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Certification model = certificationList.get(position);
        holder.title.setText(model.getCertification_title());
        holder.name.setText("Sahil Kshirsagar");
        holder.date.setText(model.getCertification_year());
//        holder.t4.setText(model.getCertification_number());
//        holder.t5.setText(model.getCreatedat());
//holder.card.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//
//        AppCompatActivity activity=(AppCompatActivity)v.getContext();
//
//        CerificationUpdate updateTechnicalSkill = new CerificationUpdate();
//
//        Bundle args = new Bundle();
//        String id = String.valueOf(model.getCertification_number());
//        Toast.makeText(activity, "id"+id, Toast.LENGTH_SHORT).show();
//        args.putString("course_id", id);
//
//        updateTechnicalSkill.setArguments(args);
//        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,updateTechnicalSkill).addToBackStack(null).commit();
//
//
//    }
//});
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();

                // Put necessary data into the Bundle
                bundle.putString("certification_title", model.getCertification_title());
                bundle.putString("certification_date", model.getCertification_year());
                bundle.putString("certification_name", "Sahil Kshirsagar");

                // Navigate to the fragment where you want to pass the Bundle
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Certification_download nextFragment = new Certification_download(); // Replace YourNextFragment with the appropriate fragment
                nextFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, nextFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return certificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView certificationImageView;
        TextView title, name, t3, t4, t5,card,date;
        Context context;
        ImageView download;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            title = itemView.findViewById(R.id.title);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            download = itemView.findViewById(R.id.download);
        }


    }
}
