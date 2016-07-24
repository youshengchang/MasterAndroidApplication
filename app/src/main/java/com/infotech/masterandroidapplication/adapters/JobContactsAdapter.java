package com.infotech.masterandroidapplication.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.data.Country;
import com.infotech.masterandroidapplication.data.JobContact;

import java.util.List;

/**
 * Created by youshengchang on 7/12/16.
 */
public class JobContactsAdapter extends BaseAdapter {

    private List<Object> mItemsList;
    private Context mContext;

    public JobContactsAdapter(List<Object> mItemsList, Context mContext) {
        this.mItemsList = mItemsList;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mItemsList.get(position) instanceof Country ? 0 : 1;

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        switch (getItemViewType(position)){
            case 0:
                CountryViewHolder holderC;
                if(view == null){
                    view = View.inflate(mContext, R.layout.row_job_country, null);
                    holderC = new CountryViewHolder();
                    holderC.name = (TextView)view.findViewById(R.id.rowJobCountryTitle);
                    holderC.flag = (ImageView)view.findViewById(R.id.rowJobCountryImage);
                    view.setTag(view);

                }else {
                    holderC = (CountryViewHolder) view.getTag();
                }
                holderC.bindView((Country)mItemsList.get(position));
                break;
            case 1:
                CompanyViewHolder holder;
                if(view == null){
                    view = View.inflate(mContext, R.layout.row_job_contact, null);
                    holder = new CompanyViewHolder();
                    holder.name = (TextView)view.findViewById(R.id.rowJobContactName);
                    holder.email = (TextView)view.findViewById(R.id.rowJobContactEmail);
                    holder.desc = (TextView)view.findViewById(R.id.rowJobContactDesc);
                    view.setTag(holder);
                }else {
                    holder = (CompanyViewHolder) mItemsList.get(position);
                }
                holder.bindView((JobContact)mItemsList.get(position));
                break;

        }
        return view;
    }

    private class CountryViewHolder{

        public TextView name;
        public ImageView flag;

        public void bindView(Country country){
            this.name.setText(country.getName());
            this.flag.setImageResource(country.getImageRes(mContext));
        }

    }

    private class CompanyViewHolder{

        public TextView name;
        public TextView email;
        public TextView desc;

        public void bindView(JobContact company){
            this.name.setText(company.name);
            this.email.setText(company.email);
            this.desc.setText(company.description);
        }

    }
}
