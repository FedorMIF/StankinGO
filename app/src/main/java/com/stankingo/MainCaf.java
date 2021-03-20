package com.stankingo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCaf extends AppCompatActivity {

    Button Back;
    String data[] = {"Выход","Ректорат","Кафе","Кафедра станков", "Кафедра философии", "Кафедра теоретической механики и сопротивления материалов",  "Кафедра технологии машиностроения", "Кафедра экономики и управления предприятием",
            "Кафедра инженерной экологии и безопасности жизнедеятельности", "Клуб", "Спортзал",
            "Кафедра электротехники, электроники и автоматики", "Профком", "Кафедра композиционных материалов",
            "Кафедра информационных технологий и вычислительных систем", "Кафедра инструментальной техники и технологии формообразования",
            "Кафедра высокоэффективных технологий обработки", "Деканат", "Кафедра математики"};

    String num[] = {"exit","rektor","kafe","501", "507", "450a", "416", "339", "320", "327", "328", "346", "204", "203", "217", "243", "222", "233", "357a"};

    String start_cabinet, end_cabinet, start_build, end_build;
    char start_level, end_level;
    int pos, i;
    ArrayList<String> way_list = new ArrayList<>(15);
    ArrayList<String> way_text = new ArrayList<>(15);
    List<String> oldau = new ArrayList<>();
    List<String> oldoldau = new ArrayList<>();
    List<String> newau = new ArrayList<>();
    List<String> perau = new ArrayList<>();
    List<String> oldcafau = new ArrayList<>();
    TextView editrstst1;
    Button next2, prev2;
    ImageView way2;
    TextView waytxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_caf);

        way2 = (ImageView) findViewById(R.id.way_view2);
        next2 = (Button) findViewById(R.id.next_step2);
        prev2 = (Button) findViewById(R.id.prev_step2);
        waytxt2 = (TextView) findViewById(R.id.helptext2);

        way2.setVisibility(View.INVISIBLE);
        next2.setVisibility(View.INVISIBLE);
        prev2.setVisibility(View.INVISIBLE);

        oldau.addAll(Arrays.asList(MainAudi.arr));
        oldoldau.addAll(Arrays.asList(MainAudi.oldoldaud));
        newau.addAll(Arrays.asList(MainAudi.newaud));
        perau.addAll(Arrays.asList(MainAudi.per));
        oldcafau.addAll(Arrays.asList(MainAudi.oldcaf));

        getSupportActionBar().hide();
//        ActionBar actionBar =getSupportActionBar();
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_caf);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Выберете кафедру");
        spinner.setSelection(0);

        OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


        editrstst1 = (EditText) findViewById(R.id.strtAudi2);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                way_list.clear();
                way_text.clear();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(button.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                if (editrstst1.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainCaf.this);
                    builder.setTitle("Не верное значение")
                            .setMessage("Введите номер кабинета состоящий из цифр и буквы")
                            .setCancelable(false)
                            .setNegativeButton("ОК, сейчас исправлю", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                else {
                    start_cabinet = MainAudi.toEnglish(editrstst1.getText().toString());
                    end_cabinet = num[pos];
                    if ( perau.contains(start_cabinet) ||oldau.contains(start_cabinet) || oldoldau.contains(start_cabinet) || newau.contains(start_cabinet) ||
                            start_cabinet.equals("entry") || start_cabinet.equals("kafe") || start_cabinet.equals("rektor") ) {

                        if (newau.contains(start_cabinet)) { start_build = "new"; start_level = start_cabinet.charAt(1);
                            if (newau.contains(end_cabinet)){ end_build = "new"; end_level = end_cabinet.charAt(1);}
                            else if (oldau.contains(end_cabinet)) {end_build ="old"; end_level = end_cabinet.charAt(0);}
                            else if (oldoldau.contains(end_cabinet)) {end_build = "oldold"; end_level = end_cabinet.charAt(0);}
                            else if (perau.contains(end_cabinet)) {end_build = "pereh"; end_level = end_cabinet.charAt(0);}
                            else if (oldcafau.contains(end_cabinet)) {end_build = "oldcaf"; end_level = end_cabinet.charAt(0);}
                        }
                        else if (oldau.contains(start_cabinet)) {start_build ="old"; start_level = start_cabinet.charAt(0);
                            if (newau.contains(end_cabinet)) {end_build ="new"; end_level = end_cabinet.charAt(1);}
                            else if (oldau.contains(end_cabinet)) {end_build ="old"; end_level = end_cabinet.charAt(0);}
                            else if (oldoldau.contains(end_cabinet)) {end_build = "oldold"; end_level = end_cabinet.charAt(0);}
                            else if (perau.contains(end_cabinet)) {end_build = "pereh"; end_level = end_cabinet.charAt(0);}
                            else if (oldcafau.contains(end_cabinet)) {end_build = "oldcaf"; end_level = end_cabinet.charAt(0);}
                        }
                        else if (oldoldau.contains(start_cabinet)) {start_build = "oldold"; start_level = start_cabinet.charAt(0);
                            if (oldau.contains(end_cabinet)) {end_build ="old"; end_level = end_cabinet.charAt(0);}
                            else if (oldoldau.contains(end_cabinet)) {end_build = "oldold"; end_level = end_cabinet.charAt(0);}
                            else if (newau.contains(end_cabinet)) {end_build = "new"; end_level = end_cabinet.charAt(1);}
                            else if (perau.contains(end_cabinet)) {end_build = "pereh"; end_level = end_cabinet.charAt(0);}
                            else if (oldcafau.contains(end_cabinet)) {end_build = "oldcaf"; end_level = end_cabinet.charAt(0);}
                        }
                        else if (perau.contains(start_cabinet)) {start_build = "pereh"; start_level = start_cabinet.charAt(0);
                            if (oldau.contains(end_cabinet)) {end_build ="old"; end_level = end_cabinet.charAt(0);}
                            else if (newau.contains(end_cabinet)) {end_build = "new"; end_level = end_cabinet.charAt(0);}
                            else if (oldoldau.contains(end_cabinet)) {end_build = "oldold"; end_level = end_cabinet.charAt(0);}
                            else if (perau.contains(end_cabinet)) {end_build = "pereh"; end_level = end_cabinet.charAt(0);}
                            else if (oldcafau.contains(end_cabinet)) {end_build = "oldcaf"; end_level = end_cabinet.charAt(0);}
                        }
                        else if (oldcafau.contains(start_cabinet)) { start_build = "oldcaf"; start_level = start_cabinet.charAt(0);
                            if (oldcafau.contains(end_cabinet)) {end_cabinet = "oldcaf"; end_level = end_cabinet.charAt(0);}
                            else if (newau.contains(end_cabinet)){ end_build = "new"; end_level = end_cabinet.charAt(1);}
                            else if (oldau.contains(end_cabinet)) {end_build ="old"; end_level = end_cabinet.charAt(0);}
                            else if (oldoldau.contains(end_cabinet)) {end_build = "oldold"; end_level = end_cabinet.charAt(0);}
                            else if (perau.contains(end_cabinet)) {end_build = "pereh"; end_level = end_cabinet.charAt(0);}
                        }

                        // иключения
                        if (start_cabinet.equals("entry")) {start_level = '1';}
                        if (end_cabinet.equals("exit")) {end_level = '1';}
                        if (start_cabinet.equals("kafe")) {start_level = '3';}
                        if (end_cabinet.equals("kafe")) {end_level = '3';}
                        if (start_cabinet.equals("rektor")) {start_level = '5';}
                        if (end_cabinet.equals("rektor")) {end_level = '5';}
                        if (start_cabinet.equals("entrynew")) {start_level = '1';}
                        if (end_cabinet.equals("exitnew")){end_level = '1';}

                        //собирание пути
                        if (start_build == end_build){
                            way_list.add("au"+start_cabinet);
                            way_text.add("Вы тут");
                            if (start_level == end_level){
                                way_list.add("au"+end_cabinet);
                                way_text.add("Вам сюда");
                            }else {
                                way_list.add("upstairs" + start_level + start_build);
                                way_text.add("Дойдите до лестницы или лифта перейдите на " + end_level + "й этаж");
                                way_list.add("downstairs" + end_level + end_build);
                                way_text.add("Вы на " + end_level + "м этаже");
                                way_list.add("au" + end_cabinet);
                                way_text.add("Вам сюда");
                            }
                        }else {
                            if (start_build.equals("new")) {
                                way_list.add("au"+start_cabinet);
                                way_text.add("Вы тут");
                                if (end_build.equals("old") || end_build.equals("oldold") || end_build.equals("oldcaf")) {
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы или лифта перейдите на 2й этаж");

                                        way_list.add("downstairs2new");
                                        way_text.add("Вы на 2м этаже");
                                    }
                                    way_list.add("newtopereh");// этаж перехода из нового в переход
                                    way_text.add("Перейдите по коридору в переход между новым и старым корпусом");

                                    way_list.add("newtoperehhere");// точка отправки после перехода
                                    way_text.add("Вы в переходе");

                                    way_list.add("perehtoold"); // найти файл перехода из перехода в страый
                                    way_text.add("Перейдите по леснице в старый корпус");

                                    way_list.add("perehtooldhere");
                                    way_text.add("Вы в первом крыле старого корпуса");

                                    if (end_build.equals("old")) {
                                        if (end_level != '1') {
                                            way_list.add("upstairs1old");
                                            way_text.add("Дойдите до лестницы и перейдите на "
                                                    + end_level + "й этаж");
                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }
                                    } else if (end_build.equals("oldold")) {
                                        way_list.add("upstairs1old");
                                        way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                        way_list.add("downstairs2old");
                                        way_text.add("Вы на 2м этаже");

                                        way_list.add("oldtooldold");// переход из старого в совсем старый
                                        way_text.add("Перейдите по коридору в другое крыло старого корпуса");

                                        way_list.add("oldtooldoldhere");// точка отправки после перехода
                                        way_text.add("Вы во втором крыле старого корпуса");

                                        if (end_level != '2') {
                                            way_list.add("upstairs2oldold");
                                            way_text.add("Дойдите до лестницы и перейдите на "
                                                    + end_level + "й этаж");

                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }
                                    } else if (end_build.equals("oldcaf")){
                                        way_list.add("upstairs1old");
                                        way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                        way_list.add("downstairs2old");
                                        way_text.add("Вы на 2м этаже");

                                        way_list.add("upstairs2old");
                                        way_text.add("Поднимитесь на межэтажный уровень");

                                        way_list.add("oldtooldcafhere");
                                        way_text.add("Вы находитесь на этаже кафедры математики");
                                    }
                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                }
                                else if (end_cabinet.equals("pereh")){
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы или лифта перейдите на 2й этаж");

                                        way_list.add("downstairs2new");
                                        way_text.add("Вы на 2м этаже");
                                    }
                                    way_list.add("newtopereh");// этаж перехода из нового в переход
                                    way_text.add("Перейдите по коридору в переход между новым и страым корпусом");

                                    way_list.add("newtoperehhere");// точка отправки после перехода
                                    way_text.add("Вы в переходе");

                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                }
                            }
                            if (start_build.equals("old")) {
                                way_list.add("au"+start_cabinet);
                                way_text.add("Вы тут");

                                if (end_build.equals("oldold")) {
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                        way_list.add("downstairs2old");
                                        way_text.add("Вы на 2м этаже");
                                    }
                                    way_list.add("oldtooldold");// переход из старого в совсем старый
                                    way_text.add("Перейдите по коридору в другое крыло старого корпуса");

                                    way_list.add("oldtooldoldhere");// точка отправки после перехода
                                    way_text.add("Вы во втором крыле старого корпуса");

                                    if (end_level != '2') {
                                        way_list.add("upstairs2oldold");
                                        way_text.add("Дойдите до лестницы и перейдите на "
                                                + end_level + "й этаж");

                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }
                                }
                                else if (end_build.equals("new") || end_build.equals("pereh")) {
                                    if (start_level != '1') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы и перейдите на 1й этаж");

                                        way_list.add("downstairs1old");
                                        way_text.add("Вы на 1м этаже");
                                    }
                                    way_list.add("oldtopereh");// переход из старого в новый
                                    way_text.add("Перейдите по коридору в переход между \n старым и новым корпусом");

                                    way_list.add("oldtoperehhere");// найти нужный файл
                                    way_text.add("Вы в переходе");

                                    if (end_build.equals("new")) {
                                        way_list.add("perehtonew");
                                        way_text.add("Перейдите по коридору в новый корпус");

                                        way_list.add("perehtonewhere");
                                        way_text.add("Вы в новом корпусе");

                                        if (end_level != '2') {
                                            way_list.add("upstairs2new");
                                            way_text.add("Дойдите до лестницы или лифта и перейдите на "
                                                    + end_level + "й этаж");

                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }
                                    }
                                }
                                else if (end_build.equals("oldcaf")){

                                    if (start_level != '2') {

                                        way_list.add("upstairs"+start_level+start_build);
                                        way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                        way_list.add("downstairs2old");
                                        way_text.add("Вы на 2м этаже");
                                    }

                                    way_list.add("upstairs2old");
                                    way_text.add("Поднимитесь на межэтажный уровень");

                                    way_list.add("oldtooldcafhere");
                                    way_text.add("Вы находитесь на этаже кафедры математики");
                                }

                                way_list.add("au" + end_cabinet);
                                way_text.add("Вам сюда");
                            }
                            if (start_build.equals("oldold")) {
                                way_list.add("au"+start_cabinet);
                                way_text.add("Вы тут");
                                if (end_build.equals("old") || end_build.equals("oldcaf")) {
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы и перейдите на 2й этаж");

                                        way_list.add("downstairs2oldold");
                                        way_text.add("Вы на 2м этаже");
                                    }

                                    way_list.add("oldoldtoold");
                                    way_text.add("Перейдите по коридору в другое крыло старого корпуса");

                                    way_list.add("oldoldtooldhere");
                                    way_text.add("Вы в первом крыле старого корпуса");

                                    if (end_level != '2') {

                                        if (end_build.equals("oldcaf")){
                                            way_list.add("upstairs1old");
                                            way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                            way_list.add("downstairs2old");
                                            way_text.add("Вы на 2м этаже");

                                            way_list.add("upstairs2old");
                                            way_text.add("Поднимитесь на межэтажный уровень");

                                            way_list.add("oldtooldcafhere");
                                            way_text.add("Вы находитесь на этаже кафедры математики");
                                        }else {
                                            way_list.add("upstairs2old");
                                            way_text.add("Дойдите до лестницы и перейдите на "
                                                    + end_level + "й этаж");

                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }
                                    }


                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                }
                                else if (end_build.equals("new") || end_build.equals("pereh")) {
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы и перейдите на 2й этаж");

                                        way_list.add("downstairs2oldold");
                                        way_text.add("Вы на 2м этаже");
                                    }
                                    way_list.add("oldoldtoold");// этаж перехода из совсем старого в старый
                                    way_text.add("Перейдите по коридору в другое крыло старого корпуса");

                                    way_list.add("oldoldtooldhere");// точка отправки после перехода
                                    way_text.add("Вы в первом крыле старого корпуса");

                                    way_list.add("upstairs2old");// лесница на 1 этаж старого
                                    way_text.add("Дойдите до лестницы и спуститесь на 1й этаж");

                                    way_list.add("downstairs1old"); // лестница первого эtажа старого
                                    way_text.add("Вы на 1м этаже");

                                    way_list.add("oldtopereh");// переход из старого в новый
                                    way_text.add("Перейдите по коридору в переход между \n старым и новым корпусом");

                                    way_list.add("oldtoperehhere");// найти нужный файл
                                    way_text.add("Вы в переходе");

                                    if (end_build.equals("new")) {
                                        way_list.add("perehtonew");
                                        way_text.add("Перейдите по коридору в новый корпус");

                                        way_list.add("perehtonewhere");
                                        way_text.add("Вы в новом корпусе");

                                        if (end_level != '2') {
                                            way_list.add("upstairs2new");
                                            way_text.add("Дойдите до лестницы или лифта и перейдите на "
                                                    + end_level + "й этаж");

                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }
                                    }

                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                }
                            }
                            if (start_build.equals("pereh")) {
                                way_list.add("au"+start_cabinet);
                                way_text.add("Вы тут");
                                if (end_build.equals("old") || end_build.equals("oldold") || end_build.equals("oldcaf")) {

                                    way_list.add("perehtoold"); // найти файл перехода из перехода в страый
                                    way_text.add("Перейдите по леснице в старый корпус");

                                    way_list.add("perehtooldhere");
                                    way_text.add("Вы в первом крыле старого корпуса");

                                    if (end_build.equals("oldold")){

                                        way_list.add("upstairs1old");
                                        way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                        way_list.add("downstairs2old");
                                        way_text.add("Вы на 2м этаже");

                                        way_list.add("oldtooldold");// переход из старого в совсем старый
                                        way_text.add("Перейдите по коридору в другое крыло старого корпуса");

                                        way_list.add("oldtooldoldhere");// точка отправки после перехода
                                        way_text.add("Вы во втором крыле старого корпуса");

                                        if (end_level != '2') {
                                            way_list.add("upstairs2oldold");
                                            way_text.add("Дойдите до лестницы и перейдите на "
                                                    + end_level + "й этаж");

                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }

                                    } else {
                                        if (end_level != '1') {

                                            if (end_build.equals("oldcaf")){
                                                way_list.add("upstairs1old");
                                                way_text.add("Дойдите до лестницы перейдите на 2й этаж");

                                                way_list.add("downstairs2old");
                                                way_text.add("Вы на 2м этаже");

                                                way_list.add("upstairs2old");
                                                way_text.add("Поднимитесь на межэтажный уровень");

                                                way_list.add("oldtooldcafhere");
                                                way_text.add("Вы находитесь на этаже кафедры математики");
                                            } else {
                                                way_list.add("upstairs1old");
                                                way_text.add("Дойдите до лестницы и перейдите на "
                                                        + end_level + "й этаж");

                                                way_list.add("downstairs" + end_level + end_build);
                                                way_text.add("Вы на " + end_level + "м этаже");
                                            }
                                        }
                                    }

                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");

                                }
                                else if (end_build.equals("new")){
                                    way_list.add("perehtonew");
                                    way_text.add("Перейдите по коридору в новый корпус");

                                    way_list.add("perehtonewhere");
                                    way_text.add("Вы в новом корпусе");

                                    if (end_level != '2') {
                                        way_list.add("upstairs2new");
                                        way_text.add("Дойдите до лестницы или лифта и перейдите на "
                                                + end_level + "й этаж");

                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }
                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");

                                }
                            }
                            if (start_build.equals("oldcaf")){
                                way_list.add("au"+start_cabinet);
                                way_text.add("Вы тут");

                                way_list.add("oldcaftoold");
                                way_text.add("Подойдите к выходу из помещений кафедры математики");

                                way_list.add("downstairs2old");
                                way_text.add("Вы на 2м этаже старого корпуса");

                                if (end_build.equals("oldold")) {

                                    way_list.add("oldtooldold");// переход из старого в совсем старый
                                    way_text.add("Перейдите по коридору в другое крыло старого корпуса");

                                    way_list.add("oldtooldoldhere");// точка отправки после перехода
                                    way_text.add("Вы во втором крыле старого корпуса");

                                    if (end_level != '2') {
                                        way_list.add("upstairs2oldold");
                                        way_text.add("Дойдите до лестницы и перейдите на "
                                                + end_level + "й этаж");

                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }
                                }
                                else if (end_build.equals("new") || end_build.equals("pereh")) {

                                    way_list.add("oldtopereh");// переход из старого в новый
                                    way_text.add("Перейдите по коридору в переход между \n старым и новым корпусом");

                                    way_list.add("oldtoperehhere");// найти нужный файл
                                    way_text.add("Вы в переходе");

                                    if (end_build.equals("new")) {
                                        way_list.add("perehtonew");
                                        way_text.add("Перейдите по коридору в новый корпус");

                                        way_list.add("perehtonewhere");
                                        way_text.add("Вы в новом корпусе");

                                        if (end_level != '2') {
                                            way_list.add("upstairs2new");
                                            way_text.add("Дойдите до лестницы или лифта и перейдите на "
                                                    + end_level + "й этаж");

                                            way_list.add("downstairs" + end_level + end_build);
                                            way_text.add("Вы на " + end_level + "м этаже");
                                        }
                                    }
                                }
                                else if (end_build.equals("old")){
                                    if (end_level != '2' ){
                                        way_list.add("upstairs1old");
                                        way_text.add("Дойдите до лестницы и перейдите на "
                                                + end_level + "й этаж");
                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }
                                }
                                way_list.add("au" + end_cabinet);
                                way_text.add("Вам сюда");
                            }
                        }

                        way2.setVisibility(View.VISIBLE);
                        next2.setVisibility(View.VISIBLE);
                        prev2.setVisibility(View.VISIBLE);

                        way2.setImageResource(getResources().getIdentifier(way_list.get(i),"drawable", getPackageName()));
                        waytxt2.setText(way_text.get(i));
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainCaf.this);
                        builder.setTitle("Что-то не так (︶︹︺) ")
                                .setMessage("Проверьте правильность ввода:\n" +
                                        "1.Номер обязан содержать только цифры и не более 5ти символов\n" + "\n" +
                                        "2.Если Вы стоите у входа введите в первое поле Вход или вход с указанием корпуса\n" + "\n" +
                                        "3.Если Вам надо к выходу то введите во второе поле Выход или выход с указанием корпуса\n" + "\n" +
                                        "4.Если Вам надо в кафе или Вы стоите около кафе, то в поля можно вписать Кафе или кафе\n" + "\n" +
                                        "5.Если Вам надо в ректорат или Вы стоите около ректората, то в поля можно вписать Ректорат или ректорат\n" + "\n" +
                                        "6.Такого кабинет нет ¯\\_(ツ)_/¯")
                                .setCancelable(false)
                                .setNegativeButton("ОК, сейчас исправлю", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) { dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
            }

        });
    }

    public void onClickWayBtn2( View v ) {
        switch (v.getId()) {
            case R.id.next_step2:
                if (i < (way_list.size()-1))
                    i++;
                way2.setImageResource(getResources().getIdentifier(way_list.get(i),"drawable", getPackageName()));
                waytxt2.setText(way_text.get(i));
                break;
            case R.id.prev_step2:
                if (i!=0)
                    i--;
                way2.setImageResource(getResources().getIdentifier(way_list.get(i),"drawable", getPackageName()));
                waytxt2.setText(way_text.get(i));
                break;
            default:
                break;
        }
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
