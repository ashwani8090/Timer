package com.example.timer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {


    Button start, stop;
    Boolean running = false;
    CountDownTimer CountTimer;
    private TextView timer;
    private int time = 60000;
    private CountDownTimer Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.textView);
        start = findViewById(R.id.button);


        CountTimer = new CountDownTimer(time, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.format("%d", (millisUntilFinished /360000)%60)

                        +":"+String.format("%d", (millisUntilFinished /1000)%60));


            }

            @Override
            public void onFinish() {

            }
        };


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startStop();


            }
        });


    }

    private void startStop() {

        if (running) {
            start.setText("Start");
            StopTimer();
        } else {
            start.setText("Reset");
            StartTimer();
        }


    }

    private void StartTimer() {


        CountTimer.start();


        running = true;
    }

    private void StopTimer() {


        CountTimer.cancel();
       timer.setText("00:00");

        running = false;

    }


}
