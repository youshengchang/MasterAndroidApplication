package com.infotech.masterandroidapplication.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.data.JobOffer;

/**
 * Created by youshengchang on 7/20/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView textViewName;
    public TextView textViewDescription;

    public MyViewHolder(View itemView) {
        super(itemView);
        textViewName = (TextView)itemView.findViewById(R.id.rowJobOfferTitle);
        textViewDescription = (TextView)itemView.findViewById(R.id.rowJobOfferDesc);

    }

    public void bindToJob(JobOffer jobOffer){
        textViewName.setText(jobOffer.title);
        textViewDescription.setText(jobOffer.description);

    }
}
