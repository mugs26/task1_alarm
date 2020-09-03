package com.example.task1;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobizent.myapplication.R;

public class tmain extends Activity {
    TextView tv_time;
    Button btn_start,btn_cancel,btn_pause,btn_resume;
    long onpause=0;

    CountDownTimer countDownTimer;
    long totaltime = 2500 * 1000;
    long sec = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        btn_start = (Button) findViewById(R.id.btn_start);
        tv_time = (TextView) findViewById(R.id.tv_time);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_pause = (Button)findViewById(R.id.btn_pause);
        btn_resume= (Button)findViewById(R.id.btn_resume);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    countDownTimer.cancel();
                }catch (Exception e){

                }
                totaltime = 2500 * 1000;
                btn_resume.setEnabled(false);
                btn_pause.setEnabled(true);
                btn_start.setEnabled(false);
                btn_cancel.setEnabled(true);

                fn_countdown(totaltime);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                btn_resume.setEnabled(false);
                btn_pause.setEnabled(false);
                btn_start.setEnabled(true);
                btn_cancel.setEnabled(false);
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    countDownTimer.cancel();
                }catch (Exception e){

                }
                btn_resume.setEnabled(true);
                btn_pause.setEnabled(false);
                btn_start.setEnabled(false);
                btn_cancel.setEnabled(false);
                countDownTimer.cancel();
                totaltime = onpause;
//                onpause = totaltime
            }
        });


        btn_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    countDownTimer.cancel();
                }catch (Exception e){

                }
                fn_countdown(totaltime);

                btn_resume.setEnabled(false);
                btn_pause.setEnabled(true);
                btn_start.setEnabled(true);
                btn_cancel.setEnabled(true);
//                onpause = totaltime
            }
        });


    }

    private void fn_countdown(long time){
        countDownTimer = new CountDownTimer(time, sec) {
            @Override
            public void onTick(long millisUntilFinished) {

                onpause = millisUntilFinished;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                String newtime = hours + ":" + minutes + ":" + seconds;

                if (newtime.equals("0:0:0")) {
                    tv_time.setText("00:00:00");
                } else if ((String.valueOf(hours).length() == 1) && (String.valueOf(minutes).length() == 1) && (String.valueOf(seconds).length() == 1)) {
                    tv_time.setText("0" + hours + ":0" + minutes + ":0" + seconds);
                } else if ((String.valueOf(hours).length() == 1) && (String.valueOf(minutes).length() == 1)) {
                    tv_time.setText("0" + hours + ":0" + minutes + ":" + seconds);
                } else if ((String.valueOf(hours).length() == 1) && (String.valueOf(seconds).length() == 1)) {
                    tv_time.setText("0" + hours + ":" + minutes + ":0" + seconds);
                } else if ((String.valueOf(minutes).length() == 1) && (String.valueOf(seconds).length() == 1)) {
                    tv_time.setText(hours + ":0" + minutes + ":0" + seconds);
                } else if (String.valueOf(hours).length() == 1) {
                    tv_time.setText("0" + hours + ":" + minutes + ":" + seconds);
                } else if (String.valueOf(minutes).length() == 1) {
                    tv_time.setText(hours + ":0" + minutes + ":" + seconds);
                } else if (String.valueOf(seconds).length() == 1) {
                    tv_time.setText(hours + ":" + minutes + ":0" + seconds);
                } else {
                    tv_time.setText(hours + ":" + minutes + ":" + seconds);
                }


            }

            @Override
            public void onFinish() {
                tv_time.setText(00 + ":" + 00 + ":" + 00);
            }
        }.start();
    }


}

