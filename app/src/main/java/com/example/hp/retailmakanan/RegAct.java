package com.example.hp.retailmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegAct extends AppCompatActivity {
    Button btn_regist, btn_cancel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);
        btn_regist = (Button) findViewById(R.id.btn_daftar);
        btn_cancel = (Button) findViewById(R.id.btn_batal);

       btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLog();
            }
        });

    }

    private void toMain(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    private void toLog(){
        Intent intent = new Intent(this, LogAct.class);
        startActivity(intent);
    }
}
