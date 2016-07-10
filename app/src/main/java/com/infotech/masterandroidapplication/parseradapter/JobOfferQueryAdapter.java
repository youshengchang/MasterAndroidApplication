package com.infotech.masterandroidapplication.parseradapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.data.JobOffer;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

/**
 * Created by youshengchang on 7/9/16.
 */
public class JobOfferQueryAdapter extends ParseQueryAdapter<JobOffer> {

    public JobOfferQueryAdapter(Context context, String className) {
        super(context, className);
    }

    public JobOfferQueryAdapter(Context context, Class<? extends ParseObject> clazz) {
        super(context, clazz);
    }

    @Override
    public View getItemView(JobOffer object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.row_job_offer, null);
        }

        super.getItemView(object, v, parent);

        TextView titleTextView = (TextView) v.findViewById(R.id.rowJobOfferTitle);
        titleTextView.setText(object.getTitle());
        TextView descTextView = (TextView) v.findViewById(R.id.rowJobOfferDesc);
        descTextView.setText(object.getDescription());

        return v;
    }

}
