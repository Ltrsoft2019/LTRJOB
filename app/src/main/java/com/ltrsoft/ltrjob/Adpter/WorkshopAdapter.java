package com.ltrsoft.ltrjob.Adpter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.WorkshopUpdate;
import com.ltrsoft.ltrjob.fragments.CerificationUpdate;
import com.ltrsoft.ltrjob.pojoclass.Workshop; // Make sure to import the correct class

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    private List<Workshop> workshopList;

    public WorkshopAdapter(List<Workshop> workshopList) {
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workshop_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Workshop model = workshopList.get(position);
        holder.t1.setText(model.getWorkshop_name());
        holder.t2.setText(model.getWorkshop_venue());
        holder.t3.setText(model.getWorkshop_date());
        holder.t4.setText(model.getWorkshop_level());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();

                WorkshopUpdate updateTechnicalSkill = new WorkshopUpdate();

                Bundle args = new Bundle();
                String id = String.valueOf(model.getWorkshop_id());
                Toast.makeText(activity, "id"+id, Toast.LENGTH_SHORT).show();
                args.putString("course_id", id);

                updateTechnicalSkill.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container1,updateTechnicalSkill).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView t1, t2, t3, t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.workshop_title); // Change the IDs accordingly
            t2 = itemView.findViewById(R.id.workshop_description);
            t3 = itemView.findViewById(R.id.workshop_date);
            t4 = itemView.findViewById(R.id.workshop_level_name);
            cardView = itemView.findViewById(R.id.card_workshop); // Change the ID accordingly
        }
    }
}
