package com.stankingo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends Activity {

    private final int STORAGE_PERMISSION_CODE = 1;
    static ArrayList<DBHelp> data = new ArrayList<>();
    Context cc;

    private void requestStoragePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            new AlertDialog.Builder(this).setTitle("Разрешение")
                    .setMessage("Разрешение нужно для корректной работы приложения")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                    STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        }else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Load();

        Date currentDate = new Date(System.currentTimeMillis());

        if ((ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            Toast.makeText(MainActivity.this, "all ok", Toast.LENGTH_SHORT).show();
        }
        else{
            requestStoragePermission();
        }

        //NotificationReceiver.scheduleNotification(cc, 100 , "Пара началась", "Название пары");

    }


    public void onClickBtn( View v ) {
        switch (v.getId()) {
            case R.id.but_Audi:
                Intent intent1 = new Intent(this, MainAudi.class);
                startActivity(intent1);

                break;
            case R.id.but_Caf:
                Intent intent2 = new Intent(this, MainCaf.class);
                startActivity(intent2);
                break;
            case R.id.but_Cal:
                Intent intent3 = new Intent(this, MainClasses.class);
                startActivity(intent3);
                break;
            case R.id.but_Help:
                Intent intent4 = new Intent(this, Help.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
    public void Load(){
        if (data.size() == 0) {
            //try {
                File sdcard = Environment.getExternalStorageDirectory();
                //Создаём объект файла
                File file = new File(getApplicationContext().getFilesDir(), "rasp.txt");
                //Read text from file
                StringBuilder text = new StringBuilder();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line = "";

                    while ((line = br.readLine()) != null) {
                        data.add(Edd_Class(line));
                    }
                } catch (IOException e) {
                    //Ошибка
                }

                Log.d("Data", String.valueOf(text));
            //} catch (Exception e) { }
        }

    }

    public DBHelp Edd_Class(String str){
        String[] arr = str.split(",", 7);
        DBHelp dbh = new DBHelp(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
        return dbh;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if ( requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Доступ есть", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Доступа нет", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        data.clear();
        finish();
    }



//    @Override
//    public void onDestroy(){
//        // Очистите все ресурсы. Это касается завершения работы
//        // потоков, закрытия соединений с базой данных и т. д.
//        data.clear();
//
//        super.onDestroy();
//    }



}
