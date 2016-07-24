package com.infotech.masterandroidapplication.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.adapters.JobContactsAdapter;
import com.infotech.masterandroidapplication.data.Country;
import com.infotech.masterandroidapplication.data.JobContact;
import com.infotech.masterandroidapplication.data.JobOffer;
import com.infotech.masterandroidapplication.viewholders.CompanyViewHolder;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends android.support.v4.app.Fragment {

    List<Object> mListItems;
    private DatabaseReference mDatabase;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    private FirebaseRecyclerAdapter<JobContact, CompanyViewHolder> mAdapter;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_contact, null);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = (RecyclerView)view.findViewById(R.id.job_contact_view);
        mRecycler.setHasFixedSize(true);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        Query query = getQuery(mDatabase);


        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.i("JOB", "onDataChange called.");
                Log.i("JOB", dataSnapshot.toString());
                Log.i("JOB", dataSnapshot.getChildrenCount() +"");
                for(DataSnapshot child: dataSnapshot.getChildren()){
                    Log.i("JOB", child.toString());
                    JobContact contact = (JobContact) child.getValue(JobContact.class);
                    Log.i("JOB", contact.toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAdapter = new FirebaseRecyclerAdapter<JobContact, CompanyViewHolder>(JobContact.class, R.layout.row_job_contact, CompanyViewHolder.class, query) {
            @Override
            protected void populateViewHolder(CompanyViewHolder viewHolder, JobContact model, int position) {
                viewHolder.bindToJobContact(model);
            }
        };

        mRecycler.setAdapter(mAdapter);

    }



    private Query getQuery(DatabaseReference databaseReference) {

        Query query;
        query = databaseReference.child("JobContact");
        return query;
    }


}
