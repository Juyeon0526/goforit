package com.cookandroid.gif;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_home extends Fragment {

    Button setting, recommend, notebook, cpu, ram, gpu, hdd, ssd, power, mainboard;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);

        setting=rootView.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_setting.class ));
            }
        });

        recommend=rootView.findViewById(R.id.recommend);
        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_recommend.class ));
            }
        });

        notebook=rootView.findViewById(R.id.notebook);
        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_notebook.class ));
            }
        });

        cpu=rootView.findViewById(R.id.cpu);
        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_cpu.class ));
            }
        });

        ram=rootView.findViewById(R.id.ram);
        ram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_ram.class ));
            }
        });

        gpu=rootView.findViewById(R.id.gpu);
        gpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_gpu.class ));
            }
        });

        hdd=rootView.findViewById(R.id.hdd);
        hdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_hdd.class ));
            }
        });

        ssd=rootView.findViewById(R.id.ssd);
        ssd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_ssd.class ));
            }
        });

        power=rootView.findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_power.class ));
            }
        });

        mainboard=rootView.findViewById(R.id.mainboard);
        mainboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Button_mainboard.class ));
            }
        });

        return rootView;

    }


}
