package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.CourseDetailFragment;
import com.ltrsoft.ltrjob.fragments.UpdateTechnicalSkill;
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;

import java.util.List;


public class TechnicalSkillAdapter extends RecyclerView.Adapter<TechnicalSkillAdapter.ViewHolder> {
    private Context context;
    private List<Technical_Skill> skillList;

    public TechnicalSkillAdapter(List<Technical_Skill> skillList) {
        this.skillList = skillList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.technical_skill_card, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Technical_Skill model = skillList.get(position);
        holder.skillName.setText(model.getTechnical_skill_name());
        System.out.println("skill name "+model.getTechnical_skill_name());
        String skillNameValue = model.getTechnical_skill_name();
//        Toast.makeText(context, "Adapter: " + skillNameValue, Toast.LENGTH_SHORT).show();
        holder.skillCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();

                UpdateTechnicalSkill updateTechnicalSkill = new UpdateTechnicalSkill();

                Bundle args = new Bundle();
                String id = String.valueOf(model.getTechnical_skill_id());
                Toast.makeText(activity, "id"+id, Toast.LENGTH_SHORT).show();
                args.putString("course_id", id);

                updateTechnicalSkill.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,updateTechnicalSkill).addToBackStack(null).commit();


            }
        });
    }

    @Override
    public int getItemCount() {
        return skillList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView skillName;
        CardView skillCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            skillName = itemView.findViewById(R.id.techname);

            skillCard = itemView.findViewById(R.id.skillCard);
        }
    }
}
