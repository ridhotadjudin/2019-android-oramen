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

    Button btnSetting;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.act_akun, container, false);

        btnSetting = (Button) v.findViewById(R.id.btn_setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSetting();
            }
        });

        return v;
    }

    private void toSetting(){
        Intent intent = new Intent(getActivity(), EditAkunAct.class);
        startActivity(intent);
    }
}
