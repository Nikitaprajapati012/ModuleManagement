package com.example.nikita.modulemanagement;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mylibrary.Activity.MvpMainActivity;

public class MainActivity extends AppCompatActivity {
    MvpMainActivity mvpMainActivity;
    TextView textView;
    private static MvpMainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mvpMainActivity = new MvpMainActivity();
//        new Connection(mvpMainActivity).execute();
//       mvpMainActivity.setDataInList();
//        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
//        intent.setComponent(new ComponentName("packagename//com.example.mylibrary",
//                "classname//com.example.mylibrary.Activity.MvpMainActivity"));
//        startActivity(intent);
        Intent intent = null;
        try {
            intent = new Intent(this, Class.forName("com.example.mylibrary.Activity.MvpMainActivity"));
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
