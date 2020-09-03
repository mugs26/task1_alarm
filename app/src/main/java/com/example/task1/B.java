package com.example.task1;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

import com.example.task1.AlarmReceiver;
import com.mobizent.myapplication.R;

import java.util.ArrayList;
import java.util.Calendar;

public class B extends Activity implements  View.OnClickListener {

    CheckBox chk_sunday,chk_monday,chk_tuesday,chk_wednesday,chk_thursday,chk_friday,chk_sat;
    ArrayList<AlarmManager>alm_list=new ArrayList<>();
    ArrayList<String>stringArrayList=new ArrayList<>();
    ArrayList<PendingIntent>pIntent=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainss);
        chk_sunday=findViewById(R.id.checkBox);
        chk_monday=findViewById(R.id.checkBox2);
        chk_tuesday=findViewById(R.id.checkBox3);
        chk_wednesday=findViewById(R.id.checkBox4);
        chk_thursday=findViewById(R.id.checkBox5);
        chk_friday=findViewById(R.id.checkBox6);
        chk_sat=findViewById(R.id.checkBox7);

        chk_sunday.setOnClickListener(this);
        chk_monday.setOnClickListener(this);
        chk_tuesday.setOnClickListener(this);
        chk_wednesday.setOnClickListener(this);
        chk_thursday.setOnClickListener(this);
        chk_friday.setOnClickListener(this);
        chk_sat.setOnClickListener(this);
    }


    public void forday(int week )
    {

        Calendar calSet = Calendar.getInstance();
        calSet.set(Calendar.DAY_OF_WEEK, week);
        calSet.set(Calendar.HOUR_OF_DAY, 14);
        calSet.set(Calendar.MINUTE, 5);
        calSet.set(Calendar.SECOND, 0);
        calSet.set(Calendar.MILLISECOND, 0);
        Intent intent = new Intent(B.this, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(B.this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                calSet.getTimeInMillis(), 24 * 7 * 60 * 60 * 1000 , alarmIntent);
        alm_list.add(alarmManager);
        pIntent.add(alarmIntent);

    }


    @Override
    public void onClick(View view) {
        if (chk_monday.isChecked()) {
            forday(2);

            stringArrayList.add("2");
        }

            else if(!chk_monday.isChecked())
            {
                if(stringArrayList.contains("2")) {
                    int index= stringArrayList.indexOf("2");
                    removefromAlm(index);
                }
            }
        if (chk_tuesday.isChecked()) {
            forday(3);

        }else if(!chk_tuesday.isChecked())
        {
            if(stringArrayList.contains("2")) {
                int index= stringArrayList.indexOf("2");
                removefromAlm(index);
            }
        }

        if (chk_wednesday.isChecked()) {
            forday(4);

        } else if(!chk_wednesday.isChecked())
        {
            if(stringArrayList.contains("2")) {
                int index= stringArrayList.indexOf("2");
                removefromAlm(index);
            }
        }
        if (chk_thursday.isChecked()) {
            forday(5) ;

        }
        else if(!chk_thursday.isChecked())
        {
            if(stringArrayList.contains("2")) {
                int index= stringArrayList.indexOf("2");
                removefromAlm(index);
            }
        }if (chk_friday.isChecked()) {
            forday(6);

        } else if(!chk_friday.isChecked())
        {
            if(stringArrayList.contains("2")) {
                int index= stringArrayList.indexOf("2");
                removefromAlm(index);
            }
        }  if (chk_sat.isChecked()) {
            forday(7);

        } else if(!chk_sat.isChecked())
        {
            if(stringArrayList.contains("2")) {
                int index= stringArrayList.indexOf("2");
                removefromAlm(index);
            }
        }  if (chk_sunday.isChecked()) {
            forday(1);

        }
        else if(!chk_sunday.isChecked())
        {
            if(stringArrayList.contains("2")) {
                int index= stringArrayList.indexOf("2");
                removefromAlm(index);
            }
        }
    }

    private void removefromAlm(int i) {
        AlarmManager alm=alm_list.get(i);
        alm.cancel(pIntent.get(i));

        alm_list.remove(i);
        pIntent.remove(i);

    }
}
