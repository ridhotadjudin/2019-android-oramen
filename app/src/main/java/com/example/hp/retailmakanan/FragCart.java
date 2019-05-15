package com.example.hp.retailmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragCart extends Fragment {
    RecyclerView recyclerView;
    Button btnStruk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.act_cart, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recv_cart);
        CartAdapter listAdapter = new CartAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        btnStruk = v.findViewById(R.id.btn_bayar);

        btnStruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toStruk();
            }
        });


        return v;
    }

    private void toStruk(){
        Intent intent = new Intent(this.getContext(), StrukAct.class);
        startActivity(intent);
    }
}
