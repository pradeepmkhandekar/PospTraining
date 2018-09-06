package com.posp.trainingapp.studymaterial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.posp.trainingapp.R;
import com.posp.trainingapp.core.models.StudyMaterialEntity;
import com.posp.trainingapp.utility.Constants;
import com.posp.trainingapp.webviews.studymaterial.StudyMaterialActivity;

import java.util.List;

/**
 * Created by Rajeev Ranjan on 07/04/2017.
 */

public class StudyMaterialAdapter extends RecyclerView.Adapter<StudyMaterialAdapter.MyViewHolder> {

    Context mContext;
    List<StudyMaterialEntity> studyMaterialEntities;
    int type;

    public StudyMaterialAdapter(Context context, List<StudyMaterialEntity> studyMaterialEntities, int type) {
        this.mContext = context;
        this.studyMaterialEntities = studyMaterialEntities;
        this.type = type;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvLink, tvPractice, tvStudy;
        RelativeLayout llStudymaterial;
        LinearLayout llStudy;
        Button btnPractice;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvLink = (TextView) itemView.findViewById(R.id.tvLink);
            tvPractice = (TextView) itemView.findViewById(R.id.tvPractice);
            llStudy = (LinearLayout) itemView.findViewById(R.id.llStudy);
            tvStudy = (TextView) itemView.findViewById(R.id.tvStudy);
            btnPractice = (Button) itemView.findViewById(R.id.btnPractice);
            //llStudymaterial = (RelativeLayout) itemView.findViewById(R.id.llStudymaterial);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_study_material, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(StudyMaterialAdapter.MyViewHolder holder, final int position) {
        final StudyMaterialEntity studyMaterialEntity = studyMaterialEntities.get(position);
        holder.tvTitle.setText(studyMaterialEntity.getTitle());
        holder.tvLink.setText(studyMaterialEntity.getLink());
        holder.tvStudy.setText("STUDY MODULE - " + (position + 1));
        holder.tvStudy.setPaintFlags(holder.tvStudy.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        holder.btnPractice.setText("CLICK HERE FOR PRACTICE QUESTIONS- " + (position + 1));
        //holder.tvLink.setPaintFlags(holder.tvLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        holder.btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ModulePracticeActivity.class)
                        .putExtra("MODULE", position + 1)
                        .putExtra(Constants.TYPE, type));
            }
        });
        holder.llStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, StudyMaterialActivity.class)
                        .putExtra("STUDY_MATERIAL", studyMaterialEntity)
                        .putExtra("MODULE", position + 1)
                        .putExtra(Constants.TYPE, type));
            }
        });
    }

    @Override
    public int getItemCount() {
        return studyMaterialEntities.size();
    }


}
