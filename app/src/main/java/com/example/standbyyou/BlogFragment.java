package com.example.standbyyou;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class BlogFragment extends Fragment {

    Context thiscontext;
    TabLayout tabLayout;
    TabItem homenews   , awarnessnews;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thiscontext = container.getContext();
        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);

        mtoolbar = rootView.findViewById(R.id.toolbar);

        // Access the parent activity and set the toolbar as the action bar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(mtoolbar);
        }

        homenews= rootView.findViewById(R.id.home_news);
        awarnessnews= rootView.findViewById(R.id.awareness_news);


        return rootView;
    }
}