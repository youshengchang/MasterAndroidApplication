package com.infotech.masterandroidapplication.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.viewholders.MyViewHolder;
import com.infotech.masterandroidapplication.data.JobOffer;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.Fragment {

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<JobOffer, MyViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

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
            protected void populateViewHolder(MyViewHolder viewHolder, JobOffer model, int position) {
                final DatabaseReference jobRef = getRef(position);
                final String key = jobRef.getKey();
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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