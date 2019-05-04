package com.example.hp.retailmakanan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.retailmakanan.Model.MenuModel;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    private List<MenuModel> menus;
    private Context context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recv_desain, viewGroup, false);
        return new ListViewHolder(view);
    }

    public HomeAdapter(List<MenuModel> menu, Context context){
        menus = menu;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        ((ListViewHolder) viewHolder).bindView(pos);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }



    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mText;
        private ImageView mImg;
        private TextView txt2, txt3;

        public ListViewHolder(View itemView){
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.text_item);
            txt2 = (TextView) itemView.findViewById(R.id.text_item2);
            txt3 = (TextView) itemView.findViewById(R.id.textView3);
            mImg = (ImageView) itemView.findViewById(R.id.image_item);
            itemView.setOnClickListener(this);
        }

        public void bindView (int pos){
            mText.setText(menus.get(pos).getNama_menu());
            txt2.setText(menus.get(pos).getDeskripsi());
            txt3.setText(menus.get(pos).getHarga());
            mImg.setImageResource(DataMenu.picture[pos]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
