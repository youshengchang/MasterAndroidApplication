package com.infotech.masterandroidapplication.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.data.JobContact;

/**
 * Created by youshengchang on 7/23/16.
 */
public class CompanyViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public TextView email;
    public TextView desc;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.rowJobContactName);
        email = (TextView)itemView.findViewById(R.id.rowJobContactEmail);
        desc = (TextView)itemView.findViewById(R.id.rowJobContactDesc);

    }

    public void bindToJobContact(JobContact company){
        this.name.setText(company.name);
        this.email.setText(company.email);
        this.desc.setText(company.description);

    }

}
