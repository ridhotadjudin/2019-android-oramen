package com.example.hp.retailmakanan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.hp.retailmakanan.Model.MenuModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragHome extends Fragment {
    RecyclerView recV;
    BottomNavigationView top_navigation;
    HomeAdapter listAdapter;
    List<MenuModel>  listMenu= new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment sfragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_noodle:
                    recV.setAdapter(listAdapter);
                    break;
                case R.id.nav_beverage:
                    recV.setAdapter(listAdapter);
                    break;
                case R.id.nav_toping:
                    recV.setAdapter(listAdapter);
                    break;
                case R.id.nav_cari:
                    recV.setAdapter(listAdapter);
                    break;
            }
            return false;
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.act_home, container, false);
        recV = (RecyclerView) v.findViewById(R.id.rec_ramen);
        getData();
        recV.setAdapter(listAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recV.setLayoutManager(layoutManager);
        top_navigation = (BottomNavigationView) v.findViewById(R.id.top_nav);
        top_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        return v;

    }

    private void getData() {
        String url ="https://waggish-requisition.000webhostapp.com/GetAllMenu.php";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listMenu.clear();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.d("menu",response.toString());
                        JSONObject jsonObject = response.getJSONObject(i);
                        String id_menu = jsonObject.getString("id");
                        String nama_menu = jsonObject.getString("nama_menu");
                        String deskripsi = jsonObject.getString("deskripsi");
                        int harga = jsonObject.getInt("harga");
                        String image = jsonObject.getString("gambar");

                        MenuModel menus = new MenuModel(id_menu,nama_menu,deskripsi,image,harga);
                        listMenu.add(menus);
                        //Toast.makeText(this,"Download data "+i,Toast.LENGTH_SHORT).show();
                        listAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("anggota",e.toString());
                    }


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonArrayRequest);
    }

}
