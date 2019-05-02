package com.example.hp.retailmakanan;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class RekomenAdapterRamen extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recv_desain2, viewGroup, false);
        return new ListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((RekomenAdapterRamen.ListView) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return DataMenu.title.length;
    }

    private class ListView extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtNama, txtHarga;
        private ImageView mImg;

        public ListView (View view){
            super(view);
            txtNama = (TextView) view.findViewById(R.id.txt_card_title);
            txtHarga = (TextView) view.findViewById(R.id.txt_card_harga);
            mImg = (ImageView) view.findViewById(R.id.img_card_rek);

        }

        public void bindView (int pos){
            txtNama.setText(DataMenu.title[pos]);
            txtHarga.setText(DataMenu.harga[pos]);
            mImg.setImageResource(DataMenu.picture[pos]);


        }

        @Override
        public void onClick(View v) {

        }
    }
}
