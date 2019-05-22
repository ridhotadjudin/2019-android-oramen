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

public class RegAct extends AppCompatActivity {
    Button btn_regist, btn_cancel;
    EditText txtNama, txtEmail, txtPass, txtTelp, txtAlamat;
    String txtHak, nama,email,pass,alamat,telp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);
        btn_regist = (Button) findViewById(R.id.btn_daftar);
        btn_cancel = (Button) findViewById(R.id.btn_batal);
        txtNama = findViewById(R.id.txtUname);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtregisPass);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtTelp = findViewById(R.id.txtNotelp);
        txtHak = "Pelanggan";


        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama=txtNama.getText().toString();
                email = txtEmail.getText().toString();
                pass = txtPass.getText().toString();
                alamat = txtAlamat.getText().toString();
                telp = txtTelp.getText().toString();

                if(((nama.length()<1)&&(email.length()<1)&&(pass.length()<1)&&(alamat.length()<1) && (telp.length()<1))){
                    toWarn();
                }else{
                    String url = "https://waggish-requisition.000webhostapp.com/register.php";
                    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>()
                            {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("Registrasi Berhasil", response);
                                    Toast.makeText(RegAct.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                    RegAct.this.finish();
                                    toLog();
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d("Error.Response", error.toString());
                                    Toast.makeText(RegAct.this,"Koneksi bermasalah",Toast.LENGTH_SHORT).show();
                                }
                            }
                    ) {
                        @Override
                        protected Map<String, String> getParams()
                        {
                            Map<String, String>  params = new HashMap<String, String>();
                            params.put("email", email);
                            params.put("nama", nama);
                            params.put("alamat",alamat);
                            params.put("pwd", pass);
                            params.put("hak_akses", txtHak);
                            params.put("no_telp", telp);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(RegAct.this);
                    requestQueue.add(postRequest);
                }

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }

    private void toWarn() {
        Toast.makeText(RegAct.this, "Data tidak valid", Toast.LENGTH_SHORT).show();
    }

    private void toMain(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    private void toLog(){
        Intent intent = new Intent(this , LogAct.class);
        startActivity(intent);
    }
}
