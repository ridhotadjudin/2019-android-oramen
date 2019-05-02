package com.example.hp.retailmakanan;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class FragRekomen extends Fragment {
    RecyclerView recyclerView1, recyclerView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act_rekomen, container, false);
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recv_rek_ramen);
        recyclerView2 = (RecyclerView) v.findViewById(R.id.recv_rek_minum);
        RekomenAdapterMinum rekM = new RekomenAdapterMinum();
        RekomenAdapterRamen rekR = new RekomenAdapterRamen();
        recyclerView1.setAdapter(rekR);
        recyclerView2.setAdapter(rekM);
        LinearLayoutManager lay1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager lay2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(lay1);
        recyclerView2.setLayoutManager(lay2);
    return v;
    }
}
