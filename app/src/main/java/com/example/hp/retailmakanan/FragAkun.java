package com.example.hp.retailmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragAkun extends Fragment {

    Button btnSetting, btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.act_akun, container, false);

        btnSetting = (Button) v.findViewById(R.id.btn_setting);
        btnLogout =  v.findViewById(R.id.btn_logout);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSetting();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogout();
            }
        });

        return v;
    }

    private void toLogout() {
        Intent intent = new Intent(getActivity(), LogAct.class);
        startActivity(intent);

    }

    private void toSetting(){
        Intent intent = new Intent(getActivity(), EditAkunAct.class);
        startActivity(intent);
    }
}
