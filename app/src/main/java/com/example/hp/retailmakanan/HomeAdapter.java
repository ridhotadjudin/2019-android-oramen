package com.example.hp.retailmakanan;

import android.content.ClipData;
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
import com.example.hp.retailmakanan.Model.RamenModel;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ListViewHolder> {

    private List<MenuModel> menu;
    private Context context;
    int x;
    Button plus;
    TextView qty;

    public HomeAdapter(List<MenuModel> menu, Context context) {
        this.menu = menu;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recv_desain, viewGroup, false);
        return new HomeAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int i) {
        x=0;
        MenuModel model = menu.get(i);
        listViewHolder.mText.setText(model.getNama_menu());
        listViewHolder.txt2.setText(model.getDeskripsi());
        listViewHolder.txt3.setText(String.valueOf(model.getHarga()));
        Picasso.with(context).load(model.getImgUrl()).into(listViewHolder.img);

        listViewHolder.txtQty.setText(String.valueOf(x));
        listViewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                listViewHolder.txtQty.setText(String.valueOf(x));
            }
        });

        listViewHolder.btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x--;
                if (x<=0){
                    x=0;
                    listViewHolder.txtQty.setText(String.valueOf(x));
                }else if (x>0){
                    listViewHolder.txtQty.setText(String.valueOf(x));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return menu.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView mText,txt2, txt3, txtQty;
        public ImageView img;
        public Button btnMin, btnPlus;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            mText = itemView.findViewById(R.id.text_item);
            txt2 = itemView.findViewById(R.id.text_item2);
            txt3 = itemView.findViewById(R.id.textView3);
            img = itemView.findViewById(R.id.image_item);
            txtQty = itemView.findViewById(R.id.textQtyMenu);
            btnMin = itemView.findViewById(R.id.buttonMinMenu);
            btnPlus = itemView.findViewById(R.id.buttonPlusMenu);

        }
    }
}
