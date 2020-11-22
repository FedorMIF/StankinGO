package com.stankingo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainAudi extends AppCompatActivity {

    String start_cabinet, end_cabinet, start_build, end_build;
    char start_level, end_level;
    int i;
    static String arr[] = {"510", "509", "508", "511", "506", "507", "505", "504", "503", "502", "501",
                    "447", "448", "446", "445", "443", "444", "445", "441", "440", "439", "449", "450", "450a", "450б", "450в",
                    "327", "322", "323", "324", "325", "326", "333", "332", "331", "320", "328",
                    "233", "225", "224", "223", "222", "235", "234", "236", "237", "238", "239", "221", "220", "219", "218"};

    static String newaud[] = {"0201", "0202", "0203", "0206", "0207", "0208", "0209", "0210", "0211",
                    "0303", "0304", "0305", "0306", "0307", "0308", "0309", "0310", "0311", "0312a",
                    "0402", "0403", "0404", "0405", "0406", "0407", "0408", "0409", "0410", "0411",
                    "0505", "0506", "0507", "0508", "0511", "0510", "0513", "0514", "0515", "0516", "0517",
                    "0603", "0604", "0610", "0606", "0607", "0608", "0609", "0611", "0612", "0613", "0614",
                    "0615", "0617", "0618", "0619", "0620", "0621", "0622", "0623", "0732",
                    "0801", "0802", "0803", "0804", "0806", "0807", "0809", "0810", "0811", "0812",
                    "0903", "0904", "0905", "0906", "0907", "0908", "0909", "0910", "0911", "0913", "0918",
                    "0919", "0921", "0922", "0923", "0924"};

    static String oldoldaud[] = {"201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212",
                    "213", "214", "215", "216", "217", "240a", "240b", "240c", "240d", "240e", "240f", "240g",
                    "241", "242", "243", "244", "246", "247", "249", "249b", "249c", "250", "251", "254", "255", "256", "257",
                    "301", "302", "303", "304", "305", "306", "306a", "307", "308", "309", "310",
                    "311", "312", "313", "314", "314a", "339", "340", "341", "342", "343", "346", "349",
                    "419", "417", "416", "415", "414", "413", "412", "411", "409", "408", "406", "405", "404", "403", "401"};

    ArrayList<String> way_list = new ArrayList<>(10);
    ArrayList<String> way_text = new ArrayList<>(10);
    static List<String> oldau = new ArrayList<>();
    static List<String> oldoldau = new ArrayList<>();
    static List<String> newau = new ArrayList<>();
    EditText editrstst1;
    EditText editrstst2;
    Button next, prev;
    ImageView way;
    TextView waytxt;
    int flag = 1;

    public static String toEnglish(String src) {
        String res = src;
        String f[] = {"а", "б", "в", "г", "д", "е", "ж"};
        String t[] = {"a", "b", "c", "d", "e", "f", "g"};
        if (src.equals("Вход") || src.equals("вход") || src.equals("Выход") || src.equals("выход")) {
            if (src.equals("Вход") || src.equals("вход")) res = "entry";
            if (src.equals("Выход") || src.equals("выход")) res = "exit";
        } else if( src.equals("кафе") || src.equals("Кафе") ) { res = "kafe";
        } else if( src.equals("Ректорат") || src.equals("ректорат") ||
                src.equals("Ректор") || src.equals("ректор") ) { res = "rekror";
        }else {
            for (int i = 0; i < 7; ++i)
                if (src.contains(f[i]))
                    res = src.replace(f[i], t[i]);
        }
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_audi);
        getSupportActionBar().hide();
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(false);

        oldau.addAll(Arrays.asList(arr));
        oldoldau.addAll(Arrays.asList(MainAudi.oldoldaud));
        newau.addAll(Arrays.asList(MainAudi.newaud));

        editrstst1 = (EditText) findViewById(R.id.strtAudi);
        editrstst2 = (EditText) findViewById(R.id.endAudi);
        waytxt = (TextView) findViewById(R.id.helptext);
        way = (ImageView) findViewById(R.id.way_view);
        next = (Button) findViewById(R.id.next_step);
        prev = (Button) findViewById(R.id.prev_step);

        way.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        prev.setVisibility(View.INVISIBLE);

        final Button button1 = (Button) findViewById(R.id.get_way);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
                way_list.clear();
                way_text.clear();
                if (editrstst1.getText().toString().equals("")||editrstst2.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainAudi.this);
                    builder.setTitle("Что-то не так")
                            .setMessage("Введите номер кабинета состоящий из цифр и буквы")
                            .setCancelable(false)
                            .setNegativeButton("ОК, сейчас исправлю", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    flag = 0;
                }
                else {
                    start_cabinet = toEnglish(editrstst1.getText().toString());
                    end_cabinet = toEnglish(editrstst2.getText().toString());
                    if (oldau.equals(start_cabinet) || oldoldau.equals(start_cabinet) || newau.equals(start_cabinet) ||
                            oldau.equals(end_cabinet) || oldoldau.equals(end_cabinet) || newau.equals(end_cabinet) ||
                            start_cabinet.equals("entry") || start_cabinet.equals("kafe") || start_cabinet.equals("rektor") ||
                            end_cabinet.equals("exit") || end_cabinet.equals("kafe") || end_cabinet.equals("rektor")) {
                        if (start_cabinet.charAt(0) == '0') {
                            start_build = "new";
                            start_level = start_cabinet.charAt(1);
                            if (end_cabinet.charAt(0) == '0'){
                                //test.setText("Вы на " + start_cabinet.charAt(1) + "м этаже нового корпуса" + " Вам надо на " + end_cabinet.charAt(1) + "й этаж нового корпуса");
                                end_build = "new";
                                end_level = end_cabinet.charAt(1);}
                            else{
                                //test.setText("Вы на " + start_cabinet.charAt(1) + "м этаже нового корпуса" + " Вам надо на " + end_cabinet.charAt(0) + "й этаж старого корпуса");
                                if (oldau.contains(end_cabinet)) end_build ="old";
                                else end_build = "oldold";
                                end_level = end_cabinet.charAt(0);}
                        } else {
                            if (oldau.contains(start_cabinet)) start_build ="old";
                            else start_build = "oldold";
                            start_level = start_cabinet.charAt(0);
                            if (end_cabinet.charAt(0) == '0'){
                                //test.setText("Вы на " + start_cabinet.charAt(0) + "м этаже старого корпуса" + " Вам надо на " + end_cabinet.charAt(1) + "й этаж нового курпуса");
                                end_build = "new";
                                end_level = end_cabinet.charAt(1);}
                            else{
                                //test.setText("Вы на " + start_cabinet.charAt(0) + "м этаже старого корпуса" + " Вам надо на " + end_cabinet.charAt(0) + "й этаж старого корпуса");
                                if (oldau.contains(end_cabinet)) end_build ="old";
                                else end_build = "oldold";
                                end_level = end_cabinet.charAt(0);}
                        }

                        //исключения
                        if (start_cabinet.equals("entry")) {start_level = '1'; start_build = "old";}
                        if (end_cabinet.equals("exit")) {end_level = '1'; end_build = "old";}
                        if (start_cabinet.equals("kafe")) {start_level = '3'; start_build = "new";}
                        if (end_cabinet.equals("kafe")) {end_level = '3'; end_build = "new";}
                        if (start_cabinet.equals("rektor")) {start_level = '5'; start_build = "new";}
                        if (end_cabinet.equals("rektor")) {end_level = '5'; end_build = "new";}

                        //собирание пути
                        if (start_build.equals(end_build)){
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
                                if (end_build.equals("old")) {
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы или лифта перейдите на 2й этаж");

                                        way_list.add("downstairs2new");
                                        way_text.add("Вы на 2м этаже");
                                    }
                                    way_list.add("newtoold");
                                    way_text.add("Перейдите по коридору в страрый корпус");

                                    if (end_level != '1') {
                                        way_list.add("upstairs1old");
                                        way_text.add("Дойдите до лестницы и перейдите на "
                                                + end_level + "й этаж");

                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }

                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                } else {
                                    if (start_level != '2') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы или лифта перейдите на 2й этаж");

                                        way_list.add("downstairs2new");
                                        way_text.add("Вы на 2м этаже");
                                    }
                                    way_list.add("newtoold");// этаж перехода из нового в старый
                                    way_text.add("Перейдите по коридору в старый корпус");

                                    way_list.add("upstairs1old");// лесница на 2 этаж старого
                                    way_text.add("Дойдите до лестницы и перейдите на 2й этаж");

                                    way_list.add("downstairs2old"); // лестница второго эажа старого
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

                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                } else {
                                    if (start_level != '1') {
                                        way_list.add("upstairs" + start_level + start_build);
                                        way_text.add("Дойдите до лестницы и перейдите на 1й этаж");

                                        way_list.add("downstairs1old");
                                        way_text.add("Вы на 1м этаже");
                                    }
                                    way_list.add("oldtonew");// переход из старого в новый
                                    way_text.add("Перейдите из старого в новый корпус");
                                    way_list.add("oldtonewhere");// точка отправки после перехода
                                    way_text.add("Вы в старом корпусе");

                                    if (end_level != '2') {
                                        way_list.add("upstairs2new");
                                        way_text.add("Дойдите до лестницы или лифта перейдите на "
                                                + end_level + "й этаж");

                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }
                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                }
                            }
                            if (start_build.equals("oldold")) {
                                way_list.add("au"+start_cabinet);
                                way_text.add("Вы тут");
                                if (end_build.equals("old")) {
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
                                        way_list.add("upstairs2old");
                                        way_text.add("Дойдите до лестницы и перейдите на "
                                                + end_level + "й этаж");

                                        way_list.add("downstairs" + end_level + end_build);
                                        way_text.add("Вы на " + end_level + "м этаже");
                                    }

                                    way_list.add("au" + end_cabinet);
                                    way_text.add("Вам сюда");
                                } else {
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

                                    way_list.add("downstairs1old"); // лестница первого эажа старого
                                    way_text.add("Вы на 1м этаже");

                                    way_list.add("oldtonew");// переход из старого в новый
                                    way_text.add("Перейдите по коридору в новый корпус");

                                    way_list.add("oldtonewhere");// точка отправки после перехода
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
                        }

                        way.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        prev.setVisibility(View.VISIBLE);

                        way.setImageResource(getResources().getIdentifier(way_list.get(i),"drawable", getPackageName()));
                        waytxt.setText(way_text.get(i));
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainAudi.this);
                        builder.setTitle("Что-то не так (︶︹︺) ")
                                .setMessage("Проверьте правильность ввода:\n" +
                                        "1.Номер обязан содержать только цифры и не более 4х символов или \n" +
                                        "2.Если Вы стоите у входа введите в первое поле Вход или вход\n" +
                                        "3.Если Вам надо к выходу то введите во второе поле Выход или выход\n" +
                                        "4.Если Вам надо в кафе или Вы стоите около кафе, то в поля можно вписать Кафе или кафе\n" +
                                        "5.Если Вам надо в ректорат или Вы стоите около ректората, то в поля можно вписать Ректорат или ректорат")
                                .setCancelable(false)
                                .setNegativeButton("ОК, сейчас исправлю", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) { dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        flag = 0;
                    }
                }

            }

        });
    }

    public void onClickWayBtn( View v ) {
        switch (v.getId()) {
            case R.id.next_step:
                if (i < (way_list.size()-1))
                    i++;
                way.setImageResource(getResources().getIdentifier(way_list.get(i),"drawable", getPackageName()));
                waytxt.setText(way_text.get(i));
                break;
            case R.id.prev_step:
                if (i!=0)
                    i--;
                way.setImageResource(getResources().getIdentifier(way_list.get(i),"drawable", getPackageName()));
                waytxt.setText(way_text.get(i));
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