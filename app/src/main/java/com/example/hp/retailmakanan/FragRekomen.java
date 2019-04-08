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

import java.util.ArrayList;
import java.util.List;

public class FragRekomen extends Fragment {
    ViewPager viewPager;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    List<RekomenModel> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.act_rekomen, container, false);
        RekomenAdapter adapter = new RekomenAdapter();
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        return v;
    }
}
