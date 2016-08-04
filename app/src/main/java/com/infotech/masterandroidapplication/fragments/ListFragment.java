package com.infotech.masterandroidapplication.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.infotech.masterandroidapplication.OfferDetailActivity;
import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.viewholders.MyViewHolder;
import com.infotech.masterandroidapplication.data.JobOffer;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.Fragment {

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<JobOffer, MyViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    private List<JobOffer> mOfferList;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mOfferList = new ArrayList<JobOffer>();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        mRecycler.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set up Layout Manager, reverse layout
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        Query query = getQuery(mDatabase);

        mAdapter = new FirebaseRecyclerAdapter<JobOffer, MyViewHolder>(JobOffer.class, R.layout.row_job_offer, MyViewHolder.class, query) {
            @Override
            protected void populateViewHolder(MyViewHolder viewHolder, final JobOffer model, final int position) {
                final DatabaseReference jobRef = getRef(position);
                final String key = jobRef.getKey();
                Log.i("JOB", "populateViewHolder(): position: " + position + " model: " + model.toString() + " key: " + key);
                //mOfferList.add(model);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Log.i("JOB", "MyViewHolder onClick() start");

                        Intent intent = new Intent(getContext(), OfferDetailActivity.class);
                        TextView titleView = (TextView)v.findViewById(R.id.rowJobOfferTitle);
                        TextView descView =(TextView)v.findViewById(R.id.rowJobOfferDesc);
                        TextView imageLinkView = (TextView)v.findViewById(R.id.rowJobOfferImageLink);
                        String title = titleView.getText().toString();
                        String desc = descView.getText().toString();
                        String link = imageLinkView.getText().toString();
                        //JobOffer jobOffer = mOfferList.get(position);
                        Log.i("JOB", "title: " + title + " desc: " + desc + " imageLink: " + link);
                        intent.putExtra("job_title", title);
                        intent.putExtra("job_description", desc);
                        intent.putExtra("job_image", link);
                        getContext().startActivity(intent);

                    }
                });

                viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        mOfferList.remove(position);
                        notifyItemRemoved(position);

                        return true;
                    }
                });
                viewHolder.bindToJob(model);

            }
        };

        mRecycler.setAdapter(mAdapter);
    }

    private Query getQuery(DatabaseReference databaseReference) {

        Query query;
        query = databaseReference.child("JobOffer");
        return query;
    }
}