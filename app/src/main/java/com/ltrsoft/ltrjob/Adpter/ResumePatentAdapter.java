package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Patent;
import java.util.List;

public class ResumePatentAdapter extends RecyclerView.Adapter<ResumePatentAdapter.PatentViewHolder> {

    private Context context;
    private List<Patent>patents;

    public ResumePatentAdapter(Context context, List<Patent> patents) {
        this.context = context;
        this.patents = patents;
    }

    @NonNull
    @Override
    public PatentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.patent_item_layout, parent, false);
        return new PatentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PatentViewHolder holder, int position) {
        Patent patent = patents.get(position);
        holder.patentNameTextView.setText(patent.getPatent_name());
    }

    @Override
    public int getItemCount() {
        return patents.size();
    }

    public static class PatentViewHolder extends RecyclerView.ViewHolder {
        public TextView patentNameTextView;

        public PatentViewHolder(View view) {
            super(view);
            patentNameTextView = view.findViewById(R.id.patentNameTextView);
        }
    }
}
