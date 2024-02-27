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
import com.ltrsoft.ltrjob.pojoclass.Technical_Skill;

import java.util.List;


public class Resume_Skill_Adapter extends RecyclerView.Adapter<Resume_Skill_Adapter.SkillViewHolder> {
    private Context context;
    private List<Technical_Skill> skills;

    public Resume_Skill_Adapter(Context context, List<Technical_Skill> skills) {
        this.context = context;
        this.skills = skills;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.resume_item_skill, parent, false);
        return new Resume_Skill_Adapter.SkillViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        Technical_Skill technicalSkill = skills.get(position);
        holder.technical_skill_name.setText(technicalSkill.getTechnical_skill_name());
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }

    public static class SkillViewHolder extends RecyclerView.ViewHolder{
        private TextView technical_skill_name;
        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            technical_skill_name=itemView.findViewById(R.id.technical_skill_name);
        }
    }
}
