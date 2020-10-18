package com.stankingo;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.stankingo.MainActivity.data;

public class Day_red extends Activity {
    EditText n1, d1, n2, d2, n3, d3, n4, d4;
    TextView t1, tt1, t2, tt2, t3, tt3, t4, tt4;
    View v1, v3, v2, v4;
    String s1 = "кн", s2 = "кн", s3 = "кн", s4 = "кн", ncl, dw, cl1, cl2, cl3, cl4;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch sw1, sw2, sw3, sw4;

    int flag = 0;

    @SuppressLint({"SetTextI18n", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_red);
        ncl = getIntent().getStringExtra("ncl");
        dw = getIntent().getStringExtra("dcl");

        sw1 = (Switch) findViewById(R.id.switch1); sw2 = (Switch) findViewById(R.id.switch2);
        sw3 = (Switch) findViewById(R.id.switch3); sw4 = (Switch) findViewById(R.id.switch4);

        sw1.setOnCheckedChangeListener(listener); sw2.setOnCheckedChangeListener(listener);
        sw3.setOnCheckedChangeListener(listener); sw4.setOnCheckedChangeListener(listener);

        v1 = (View) findViewById(R.id.view13); v3 = (View) findViewById(R.id.view19);
        v2 = (View) findViewById(R.id.view18); v4 = (View) findViewById(R.id.view20);

        n1 = (EditText) findViewById(R.id.editTextTextPersonName);
        d1 = (EditText) findViewById(R.id.editTextDate);
        n2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        d2 = (EditText) findViewById(R.id.editTextDate2);
        n3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        d3 = (EditText) findViewById(R.id.editTextDate3);
        n4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        d4 = (EditText) findViewById(R.id.editTextDate4);

        t1 = (TextView) findViewById(R.id.textView8);
        tt1 = (TextView) findViewById(R.id.textView9);
        t2 = (TextView) findViewById(R.id.textView10);
        tt2 = (TextView) findViewById(R.id.textView11);
        t3 = (TextView) findViewById(R.id.textView12);
        tt3 = (TextView) findViewById(R.id.textView13);
        t4 = (TextView) findViewById(R.id.textView14);
        tt4 = (TextView) findViewById(R.id.textView15);


        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).day.equals(dw)) {
                if (data.get(i).num.equals(ncl)) {
                    flag++;
                    if (flag == 1) {
                        d1.setVisibility(View.VISIBLE);
                        v1.setVisibility(View.VISIBLE);
                        sw1.setVisibility(View.VISIBLE);
                        t1.setVisibility(View.VISIBLE);
                        tt1.setVisibility(View.VISIBLE);
                        cl1 = data.get(i).classes; n1.setText(cl1);
                        n1.setVisibility(View.VISIBLE);
                        d1.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                    if (flag == 2) {
                        d2.setVisibility(View.VISIBLE);
                        v2.setVisibility(View.VISIBLE);
                        sw2.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.VISIBLE);
                        tt2.setVisibility(View.VISIBLE);
                        cl2 = data.get(i).classes; n2.setText(cl2);
                        n2.setVisibility(View.VISIBLE);
                        d2.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                    if (flag == 3) {
                        d3.setVisibility(View.VISIBLE);
                        v3.setVisibility(View.VISIBLE);
                        sw3.setVisibility(View.VISIBLE);
                        t3.setVisibility(View.VISIBLE);
                        tt3.setVisibility(View.VISIBLE);
                        cl3 = data.get(i).classes; n3.setText(cl3);
                        n3.setVisibility(View.VISIBLE);
                        d3.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                    if (flag == 4) {
                        d4.setVisibility(View.VISIBLE);
                        v4.setVisibility(View.VISIBLE);
                        sw4.setVisibility(View.VISIBLE);
                        t4.setVisibility(View.VISIBLE);
                        tt4.setVisibility(View.VISIBLE);
                        cl4 = data.get(i).classes; n4.setText(cl4);
                        n4.setVisibility(View.VISIBLE);
                        d4.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                }
            }
        }

    }

    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.switch1:
                    if (sw1.isChecked()) s1 = "чн";
                    else s1 = "кн";
                    break;
                case R.id.switch2:
                    if (sw2.isChecked()) s2 = "чн";
                    else s2 = "кн";
                    break;
                case R.id.switch3:
                    if (sw3.isChecked()) s3 = "чн";
                    else s3 = "кн";
                    break;
                case R.id.switch4:
                    if (sw4.isChecked()) s4 = "чн";
                    else s4 = "кн";
                    break;
            }
        }
    };

    public void eddbtn( View v ) {
        if (v.getId() == R.id.button2) {
            if (flag == 2) {
                n2.setVisibility(View.VISIBLE); d2.setVisibility(View.VISIBLE);
                v2.setVisibility(View.VISIBLE); sw2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE); tt2.setVisibility(View.VISIBLE);
                flag++;
                return;
            }
            if (flag == 3) {
                n3.setVisibility(View.VISIBLE); d3.setVisibility(View.VISIBLE);
                v3.setVisibility(View.VISIBLE); sw3.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE); tt3.setVisibility(View.VISIBLE);
            }
            if (flag == 4) {
                n4.setVisibility(View.VISIBLE); d4.setVisibility(View.VISIBLE);
                v4.setVisibility(View.VISIBLE); sw4.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE); tt4.setVisibility(View.VISIBLE);
                Button btn = (Button) findViewById(R.id.button2);
                btn.setVisibility(View.INVISIBLE);
            }
        }
    }

    int d = data.size();
    @Override
    public void onBackPressed() {
        int f1 = 0, f2 = 0 , f3 = 0, f4 = 0;
        for( int i = 0; i < d; i++){

            Toast tos = Toast.makeText(getApplicationContext(),
                    "Нельзя удалить единственную запись", Toast.LENGTH_SHORT);

            if (data.get(i).classes.equals(cl1)){
                if (!cl1.equals(n1.getText().toString()) && f1 == 0){
                    if (!n1.getText().toString().equals("")) {
                        String[] str = d1.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n1.getText().toString(), str[0], str[1], s1, ncl);
                        data.add(db);
                    }else if (data.size() == 1) {
                        tos.show();
                    }else {
                        data.remove(i);
                    }
                }else{
                String[] str = d1.getText().toString().split("-");
                data.get(i).data_start = str[0];
                data.get(i).data_end = str[1];
                data.get(i).period = s1;
                }
                f1++;
            }else {
                if (f1 == 0) {
                    if (!n1.getText().toString().equals("")) {
                        String[] str = d1.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n1.getText().toString(), str[0], str[1], s1, ncl);
                        data.add(db);
                        f1++;
                    }
                }
            }

            if (data.get(i).classes.equals(cl2)){
                if (!cl2.equals(n2.getText().toString()) && f2 == 0){
                    if (!n2.getText().toString().equals("")) {
                        String[] str = d2.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n2.getText().toString(), str[0], str[1], s2, ncl);
                        data.add(db);
                    }else if (data.size() == 1) {
                        tos.show();
                    }else {
                        data.remove(i);
                    }
                }else{
                    String[] str = d2.getText().toString().split("-");
                    data.get(i).data_start = str[0];
                    data.get(i).data_end = str[1];
                    data.get(i).period = s2;
                }
                f2++;
            }else {
                if (f2 == 0) {
                    if (!n2.getText().toString().equals("")) {
                        String[] str = d2.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n2.getText().toString(), str[0], str[1], s2, ncl);
                        data.add(db);
                        f2++;
                    }
                }
            }

            if (data.get(i).classes.equals(cl3)){
                if (!cl3.equals(n3.getText().toString()) && f3 == 0){
                    if (!n3.getText().toString().equals("")) {
                        String[] str = d3.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n3.getText().toString(), str[0], str[1], s3, ncl);
                        data.add(db);
                    }else if (data.size() == 1) {
                        tos.show();
                    }else {
                        data.remove(i);
                    }
                }else{
                    String[] str = d3.getText().toString().split("-");
                    data.get(i).data_start = str[0];
                    data.get(i).data_end = str[1];
                    data.get(i).period = s3;
                }
                f3++;
            } else {
                if (f3 == 0) {
                    if (!n3.getText().toString().equals("")) {
                        String[] str = d3.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n3.getText().toString(), str[0], str[1], s3, ncl);
                        data.add(db);
                        f3++;
                    }
                }
            }

            if (data.get(i).classes.equals(cl4)){
                if (!cl4.equals(n4.getText().toString()) && f4 == 0){
                    if (!n4.getText().toString().equals("")) {
                        String[] str = d4.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n4.getText().toString(), str[0], str[1], s4, ncl);
                        data.add(db);
                    }else if (data.size() == 1) {
                        tos.show();
                    }else {
                        data.remove(i);
                    }
                }else{
                    String[] str = d4.getText().toString().split("-");
                    data.get(i).data_start = str[0];
                    data.get(i).data_end = str[1];
                    data.get(i).period = s4;
                }
                f4++;
            }else {
                if (f4 == 0 ) {
                    if (!n4.getText().toString().equals("")) {
                        String[] str = d4.getText().toString().split("-");
                        DBHelp db = new DBHelp(dw, n4.getText().toString(), str[0], str[1], s4, ncl);
                        data.add(db);
                        f4++;
                    }
                }
            }
        }
        if (data.size() == 0){
            if (!n1.getText().toString().equals("")) {
                String[] str = d1.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n1.getText().toString(), str[0], str[1], s1, ncl);
                data.add(db);
                f1++;
            }
            if (!n2.getText().toString().equals("")) {
                String[] str = d2.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n2.getText().toString(), str[0], str[1], s2, ncl);
                data.add(db);
                f2++;
            }
            if (!n3.getText().toString().equals("")) {
                String[] str = d3.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n3.getText().toString(), str[0], str[1], s3, ncl);
                data.add(db);
                f3++;
            }
            if (!n4.getText().toString().equals("")) {
                String[] str = d4.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n4.getText().toString(), str[0], str[1], s4, ncl);
                data.add(db);
                f4++;
            }

        }
        finish();
    }
}