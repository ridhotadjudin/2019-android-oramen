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
import android.widget.TextView;

public class FragHome extends Fragment {
    RecyclerView recV;
    BottomNavigationView top_navigation;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment sfragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_noodle:
                    mTextMessage.setText(R.string.title_home);
                    break;
                case R.id.nav_beverage:
                    mTextMessage.setText(R.string.title_home);
                    break;
                case R.id.nav_toping:
                    mTextMessage.setText(R.string.title_home);
                    break;
                case R.id.nav_cari:
                    mTextMessage.setText(R.string.title_home);
                    break;
            }
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recV.setLayoutManager(layoutManager);
        top_navigation = (BottomNavigationView) v.findViewById(R.id.top_nav);
        top_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        return v;

    }

}
