package com.example.hp.retailmakanan;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CartAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recv_cart, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((CartAdapter.ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return DataMenu.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtM,txtSub,txtTot;
        private ImageView img;
        Button btnMincart, btnPluscart, btnDelete;
        TextView txtQty;
        int x;

        public ListViewHolder(View view){
            super(view);
            txtM = (TextView) view.findViewById(R.id.txt_cart_item);
            txtSub = (TextView) view.findViewById(R.id.txt_cart_harga);
            txtTot = (TextView) view.findViewById(R.id.txt_cart_total);
            img = (ImageView) view.findViewById(R.id.imgv_cart);
            btnMincart = view.findViewById(R.id.btn_cart_min);
            btnPluscart = view.findViewById(R.id.btn_cart_plus);
            btnDelete = view.findViewById(R.id.btn_cart_delete);
            txtQty = view.findViewById(R.id.txt_cart_qty);
        }

        public void bindView (int pos){
            x=0;
            txtM.setText(DataMenu.title[pos]);
            txtSub.setText(DataMenu.harga[pos]);
            img.setImageResource(DataMenu.picture[pos]);


            txtQty.setText(String.valueOf(x));
            btnPluscart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x++;
                    txtQty.setText(String.valueOf(x));
                }
            });

            btnMincart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x--;
                    if(x<=0){
                        x=0;
                        txtQty.setText(String.valueOf(x));
                    }else if(x>0){
                        txtQty.setText(String.valueOf(x));
                    }
                }
            });


        }

        @Override
        public void onClick(View v) {

        }
    }
}
