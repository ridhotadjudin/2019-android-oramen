package com.example.hp.retailmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LogAct extends AppCompatActivity {
    EditText txtEmail, txtPass;
    TextView akunemail;
    String email, pwd;
    Button btn_login, btn_reg;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btn_reg =(Button) findViewById(R.id.button_reg);
        btn_login = (Button) findViewById(R.id.button_in);

        txtEmail = findViewById(R.id.textLoginEmail);
        txtPass = findViewById(R.id.editTextPwd);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = txtEmail.getText().toString();
                pwd = txtPass.getText().toString();
                if ((email.length()<1)&&(pwd.length()<1)){
                    toWarn();
                } else {
                    String url = "https://waggish-requisition.000webhostapp.com/login.php";
                    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("Registrasi Berhasil", response);
                                    Toast.makeText(LogAct.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                    toMain();
                                    LogAct.this.finish();
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d("Error.Response", error.toString());
                                    Toast.makeText(LogAct.this,"Koneksi bermasalah",Toast.LENGTH_SHORT).show();
                                }
                            }
                    ) {
                        @Override
                        protected Map<String, String> getParams()
                        {
                            Map<String, String>  params = new HashMap<String, String>();
                            params.put("email", email);
                            params.put("pwd", pwd);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(LogAct.this);
                    requestQueue.add(postRequest);
                }
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toReg();
            }
        });
    }

    private void toWarn() {
        Toast.makeText(LogAct.this, "Email dan Password tidak valid", Toast.LENGTH_SHORT).show();
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
