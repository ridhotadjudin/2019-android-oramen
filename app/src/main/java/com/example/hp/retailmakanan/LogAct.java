package com.example.hp.retailmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LogAct extends AppCompatActivity {

    Button btn_login, btn_reg;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btn_reg =(Button) findViewById(R.id.button_reg);
        btn_login = (Button) findViewById(R.id.button_in);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toReg();
            }
        });
    }

    private void toMain(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
    private void toReg(){
        Intent intentreg = new Intent(this, RegAct.class);
        startActivity(intentreg);
    }
}
