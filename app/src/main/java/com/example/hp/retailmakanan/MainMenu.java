package com.example.hp.retailmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity{

    BottomNavigationView top_navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment sfragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    sfragment = new FragHome();
                    top_navigation.setVisibility(View.VISIBLE);
                    break;
                case R.id.navigation_rekomen:
                    sfragment = new FragRekomen();
                    top_navigation.setVisibility(View.GONE);
                    break;
                case R.id.navigation_cart:
                    sfragment = new FragCart();
                    top_navigation.setVisibility(View.GONE);
                    break;
                case R.id.navigation_akun:
                    sfragment = new FragAkun();
                    top_navigation.setVisibility(View.GONE);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain, sfragment).commit();
            return true;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        top_navigation = (BottomNavigationView) findViewById(R.id.top_nav);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain, new FragHome()).commit();
    }

}
