package com.cookandroid.gif;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Button_setting extends AppCompatActivity {

    TextView textView, text_View, text2, text3;
    TextView selectedProduct;
    RadioGroup radioGroup, radioGroup2, radioGroup3, radioGroup4;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_setting);
        setTitle("맞춤 설정");

        textView =findViewById(R.id.text2);
        textView = findViewById(R.id.text_View);
        textView = findViewById(R.id.textView);
        textView = findViewById(R.id.text3);

        radioGroup = findViewById(R.id.radio_group);
        radioGroup2 = findViewById(R.id.radio_group2);
        radioGroup3 = findViewById(R.id.radio_group3);
        radioGroup4 = findViewById(R.id.radio_group4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_button_notebook:
                        selectedProduct.setText("노트북");
                        break;
                    case R.id.radio_button_cpu:
                        selectedProduct.setText("CPU");
                        break;
                    case R.id.radio_button_ram:
                        selectedProduct.setText("RAM");
                        break;
                    case R.id.radio_button_gpu:
                        selectedProduct.setText("GPU");
                        break;
                    case R.id.radio_button_hdd:
                        selectedProduct.setText("HDD");
                        break;
                    case R.id.radio_button_ssd:
                        selectedProduct.setText("SSD");
                        break;
                    case R.id.radio_button_power:
                        selectedProduct.setText("POWER");
                        break;
                    case R.id.radio_button_mainboard:
                        selectedProduct.setText("MainBoard");
                        break;
                }
            }
        });

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textView.setText(String.format("선택 가격은 %d 만원입니다.", seekBar.getProgress()));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_button_document:
                        selectedProduct.setText("문서 작업");
                        break;
                    case R.id.radio_button_lecture:
                        selectedProduct.setText("강의");
                        break;
                    case R.id.radio_button_game:
                        selectedProduct.setText("게임");
                        break;
                    case R.id.radio_button_player:
                        selectedProduct.setText("영상 편집");
                        break;
                    case R.id.radio_button_3d:
                        selectedProduct.setText("3D 그래픽");
                        break;
                    case R.id.radio_button_program:
                        selectedProduct.setText("프로그래밍");
                        break;
                }
            }
        });
        
        }
}
