package com.example.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobizent.myapplication.R;

public class main_menu extends Activity {
    Button btn_alarm, btn_timer,btn_stopwatch,weekly;
    public static boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn_alarm=(Button)findViewById(R.id.alarm_btn);
         btn_timer =(Button)findViewById(R.id.timer_btn);
         btn_stopwatch=(Button)findViewById(R.id.stopwatch_btn);
         weekly=(Button)findViewById(R.id.weekly_btn);

         btn_alarm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent myIntent = new Intent(main_menu.this, MainActivity.class);
                 main_menu.this.startActivity(myIntent);
             }
         });

         btn_timer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent myIntent = new Intent(main_menu.this, tmain.class);
                 main_menu.this.startActivity(myIntent);
             }
         });

         btn_stopwatch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent myIntent = new Intent(main_menu.this, stopwatch.class);
                 main_menu.this.startActivity(myIntent);
             }
         });

         weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(main_menu.this, B.class);
                 main_menu.this.startActivity(myIntent);
            }
        });


    }
}
