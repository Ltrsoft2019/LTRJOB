// ResumeCertificationAdapter.java
package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Certification;

import java.util.ArrayList;

public class ResumeCertificationAdapter extends RecyclerView.Adapter<ResumeCertificationAdapter.CertificationViewHolder> {
    private Context context;
    private ArrayList<Certification> certifications;

    public ResumeCertificationAdapter(Context context, ArrayList<Certification> certifications) {
        this.context = context;
        this.certifications = certifications;
    }

    @NonNull
    @Override
    public CertificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_certification, parent, false);
        return new CertificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CertificationViewHolder holder, int position) {
        Certification certification = certifications.get(position);
        holder.textViewTitle.setText(certification.getCertification_title());
    }

    @Override
    public int getItemCount(){
        return certifications.size();
    }

    public void setCertifications(ArrayList<Certification> certifications) {
        this.certifications=certifications;
    }

    static class CertificationViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;

        public CertificationViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_certification_title);
        }
    }
}
