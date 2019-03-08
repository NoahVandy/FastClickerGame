package com.example.fastclickergame;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_click1, btn_click2, btn_click3, btn_click4;
    TextView tv_timeLeft, tv_totalClicks;
    int clickCounter = 0;
    int secondsLeft = 20;
    int buttonTime = 2;
    Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_click1 = findViewById(R.id.btn_click1);
        btn_click2 = findViewById(R.id.btn_click2);
        btn_click3 = findViewById(R.id.btn_click3);
        btn_click4 = findViewById(R.id.btn_click4);



        btn_click1.setEnabled(false);
        btn_click2.setEnabled(false);
        btn_click3.setEnabled(false);
        btn_click4.setEnabled(false);


        // end of game limit timer.
        final CountDownTimer timeCounter = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsLeft--;
                buttonTime--;
                if(buttonTime<=0){
                    btn_click1.setBackgroundResource(R.color.startColor14);
                    btn_click2.setBackgroundResource(R.color.startColor23);
                    btn_click3.setBackgroundResource(R.color.startColor23);
                    btn_click4.setBackgroundResource(R.color.startColor14);
                }
            }

            @Override
            public void onFinish() {
                secondsLeft--;
                btn_start.setEnabled(true);

            }
        };

        // this timer trigger a button to become active every 1/2 second
        final CountDownTimer timer = new CountDownTimer(20000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_timeLeft.setText("Time left: " + secondsLeft);
                if(buttonTime > 0) {


                    if (rng.nextInt(4) == 0) {
                        btn_click1.setEnabled(true);
                        btn_click1.setBackgroundResource(R.color.activebutton);
                    } else if (rng.nextInt(4) == 1) {
                        btn_click2.setEnabled(true);
                        btn_click2.setBackgroundResource(R.color.activebutton);
                    } else if (rng.nextInt(4) == 2) {
                        btn_click3.setEnabled(true);
                        btn_click3.setBackgroundResource(R.color.activebutton);
                    } else if (rng.nextInt(4) == 3) {
                        btn_click4.setEnabled(true);
                        btn_click4.setBackgroundResource(R.color.activebutton);
                    }
                }else{
                    btn_click1.setEnabled(false);
                    btn_click2.setEnabled(false);
                    btn_click3.setEnabled(false);
                    btn_click4.setEnabled(false);
                    timeCounter.cancel();
                    btn_start.setEnabled(true);
                }
            }


            @Override
            public void onFinish() {


            }
        };
        // this timer trigger a button to become active every 1/2 second
        final CountDownTimer timer1 = new CountDownTimer(20000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_timeLeft.setText("Time left: " + secondsLeft);
                if(buttonTime > 0) {


                    if (rng.nextInt(4) == 0) {
                        btn_click1.setEnabled(true);
                        btn_click1.setBackgroundResource(R.color.activebutton);
                    } else if (rng.nextInt(4) == 1) {
                        btn_click2.setEnabled(true);
                        btn_click2.setBackgroundResource(R.color.activebutton);
                    } else if (rng.nextInt(4) == 2) {
                        btn_click3.setEnabled(true);
                        btn_click3.setBackgroundResource(R.color.activebutton);
                    } else if (rng.nextInt(4) == 3) {
                        btn_click4.setEnabled(true);
                        btn_click4.setBackgroundResource(R.color.activebutton);
                    }
                }else{
                    btn_click1.setEnabled(false);
                    btn_click2.setEnabled(false);
                    btn_click3.setEnabled(false);
                    btn_click4.setEnabled(false);
                    timeCounter.cancel();
                    btn_start.setEnabled(true);
                }
            }


            @Override
            public void onFinish() {


            }
        };

        tv_timeLeft = findViewById(R.id.tv_timeLeft);
        tv_totalClicks = findViewById(R.id.tv_totalClicks);

        btn_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter++;
                btn_click1.setBackgroundResource(R.color.startColor14);
                tv_totalClicks.setText("Number of clicks: " + clickCounter);
                buttonTime = 2;
                btn_click1.setEnabled(false);
            }
        });

        btn_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter++;
                btn_click2.setBackgroundResource(R.color.startColor23);
                tv_totalClicks.setText("Number of clicks: " + clickCounter);
                buttonTime = 2;
                btn_click2.setEnabled(false);
            }
        });

        btn_click3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter++;
                btn_click3.setBackgroundResource(R.color.startColor23);
                tv_totalClicks.setText("Number of clicks: " + clickCounter);
                buttonTime = 2;
                btn_click3.setEnabled(false);
            }
        });

        btn_click4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCounter++;
                btn_click4.setBackgroundResource(R.color.startColor14);
                tv_totalClicks.setText("Number of clicks: " + clickCounter);
                buttonTime = 2;
                btn_click4.setEnabled(false);
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondsLeft = 20;
                clickCounter = 0;
                tv_totalClicks.setText("Number of clicks: " + clickCounter);
                tv_timeLeft.setText("Time left: " + secondsLeft);

                timeCounter.start();
                btn_start.setEnabled(false);
                buttonTime = 2;
                if(timer == null) {
                    timer.cancel();
                }else{
                    timer.start();
                }
                if(timer1 == null) {
                    timer1.cancel();
                }else{
                    timer1.start();
                }

            }
        });

    }
}

