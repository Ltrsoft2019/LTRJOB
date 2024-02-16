package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
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
        holder.t1.setText(model.getCertification_title());
        holder.t2.setText(model.getCertification_from());
        holder.t3.setText(model.getCertification_year());
        holder.t4.setText(model.getCertification_number());
        holder.t5.setText(model.getCreatedat());

        holder.certificationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.createPdf(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return certificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView certificationImageView;
        TextView t1, t2, t3, t4, t5;
        Context context;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            certificationImageView = itemView.findViewById(R.id.img2);
            t1 = itemView.findViewById(R.id.certification_title);
            t2 = itemView.findViewById(R.id.certification_from);
            t3 = itemView.findViewById(R.id.certification_year);
            t4 = itemView.findViewById(R.id.certification_number);
            t5 = itemView.findViewById(R.id.created_at);
        }

        public void createPdf(Certification model) {
            Document document;

            try {
                // Use the context to get the external files directory
                File directory = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                String filePath = new File(directory, "certification_details.pdf").getAbsolutePath();

                PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));
                PdfDocument pdfDocument = new PdfDocument(writer);

                document = new Document(pdfDocument);

                // Add data to the PDF
                document.add(new Paragraph("Certification Title: " + model.getCertification_title()));
                document.add(new Paragraph("From: " + model.getCertification_from()));
                document.add(new Paragraph("Year: " + model.getCertification_year()));
                document.add(new Paragraph("Number: " + model.getCertification_number()));
                document.add(new Paragraph("Created At: " + model.getCreatedat()));

                document.close();

                Toast.makeText(context, "PDF created successfully: " + filePath, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Error creating PDF: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

    }
    }
}
