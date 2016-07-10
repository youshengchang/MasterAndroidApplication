package com.infotech.masterandroidapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech.masterandroidapplication.R;
import com.infotech.masterandroidapplication.data.JobOffer;
import com.parse.ParseObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        view.findViewById(R.id.addJoboffer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("JOBOFFER", "JobOffer");

                JobOffer jobOffer = new JobOffer();
                jobOffer.setTitle("Software Developer");
                jobOffer.setDescription("Develope Spring Framework");
                jobOffer.setCompany("Infotech Inc.");
                jobOffer.setType("Contractor");
                jobOffer.setImageLink("http://infotech.com/resource/compang.jpg");
                jobOffer.setLocation("san Francisco CA");
                jobOffer.setSalary("100.00/per Hour");
                /*
                jobOffer.put("title", "Android Contract");
                jobOffer.put("description", "6 months rolling    contract. /n The client" +
                        "is a worldwide known digital agency");
                jobOffer.put("type", "Contract");
                jobOffer.put("salary", "450 GBP/day");
                jobOffer.put("company", "Recruiters LTD");
                jobOffer.put("imageLink", "http://infotech/res/recruitersLTD_logo.png");
                jobOffer.put("location","Reading, UK");
                */
                jobOffer.saveInBackground();
            }
        });

        return view;
    }


}
