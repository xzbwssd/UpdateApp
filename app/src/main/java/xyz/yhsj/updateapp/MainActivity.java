package xyz.yhsj.updateapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import xyz.yhsj.update.UpdateHelper;

public class MainActivity extends AppCompatActivity {
    private Button btn_check;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_check = (Button) findViewById(R.id.check);
        fab = (FloatingActionButton) findViewById(R.id.fab);


        btn_check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateHelper
                        .getInstance()
                        .setCheckType(UpdateHelper.CheckType.check_with_Dialog)
                        .check(MainActivity.this);
            }
        });

        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NotificationUpdateActivity.class));
            }
        });
    }

}