package com.ltrsoft.ltrjob.Adpter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Certification;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Certification model=certificationList.get(position);
        holder.t1.setText(model.getCertification_title());
        holder.t2.setText(model.getCertification_from());
        holder.t3.setText(model.getCertification_year());
        holder.t4.setText(model.getCertification_number());
        holder.t5.setText(model.getCreatedat());


    }

    @Override
    public int getItemCount() {
        return certificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView certificationImageView;


        TextView t1,t2,t3,t4,t5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            certificationImageView = itemView.findViewById(R.id.dash_image);
            t1=itemView.findViewById(R.id.certification_title);
            t2=itemView.findViewById(R.id.certification_from);
            t3=itemView.findViewById(R.id.certification_year);
            t4=itemView.findViewById(R.id.certification_number);
            t5=itemView.findViewById(R.id.created_at);


        }
    }
}
