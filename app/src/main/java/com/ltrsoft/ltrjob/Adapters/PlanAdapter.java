package com.ltrsoft.ltrjob.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.Classes.PlanClass;
import com.ltrsoft.ltrjob.CoursesFragment.CourseCardDisplayFragment;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.plans.PlanViewsFragment;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {
    ArrayList <PlanClass> listofplan = new ArrayList<>();

    public PlanAdapter(ArrayList<PlanClass> listofplan) {
        this.listofplan = listofplan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    PlanClass planClass = listofplan.get(position);
    holder.plan_name.setText(planClass.getCplan_name());
        holder.plan_price.setText(planClass.getPlan_price());
        holder.plan_feature.setText(planClass.getPlan_feature());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bundle bundle = new Bundle();
                PlanViewsFragment planViewsFragment = new PlanViewsFragment();
                planViewsFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,planViewsFragment ).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listofplan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView plan_name , plan_price,plan_feature;
        public CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            plan_name = itemView.findViewById(R.id.plan_name);
            plan_price = itemView.findViewById(R.id.plan_price);
            plan_feature = itemView.findViewById(R.id.plan_feature);
            card = itemView.findViewById(R.id.card_layout);
        }
    }
}
