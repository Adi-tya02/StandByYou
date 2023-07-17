package com.example.standbyyou;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ProfileFragment extends Fragment {

    Context thiscontext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thiscontext = container.getContext();


        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}