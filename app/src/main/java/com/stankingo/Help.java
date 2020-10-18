package com.stankingo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;


public class Help extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView tv_test3 = (TextView) findViewById(R.id.textView7);
        tv_test3.setText("stankin.project.findway@mail.ru");
        Linkify.addLinks(tv_test3, Linkify.ALL);
    }

}
