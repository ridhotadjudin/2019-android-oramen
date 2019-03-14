package com.example.hp.retailmakanan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RekomenAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recv_desain2, viewGroup, false);
        return new RekomenAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((RekomenAdapter.ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return DataMenu.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mText;
        private ImageView mImg;
        private TextView txt2, txt3;

        public ListViewHolder(View itemView){
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.txt_rekomen);
            txt2 = (TextView) itemView.findViewById(R.id.txt_rekomen2);
            txt3 = (TextView) itemView.findViewById(R.id.txt_rekomen3);
            mImg = (ImageView) itemView.findViewById(R.id.img_rekomen);
            itemView.setOnClickListener(this);
        }

        public void bindView (int pos){
            mText.setText(DataMenu.title[pos]);
            txt2.setText(DataMenu.title2[pos]);
            txt3.setText(DataMenu.harga[pos]);
            mImg.setImageResource(DataMenu.picture_rek[pos]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
