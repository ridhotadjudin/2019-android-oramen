package com.example.hp.retailmakanan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragHome extends Fragment {
    RecyclerView recV;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.act_home, container, false);
        recV = (RecyclerView) v.findViewById(R.id.rec_ramen);
        HomeAdapter listAdapter = new HomeAdapter();
        recV.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recV.setLayoutManager(layoutManager);
        return v;
    }

}
