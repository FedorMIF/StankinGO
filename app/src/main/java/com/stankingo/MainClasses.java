package com.stankingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static com.stankingo.MainActivity.data;

public class MainClasses extends Activity {
    TextView pl1, pl2, pl3, pl4, pl5, pl6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        Update();

        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Update();
    }

    public void Update(){
        String mon = "ПН |", tue = "ВТ |", wed = "СР |", thur = "ЧТ |", fri = "ПТ |", sut = "СБ |";

        for (int i = 0; i < data.size(); i++){
            if (data.get(i).day.equals("Понедельник")) mon = mon + " " + data.get(i).num + ": " + data.get(i).classes;
            else if (data.get(i).day.equals("Вторник")) tue = tue + " " + data.get(i).num + ": " + data.get(i).classes;
            else if (data.get(i).day.equals("Среда")) wed = wed + " " + data.get(i).num + ": " + data.get(i).classes;
            else if (data.get(i).day.equals("Четверг")) thur = thur + " " + data.get(i).num + ": " + data.get(i).classes;
            else if (data.get(i).day.equals("Пятница")) fri = fri + " " + data.get(i).num + ": " + data.get(i).classes;
            else if (data.get(i).day.equals("Суббота")) sut = sut + " " + data.get(i).num + ": " + data.get(i).classes;
        }


        pl1 = (TextView) findViewById(R.id.pole1); pl1.setText(mon);
        pl2 = (TextView) findViewById(R.id.pole2); pl2.setText(tue);
        pl3 = (TextView) findViewById(R.id.pole3); pl3.setText(wed);
        pl4 = (TextView) findViewById(R.id.pole4); pl4.setText(thur);
        pl5 = (TextView) findViewById(R.id.pole5); pl5.setText(fri);
        pl6 = (TextView) findViewById(R.id.pole6); pl6.setText(sut);
    }

    public void onClickWeek( View v ) {
        switch (v.getId()) {
            case R.id.pole1:
                Intent intent1 = new Intent(this, Day_Week.class);
                intent1.putExtra("dw", "Понедельник");
                startActivity(intent1);
                break;
            case R.id.pole2:
                Intent intent2 = new Intent(this, Day_Week.class);
                intent2.putExtra("dw", "Вторник");
                startActivity(intent2);
                break;
            case R.id.pole3:
                Intent intent3 = new Intent(this, Day_Week.class);
                intent3.putExtra("dw", "Среда");
                startActivity(intent3);
                break;
            case R.id.pole4:
                Intent intent4 = new Intent(this, Day_Week.class);
                intent4.putExtra("dw", "Четверг");
                break;
            case R.id.pole5:
                Intent intent5 = new Intent(this, Day_Week.class);
                intent5.putExtra("dw", "Пятница");
                startActivity(intent5);
                break;
            case R.id.pole6:
                Intent intent6 = new Intent(this, Day_Week.class);
                intent6.putExtra("dw", "Суббота");
                startActivity(intent6);
                break;
            default:
                break;
        }
    }


}
