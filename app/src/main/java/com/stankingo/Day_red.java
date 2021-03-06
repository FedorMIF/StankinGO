package com.stankingo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

import static com.stankingo.MainActivity.data;


public class Day_red extends Activity {
    EditText n1, d1, n2, d2, n3, d3, n4, d4, a1, a2, a3, a4;
    TextView t1, tt1, t2, tt2, t3, tt3, t4, tt4, ta1, ta2, ta3, ta4;
    View v1, v3, v2, v4;
    LinearLayout l11, l12, l13, l21, l22, l23, l31, l32, l33;
    String s1 = "кн", s2 = "кн", s3 = "кн", s4 = "кн", ncl, dw, cl1, cl2, cl3, cl4;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch sw1, sw2, sw3, sw4;

    int flag = 0, fl = 0;

    @SuppressLint({"SetTextI18n", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_red1);
        Update();
    }

    @SuppressLint("SetTextI18n")
    public void Update(){
        flag = 0;
        ncl = getIntent().getStringExtra("ncl"); // номер пары
        dw = getIntent().getStringExtra("dcl"); // день недели

        sw1 = (Switch) findViewById(R.id.yn1); sw2 = (Switch) findViewById(R.id.yn2);
        sw3 = (Switch) findViewById(R.id.yn3); sw4 = (Switch) findViewById(R.id.yn4);

        sw1.setOnCheckedChangeListener(listener); sw2.setOnCheckedChangeListener(listener);
        sw3.setOnCheckedChangeListener(listener); sw4.setOnCheckedChangeListener(listener);

        v1 = (View) findViewById(R.id.view24); v3 = (View) findViewById(R.id.view21);
        v2 = (View) findViewById(R.id.view22); v4 = (View) findViewById(R.id.view23);

        l11 = (LinearLayout) findViewById(R.id.st11);
        l12 = (LinearLayout) findViewById(R.id.st12);
        l13 = (LinearLayout) findViewById(R.id.st13);
        l21 = (LinearLayout) findViewById(R.id.st21);
        l22 = (LinearLayout) findViewById(R.id.st22);
        l23 = (LinearLayout) findViewById(R.id.st23);
        l31 = (LinearLayout) findViewById(R.id.st31);
        l32 = (LinearLayout) findViewById(R.id.st32);
        l33 = (LinearLayout) findViewById(R.id.st33);

        n1 = (EditText) findViewById(R.id.text_dist1);
        d1 = (EditText) findViewById(R.id.text_date1);
        n2 = (EditText) findViewById(R.id.text_dist2);
        d2 = (EditText) findViewById(R.id.text_date2);
        n3 = (EditText) findViewById(R.id.text_dist3);
        d3 = (EditText) findViewById(R.id.text_date3);
        n4 = (EditText) findViewById(R.id.text_dist4);
        d4 = (EditText) findViewById(R.id.text_date4);
        a1 = (EditText) findViewById(R.id.text_num1);
        a2 = (EditText) findViewById(R.id.text_num2);
        a3 = (EditText) findViewById(R.id.text_num3);
        a4 = (EditText) findViewById(R.id.text_num4);

        t1 = (TextView) findViewById(R.id.name_dist1);
        tt1 = (TextView) findViewById(R.id.date1);
        t2 = (TextView) findViewById(R.id.name_dist2);
        tt2 = (TextView) findViewById(R.id.date2);
        t3 = (TextView) findViewById(R.id.name_dist3);
        tt3 = (TextView) findViewById(R.id.date3);
        t4 = (TextView) findViewById(R.id.name_dist4);
        tt4 = (TextView) findViewById(R.id.date4);
        ta1 = (TextView) findViewById(R.id.num_aud1);
        ta2 = (TextView) findViewById(R.id.num_aud2);
        ta3 = (TextView) findViewById(R.id.num_aud3);
        ta4 = (TextView) findViewById(R.id.num_aud4);


        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).day.equals(dw)) {
                if (data.get(i).num.equals(ncl)) {
                    flag++;
                    if (flag == 1) {
                        d1.setVisibility(View.VISIBLE); v1.setVisibility(View.VISIBLE);
                        sw1.setVisibility(View.VISIBLE); t1.setVisibility(View.VISIBLE);
                        tt1.setVisibility(View.VISIBLE); ta1.setVisibility(View.VISIBLE);
                        a1.setVisibility(View.VISIBLE); a1.setText(data.get(i).aud);
                        cl1 = data.get(i).classes; n1.setText(cl1);
                        n1.setVisibility(View.VISIBLE);
                        d1.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                    if (flag == 2) {
                        l11.setVisibility(View.VISIBLE); l12.setVisibility(View.VISIBLE);
                        a2.setText(data.get(i).aud); l13.setVisibility(View.VISIBLE);
                        cl2 = data.get(i).classes; n2.setText(cl2);
                        n2.setVisibility(View.VISIBLE);
                        d2.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                    if (flag == 3) {
                        l21.setVisibility(View.VISIBLE); l22.setVisibility(View.VISIBLE);
                        a3.setText(data.get(i).aud); l23.setVisibility(View.VISIBLE);
                        cl3 = data.get(i).classes; n3.setText(cl3);
                        n3.setVisibility(View.VISIBLE);
                        d3.setText(data.get(i).data_start + "-" + data.get(i).data_end);
                    }
                    if (flag == 4) {
                        l31.setVisibility(View.VISIBLE); l32.setVisibility(View.VISIBLE);
                        a4.setText(data.get(i).aud); l33.setVisibility(View.VISIBLE);
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
                case R.id.yn1:
                    if (sw1.isChecked()) s1 = "чн";
                    else s1 = "кн";
                    break;
                case R.id.yn2:
                    if (sw2.isChecked()) s2 = "чн";
                    else s2 = "кн";
                    break;
                case R.id.yn3:
                    if (sw3.isChecked()) s3 = "чн";
                    else s3 = "кн";
                    break;
                case R.id.yn4:
                    if (sw4.isChecked()) s4 = "чн";
                    else s4 = "кн";
                    break;
            }
        }
    };

    //ВСЕ ИСАПРВИТЬ НЕ РАБОТАЕТ , ТОЧНЕЕ ВСЕ ХУЕВО РАБОТАЕТ МНОГОКРАТНОЕ ПОСВТОРЕНИЕ

    public void check(){
        for( int i = 0; i < data.size(); i++){

        }
    }

    public void eddbtn( View v ) {
        if (v.getId() == R.id.btn_edd) {
            if (flag == 1 || flag == 0) {
                saveData(); fl = 1;
                l11.setVisibility(View.VISIBLE); l12.setVisibility(View.VISIBLE);
                l13.setVisibility(View.VISIBLE); v2.setVisibility(View.VISIBLE);
                sw2.setVisibility(View.VISIBLE);
                toastedMes("Данные сохранены");
                Update(); flag++;
                return;
            }
            if (flag == 2) {
                saveData(); fl = 1;
                l21.setVisibility(View.VISIBLE); l22.setVisibility(View.VISIBLE);
                l23.setVisibility(View.VISIBLE); v3.setVisibility(View.VISIBLE);
                sw3.setVisibility(View.VISIBLE);
                toastedMes("Данные сохранены");
                Update(); flag++;
                return;
            }
            if (flag == 3) {
                saveData(); fl = 1;
                l31.setVisibility(View.VISIBLE); l32.setVisibility(View.VISIBLE);
                l33.setVisibility(View.VISIBLE); v4.setVisibility(View.VISIBLE);
                sw4.setVisibility(View.VISIBLE);
                toastedMes("Данные сохранены");
                Update(); flag++;
                return;
            }
            if (flag == 4) {
                saveData(); fl = 1;
                toastedMes("Данные сохранены");
                Button btn = (Button) findViewById(R.id.btn_edd);
                Update();
                btn.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void toastedMes(String str){
        Toast tos = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        tos.show();
    }

    //int d = data.size();
    @Override
    public void onBackPressed() {
        if (fl == 0) saveData();
        finish();
    }

    public void changeData(int i, String d, String s, String a){
        String[] str = d.split("-");
        data.get(i).data_start = str[0];
        data.get(i).data_end = str[1];
        data.get(i).period = s;
        data.get(i).aud = a;
    }

    public void ListToString(){
        String mass = "";
        for (int i = 0; i < data.size(); i++){
            mass = String.format("%s%s,%s,%s,%s,%s,%s,%s\n", mass, data.get(i).day, data.get(i).classes,
                    data.get(i).data_start, data.get(i).data_end, data.get(i).period, data.get(i).num, data.get(i).aud);
        }
        try{
            File gpxfile = new File(getApplicationContext().getFilesDir(),"rasp.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(mass);
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void saveData(){
        int f1 = 0, f2 = 0 , f3 = 0, f4 = 0;
        for( int i = 0; i < data.size(); i++){
            if (data.get(i).classes.equals(cl1)) {
                if (!cl1.equals(n1.getText().toString()) && f1 == 0) {
                    if (n1.getText().toString().equals("")) {
                        data.remove(i);
                        i--;
                        continue;
                    } else {
                        data.get(i).classes = n1.getText().toString();
                        changeData(i, d1.getText().toString(), s1, a1.getText().toString());
                    }
                } else {
                    changeData(i, d1.getText().toString(), s1, a1.getText().toString());
                }
                f1++;
            }

            if (data.get(i).classes.equals(cl2)) {
                if (!cl2.equals(n2.getText().toString()) && f2 == 0) {
                    if (n2.getText().toString().equals("")) {
                        data.remove(i);
                        i--;
                        continue;
                    } else {
                        data.get(i).classes = n2.getText().toString();
                        changeData(i, d2.getText().toString(), s2, a2.getText().toString());
                    }
                } else {
                    changeData(i, d2.getText().toString(), s2, a2.getText().toString());
                }
                f2++;
            }

            if (data.get(i).classes.equals(cl3)) {
                if (!cl3.equals(n3.getText().toString()) && f3 == 0) {
                    if (n3.getText().toString().equals("")) {
                        data.remove(i);
                        i--;
                        continue;
                    } else {
                        data.get(i).classes = n3.getText().toString();
                        changeData(i, d4.getText().toString(), s3, a3.getText().toString());
                    }
                } else {
                    changeData(i, d3.getText().toString(), s3, a3.getText().toString());
                }
                f3++;
            }

            if (data.get(i).classes.equals(cl4)) {
                if (!cl4.equals(n4.getText().toString()) && f4 == 0) {
                    if (n4.getText().toString().equals("")) {
                        data.remove(i);
                        i--;
                        continue;
                    } else {
                        data.get(i).classes = n4.getText().toString();
                        changeData(i, d4.getText().toString(), s4, a4.getText().toString());
                    }
                } else {
                    changeData(i, d4.getText().toString(), s4, a4.getText().toString());
                }
                f4++;
            }

        }
        // если не нашлась запись в базе, то записывает новые
        if (f1 == 0) {
            if (!n1.getText().toString().equals("")) {
                String[] str = d1.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n1.getText().toString(), str[0], str[1], s1, ncl, a1.getText().toString());
                data.add(db);
            }
        }

        if (f2 == 0) {
            if (!n2.getText().toString().equals("")) {
                String[] str = d2.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n2.getText().toString(), str[0], str[1], s2, ncl, a2.getText().toString());
                data.add(db);
            }
        }

        if (f3 == 0) {
            if (!n3.getText().toString().equals("")) {
                String[] str = d3.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n3.getText().toString(), str[0], str[1], s3, ncl, a3.getText().toString());
                data.add(db);
            }
        }

        if (f4 == 0 ) {
            if (!n4.getText().toString().equals("")) {
                String[] str = d4.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n4.getText().toString(), str[0], str[1], s4, ncl, a4.getText().toString());
                data.add(db);
            }
        }
        // если массив вообще пустой
        if (data.size() == 0){
            if (!n1.getText().toString().equals("")) {
                String[] str = d1.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n1.getText().toString(), str[0], str[1], s1, ncl, a1.getText().toString());
                data.add(db);
            }
            if (!n2.getText().toString().equals("")) {
                String[] str = d2.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n2.getText().toString(), str[0], str[1], s2, ncl, a2.getText().toString());
                data.add(db);
            }
            if (!n3.getText().toString().equals("")) {
                String[] str = d3.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n3.getText().toString(), str[0], str[1], s3, ncl, a3.getText().toString());
                data.add(db);
            }
            if (!n4.getText().toString().equals("")) {
                String[] str = d4.getText().toString().split("-");
                DBHelp db = new DBHelp(dw, n4.getText().toString(), str[0], str[1], s4, ncl, a4.getText().toString());
                data.add(db);
            }
        }
        ListToString();
    }
}