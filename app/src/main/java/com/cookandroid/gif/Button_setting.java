package com.cookandroid.gif;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.gif.models.Rec;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Button_setting extends AppCompatActivity {

    TextView textView, text_View, text2, text3;
    TextView selectedProduct;
    String prodId;
    String purposeCategory;
    RadioGroup radioGroup, radioGroup2, radioGroup3, radioGroup4;
    Button finish;
    private SeekBar seekBar;

    private DatabaseReference recReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_setting);
        setTitle("맞춤 설정");

        textView = findViewById(R.id.text2);
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
               /* switch (checkedId){
                    case R.id.radio_button_notebook:
                        selectedProduct.setText("노트북");
                        break;
                    case R.id.radio_button_cpu:
                        selectedProduct.setText("CPU");
                        break;
                    case R.id.radio_button_ram:
                        selectedProduct.setText("RAM");
                        break;
                    case R.id.radio_button_rom:
                        selectedProduct.setText("ROM");
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
                }*/

                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if (rb.isChecked() && radioGroup2.getCheckedRadioButtonId() != -1)
                        radioGroup2.clearCheck();
                    prodId = ((Button) findViewById(checkedId)).getText().toString();
                }

            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               /* switch (checkedId){
                    case R.id.radio_button_notebook:
                        selectedProduct.setText("노트북");
                        break;
                    case R.id.radio_button_cpu:
                        selectedProduct.setText("CPU");
                        break;
                    case R.id.radio_button_ram:
                        selectedProduct.setText("RAM");
                        break;
                    case R.id.radio_button_rom:
                        selectedProduct.setText("ROM");
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
                }*/

                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if (rb.isChecked() && radioGroup.getCheckedRadioButtonId() != -1)
                        radioGroup.clearCheck();
                    prodId = ((Button) findViewById(checkedId)).getTag().toString();
                }

            }
        });


        seekBar = findViewById(R.id.seekBar);
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

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*switch (checkedId) {
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
                }*/

                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if (rb.isChecked() && radioGroup4.getCheckedRadioButtonId() != -1)
                        radioGroup4.clearCheck();
                    purposeCategory = ((Button) findViewById(checkedId)).getTag().toString();
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*switch (checkedId) {
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
                }*/

                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if (rb.isChecked() && radioGroup3.getCheckedRadioButtonId() != -1)
                        radioGroup3.clearCheck();
                    purposeCategory = ((Button) findViewById(checkedId)).getTag().toString();
                }
            }
        });

        recReference = FirebaseDatabase.getInstance().getReference()
                .child("rec_choice");

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String uid = getUid();
                Rec rec = new Rec(prodId, purposeCategory, String.valueOf(seekBar.getProgress()*10000));
                recReference.child(uid).setValue(rec).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                    }
                });
            }
        });


    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
