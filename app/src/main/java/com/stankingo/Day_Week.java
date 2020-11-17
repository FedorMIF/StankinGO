package com.stankingo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;

import static com.stankingo.MainActivity.data;

public class Day_Week extends Activity {
    TextView pl1, pl2, pl3, pl4, pl5, pl6, pl7, pl8, pl9;
    String dww, mass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_week);
        dww = getIntent().getStringExtra("dw");

        Update();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Update();
        pl1.setClickable(true); pl2.setClickable(true);
        pl3.setClickable(true); pl4.setClickable(true);
        pl5.setClickable(true); pl6.setClickable(true);
        pl7.setClickable(true); pl8.setClickable(true);
    }

    public void Update(){
        String  one = " 8:30 - 10:10 |", tow = "10:20 - 12:00 |", three = "12:20 - 14:00 |",
                four = "14:10 - 15:40 |", five = "16:00 - 17:40 |", six = "18:00 - 19:30 |",
                seven = "19:40 - 21:10 |", eight = "21:20 - 22:50 |";
        for (int i = 0; i < data.size(); i++)
            if (data.get(i).day.equals(dww)) {
                if (data.get(i).num.equals("1"))
                    one = one + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("2"))
                    tow = tow + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("3"))
                    three = three + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("4"))
                    four = four + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("5"))
                    five = five + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("6"))
                    six = six + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("7"))
                    seven = seven + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
                if (data.get(i).num.equals("8"))
                    eight = eight + " " + data.get(i).classes + " (" + data.get(i).data_start + "-" +
                            data.get(i).data_end + ")." + data.get(i).period + ", " + data.get(i).aud + ", ";
            }

        pl1 = (TextView) findViewById(R.id.pole1); pl1.setText(one); pl1.setClickable(false);
        pl2 = (TextView) findViewById(R.id.pole2); pl2.setText(tow); pl2.setClickable(false);
        pl3 = (TextView) findViewById(R.id.pole3); pl3.setText(three); pl3.setClickable(false);
        pl4 = (TextView) findViewById(R.id.pole4); pl4.setText(four); pl4.setClickable(false);
        pl5 = (TextView) findViewById(R.id.pole5); pl5.setText(five); pl5.setClickable(false);
        pl6 = (TextView) findViewById(R.id.pole6); pl6.setText(six); pl6.setClickable(false);
        pl7 = (TextView) findViewById(R.id.pole7); pl7.setText(seven); pl7.setClickable(false);
        pl8 = (TextView) findViewById(R.id.pole8); pl8.setText(eight); pl8.setClickable(false);
        pl9 = (TextView) findViewById(R.id.pole9); pl9.setText(dww);
    }

    public void onClickBtnClass( View v ) {
        switch (v.getId()) {
            case R.id.pole1:
                Intent intent1 = new Intent(this, Day_red.class);
                intent1.putExtra("dcl", dww);
                intent1.putExtra("ncl", "1");
                startActivity(intent1);
                break;
            case R.id.pole2:
                Intent intent2 = new Intent(this, Day_red.class);
                intent2.putExtra("dcl", dww);
                intent2.putExtra("ncl", "2");
                startActivity(intent2);
                break;
            case R.id.pole3:
                Intent intent3 = new Intent(this, Day_red.class);
                intent3.putExtra("dcl", dww);
                intent3.putExtra("ncl", "3");
                startActivity(intent3);
                break;
            case R.id.pole4:
                Intent intent4 = new Intent(this, Day_red.class);
                intent4.putExtra("dcl", dww);
                intent4.putExtra("ncl", "4");
                startActivity(intent4);
                break;
            case R.id.pole5:
                Intent intent5 = new Intent(this, Day_red.class);
                intent5.putExtra("dcl", dww);
                intent5.putExtra("ncl", "5");
                startActivity(intent5);
                break;
            case R.id.pole6:
                Intent intent6 = new Intent(this, Day_red.class);
                intent6.putExtra("dcl", dww);
                intent6.putExtra("ncl", "6");
                startActivity(intent6);
                break;
            case R.id.pole7:
                Intent intent7 = new Intent(this, Day_red.class);
                intent7.putExtra("dcl", dww);
                intent7.putExtra("ncl", "7");
                startActivity(intent7);
                break;
            case R.id.pole8:
                Intent intent8 = new Intent(this, Day_red.class);
                intent8.putExtra("dcl", dww);
                intent8.putExtra("ncl", "8");
                startActivity(intent8);
                break;
            default:
                break;
        }
    }

    int flag = 0;

    public void onClickBtnRed( View v ) {
        Button r = (Button) findViewById(R.id.red);
        if (v.getId() == R.id.red) {
            if (flag == 0) {
                pl1.setClickable(true); pl2.setClickable(true);
                pl3.setClickable(true); pl4.setClickable(true);
                pl5.setClickable(true); pl6.setClickable(true);
                pl7.setClickable(true); pl8.setClickable(true);
                pl1.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl2.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl3.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl4.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl5.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl6.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl7.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                pl8.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                flag = 1; r.setText(R.string.save);
                return;
            }
            if (flag == 1) {
                pl1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl4.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl5.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl6.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl7.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                pl8.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                flag = 0; r.setText(R.string.red);
                Update();
                ListToString();
            }
        }
        if (v.getId() == R.id.dell){

            new AlertDialog.Builder(this).setTitle("Вы не ошиблись?")
                    .setMessage("Вы действительно хотите удалить все расписание этого дня?")
                    .setPositiveButton("ДA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            for (int ii = 0; ii < data.size(); ii++)
                                if (data.get(ii).day.equals(dww)){
                                    data.remove(ii); ii--;
                                }
                            Update();
                            ListToString();
                        }
                    })
                    .setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }
    }

    public void ListToString(){
        mass = "";
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

    @Override
    public void onBackPressed() {
        ListToString();
        finish();
    }
}