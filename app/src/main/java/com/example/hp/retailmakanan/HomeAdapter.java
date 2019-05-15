package com.example.hp.retailmakanan;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.retailmakanan.Model.MenuModel;

import java.util.Arrays;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    private List<MenuModel> menus;
    private Context context;

    public HomeAdapter(List<MenuModel> menus, Context context) {
        this.context = context;
        this.menus = menus;
        //System.out.println(menus);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recv_desain, viewGroup, false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mText,txt2, txt3, txtQty;
        ImageView img;
        Button btnMin, btnPlus;
        int x;

        public ListViewHolder(View itemView){
            super(itemView);
            mText = itemView.findViewById(R.id.text_item);
            txt2 = itemView.findViewById(R.id.text_item2);
            txt3 = itemView.findViewById(R.id.textView3);
            img = itemView.findViewById(R.id.image_item);
            btnMin = itemView.findViewById(R.id.buttonMinMenu);
            btnPlus = itemView.findViewById(R.id.buttonPlusMenu);
            txtQty = itemView.findViewById(R.id.textQtyMenu);
            itemView.setOnClickListener(this);
        }

        public void bindView (int pos){
            x=0;
            MenuModel model = menus.get(pos);
            mText.setText(model.getNama_menu());
            txt2.setText(model.getDeskripsi());
            txt3.setText(model.getHarga());
            //img.setImageResource(DataMenu.picture[pos]);

            txtQty.setText(String.valueOf(x));
            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x++;
                    txtQty.setText(String.valueOf(x));

                }
            });

            btnMin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x--;
                    if (x<=0){
                        x=0;
                        txtQty.setText(String.valueOf(x));
                    }else if (x>0){
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
