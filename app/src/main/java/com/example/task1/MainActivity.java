
package com.example.task1;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.zip.DataFormatException;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Parcelable;
import android.provider.Settings;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.mobizent.myapplication.R;


public class MainActivity extends AppCompatActivity {
    TimePicker tp_time;
    TextView tv_display;
    Button btn_set, btn_reset,btn_cancel,btn_weekly;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainss);

        tv_display = (TextView)findViewById(R.id.tv_display);
        tp_time = (TimePicker)findViewById(R.id.tp_time);
        btn_set = (Button)findViewById(R.id.btn_set);
        btn_reset = (Button)findViewById(R.id.btn_reset);
        btn_weekly = (Button)findViewById(R.id.btn_weeklyalarm);

        btn_cancel=(Button)findViewById(R.id.btn_cancel);
         alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_menu.flag=true;
                Intent myIntent = new Intent(getApplicationContext(), com.example.task1.AlarmAdapter.class);
                myIntent.putExtra("req",1);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        getApplicationContext(), 1, myIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.cancel(pendingIntent);
            }
        });

        btn_weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, B.class);
                MainActivity.this.startActivity(myIntent);
            }
        });



        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                if(Build.VERSION.SDK_INT >= 23) {

                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            tp_time.getHour(),
                            tp_time.getMinute(),
                            0
                    );



                }else{
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            tp_time.getCurrentHour(),
                            tp_time.getCurrentMinute(),
                            0
                    );
                }


                setAlarm(calendar.getTimeInMillis(), calendar);
            }


            private void setAlarm(long timeInMillis, Calendar c) {


                Intent intent = new Intent(MainActivity.this, com.example.task1.AlarmAdapter.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

                alarmManager.setRepeating(AlarmManager.RTC, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);

                Toast.makeText(MainActivity.this, "Alarm Set", Toast.LENGTH_SHORT).show();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                int ampm = c.get(Calendar.AM_PM);
                String day = "";
                if(ampm == Calendar.AM){
                    day = "AM";
                }else if(ampm == Calendar.PM){
                    day = "PM";
                }
                String timeText = "Alarm set for: ";
                timeText += hour +": " + minute + " " + day;
                tv_display.setText(timeText);

            }


        });




        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent intent = new Intent(MainActivity.this, AlarmAdapter.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

                alarmManager.cancel(pendingIntent);

                tv_display.setText("Alarm not set");

            }
        });
    }
}
