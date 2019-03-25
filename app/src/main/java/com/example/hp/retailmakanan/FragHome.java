package com.example.hp.retailmakanan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FragHome extends Fragment {
    RecyclerView recV;
    BottomNavigationView top_navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            return false;
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.act_home, container, false);
        recV = (RecyclerView) v.findViewById(R.id.rec_ramen);
        HomeAdapter listAdapter = new HomeAdapter();
        recV.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recV.setLayoutManager(layoutManager);
        top_navigation = (BottomNavigationView) v.findViewById(R.id.top_nav);
        top_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        return v;

    }

}
