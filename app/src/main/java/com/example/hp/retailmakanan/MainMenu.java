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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment sfragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    sfragment = new FragHome();
                    break;
                case R.id.navigation_rekomen:
                    sfragment = new FragRekomen();
                    break;
                case R.id.navigation_cart:
                    sfragment = new FragCart();
                    break;
                case R.id.navigation_akun:
                    sfragment = new FragAkun();
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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_contain, new FragHome()).commit();
    }

}
