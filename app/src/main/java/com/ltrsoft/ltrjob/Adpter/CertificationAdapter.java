package com.ltrsoft.ltrjob.Adpter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Certification;
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
        Certification certification = certificationList.get(position);

        String certificationPath = certification.getPhoto();


        Picasso.get()
                .load(certificationPath)
                .into(holder.certificationImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Handle success if needed
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if needed
                    }
                });
    }

    @Override
    public int getItemCount() {
        return certificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView certificationImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            certificationImageView = itemView.findViewById(R.id.dash_image);
        }
    }
}
